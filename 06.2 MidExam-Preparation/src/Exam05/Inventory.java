package Exam05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will receive a journal with some collecting items, separated with a comma and a space (", ").
        //After that, until receiving "Craft!" you will be receiving different commands split by " - "
        List<String> inventory = Arrays.stream(input.nextLine().split(", ")).collect(Collectors.toList());;
        String commandStr = input.nextLine();
        while (!commandStr.equals("Craft!")){
            String[] commandArr = commandStr.split(" - ");
            switch (commandArr[0]){
                //"Collect - {item}" - you should add the given item to your inventory.
                // If the item already exists, you should skip this line.
                case "Collect":
                    String itemToAdd = commandArr[1];
                    if(!inventory.contains(itemToAdd)){
                        inventory.add(itemToAdd);
                    }
                    break;
                //"Drop - {item}" - you should remove the item from your inventory if it exists.
                case "Drop":
                    String itemToRemove = commandArr[1];
                    inventory.remove(itemToRemove);
                    break;
                //"Combine Items - {old_item}:{new_item}" - you should check if the old item exists.
                // If so, add the new item after the old one. Otherwise, ignore the command.
                case "Combine Items":
                    String[] items = commandArr[1].split(":");
                    String oldItem = items[0];
                    String newItem = items[1];
                    if(inventory.contains(oldItem)){
                        int indexToCombine = inventory.indexOf(oldItem) + 1;
                        inventory.add(indexToCombine, newItem);
                    }
                    break;
                //"Renew – {item}" – if the given item exists, you should change its position and put it last in your inventory.
                case "Renew":
                    String itemToRenew = commandArr[1];
                    if(inventory.contains(itemToRenew)){
                        inventory.remove(itemToRenew);
                        inventory.add(itemToRenew);
                    }
                    break;
            }
            commandStr = input.nextLine();
        }
        //After receiving "Craft!" print the items in your inventory, separated by ", ".
        System.out.println(inventory.toString().replaceAll("[\\[\\]]",""));
    }
}
