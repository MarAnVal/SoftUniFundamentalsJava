package Exam06;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the 1st line, you are going to receive the status of the pirate ship (integers separated by '>')
        int [] pirateShip = Arrays.stream(input.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        //On the 2nd line, you are going to receive the status of the warship
        int [] warShip = Arrays.stream(input.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        //On the 3rd line, you will receive the maximum health a section of a ship can reach.
        int maxHealth = Integer.parseInt(input.nextLine());
        //On the following lines, until "Retire", you will be receiving commands.
        String commandStr = input.nextLine();
        boolean dead = false;

        while (!commandStr.equals("Retire")){
            String [] commandArr = commandStr.split(" ");
            switch (commandArr[0]){
                //"Fire {index} {damage}" - the pirate ship attacks the warship with the given damage at that section.
                // Check if the index is valid and if not, skip the command.
                // If the section breaks (health <= 0) the warship sinks, print the following and stop the program:
                // "You won! The enemy ship has sunken."
                case "Fire":
                    int fireIndex = Integer.parseInt(commandArr[1]);
                    if (fireIndex >= 0 && fireIndex < warShip.length){
                        int fireDamage = Integer.parseInt(commandArr[2]);
                        warShip[fireIndex] -= fireDamage;
                        if (warShip[fireIndex] <= 0){
                            System.out.println("You won! The enemy ship has sunken.");
                            dead = true;
                        }
                    }
                    break;
                //"Defend {startIndex} {endIndex} {damage}" - the warship attacks the pirate ship with the given
                // damage at that range (indexes are inclusive).
                // Check if both indexes are valid and if not, skip the command.
                // If the section breaks (health <= 0) the pirate ship sinks, print the following and stop the program:
                //"You lost! The pirate ship has sunken."
                case "Defend":
                    int defendStartIndex = Integer.parseInt(commandArr[1]);
                    int defendEndIndex = Integer.parseInt(commandArr[2]);
                    if (defendStartIndex >= 0 && defendStartIndex < pirateShip.length && defendEndIndex >= 0 && defendEndIndex < pirateShip.length){
                        int defendDamage = Integer.parseInt(commandArr[3]);
                        if (defendStartIndex > defendEndIndex){
                            int buffer = defendStartIndex;
                            defendStartIndex = defendEndIndex;
                            defendEndIndex = buffer;
                        }
                        for (int i = defendStartIndex; i <= defendEndIndex ; i++) {
                            pirateShip[i] -= defendDamage;
                            if (pirateShip[i] <= 0){
                                System.out.println("You lost! The pirate ship has sunken.");
                                dead = true;
                                break;
                            }
                        }
                    }
                    break;
                //"Repair {index} {health}" - the crew repairs a section of the pirate ship with the given health.
                // Check if the index is valid and if not, skip the command.
                // The health of the section cannot exceed the maximum health capacity.
                case "Repair":
                    int repairIndex = Integer.parseInt(commandArr[1]);
                    if (repairIndex >= 0 && repairIndex < pirateShip.length){
                        int repairHealth = Integer.parseInt(commandArr[2]);
                        pirateShip[repairIndex] += repairHealth;
                        if (pirateShip[repairIndex] > maxHealth){
                            pirateShip[repairIndex] = maxHealth;
                        }
                    }
                    break;
                //"Status" - prints the count of all sections of the pirate ship that need repair soon,
                // which are all sections that are lower than 20% of the maximum health capacity. Print the following:
                //"{count} sections need repair."
                case "Status":
                    int count = 0;
                    for (int element: pirateShip) {
                        double percent = 100.0 * element / maxHealth;
                        if (percent < 20){
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }
            if (dead){
                break;
            }
            commandStr = input.nextLine();
        }
        if (!dead){
            int pirateShipSum = 0;
            int warShipSum = 0;
            for (int element: pirateShip) {
                pirateShipSum += element;
            }
            for (int element: warShip) {
                warShipSum += element;
            }
            System.out.printf("Pirate ship status: %d%nWarship status: %d", pirateShipSum, warShipSum);
        }
    }
}
