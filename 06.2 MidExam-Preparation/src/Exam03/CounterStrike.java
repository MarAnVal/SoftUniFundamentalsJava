package Exam03;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, you will receive initial energy – an integer [1-10000].
        //On the following lines, you will be receiving the distance of an enemy – an integer [1-10000]
        //Afterward, you will start receiving the distance you need to reach an enemy
        //until the "End of battle" command is given, or you run out of energy.
        int energy = Integer.parseInt(input.nextLine());
        String commandStr = input.nextLine();
        int wonBattles = 0;
        boolean notEnoughEnergy = false;

        while(!commandStr.equals("End of battle")){
            int currentBattle = Integer.parseInt(commandStr);
            if (energy - currentBattle >= 0){
                energy -= currentBattle;
                wonBattles++;
                if (wonBattles % 3 == 0){
                    energy += wonBattles;
                }
            } else {
                notEnoughEnergy = true;
                break;
            }
            commandStr = input.nextLine();
        }
        //"Not enough energy! Game ends with {count} won battles and {energy} energy".
        if (notEnoughEnergy){
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, energy);
        } else {
            //"Won battles: {count}. Energy left: {energy}"
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, energy);
        }
    }
}
