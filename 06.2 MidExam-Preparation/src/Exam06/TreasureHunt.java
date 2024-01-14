package Exam06;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the 1st line, you are going to receive the initial treasure chest (loot separated by "|")
        List<String> inventory = Arrays.stream(input.nextLine().split("\\|")).collect(Collectors.toList());
        String command = input.nextLine();
        //On the following lines, until "Yohoho!", you will be receiving commands.
        while(!command.equals("Yohoho!")) {
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                //"Loot {item1} {item2}…{itemn}":
                //Pick up treasure loot along the way. Insert the items at the beginning of the chest.
                //If an item is already contained, don't insert it.
                //The loot items will be strings containing any ASCII code.
                case "Loot":
                    for (int i = 1; i < commandArr.length; i++) {
                        String itemToAdd = commandArr[i];
                        if(!inventory.contains(itemToAdd)){
                            inventory.add(0, itemToAdd);
                        }
                    }
                    break;
                //"Drop {index}":
                //Remove the loot at the given position and add it at the end of the treasure chest.
                //If the index is invalid, skip the command.
                //The indexes will be integers in the range [-200…200]
                case "Drop":
                    int indexToDrop = Integer.parseInt(commandArr[1]);
                    if (indexToDrop >= 0 && indexToDrop < inventory.size()){
                        String itemToDrop = inventory.get(indexToDrop);
                        inventory.remove(itemToDrop);
                        inventory.add(itemToDrop);
                    }
                    break;
                //"Steal {count}":
                //Someone steals the last count loot items. If there are fewer items than the given count, remove as much as there are.
                //Print the stolen items separated by ", ":
                //"{item1}, {item2}, {item3} … {itemn}"
                //The count will be an integer in the range [1….100]
                case "Steal":
                    int count = Integer.parseInt(commandArr[1]);
                    if (count > inventory.size()){
                        count = inventory.size();
                    }
                    int indexToSteal = inventory.size() - count;
                    for (int i = count; i > 0; i--) {
                        if (i == 1){
                            System.out.printf("%s%n", inventory.get(indexToSteal));
                        } else {
                            System.out.printf("%s, ", inventory.get(indexToSteal));
                        }
                        inventory.remove(indexToSteal);
                    }
                    break;
            }
            command = input.nextLine();
        }
        //In the end, output the average treasure gain, which is the sum of all treasure items length divided by the count
        //of all items inside the chest formatted to the second decimal point:
        String result = "";
        for (String element:inventory) {
            result += element;
        }
        if (!inventory.isEmpty()) {
            //"Average treasure gain: {averageGain} pirate credits."
            double averageGain = 1.0 * result.length() / inventory.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        } else {
            //If the chest is empty, print the following message:
            //"Failed treasure hunt."
            System.out.println("Failed treasure hunt.");
        }
    }
}
