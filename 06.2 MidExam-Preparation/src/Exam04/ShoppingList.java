package Exam04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will receive an initial list with groceries separated by an exclamation mark "!".
        List<String> items = Arrays.stream(input.nextLine().split("!")).collect(Collectors.toList());
        // you will be receiving 4 types of commands until you receive "Go Shopping!".
        String command = input.nextLine();

        while(!command.equals("Go Shopping!")){
            String[] commandArr = command.split(" ");
            switch (commandArr[0]){
                //"Urgent {item}" - add the item at the start of the list.
                // If the item already exists, skip this command.
                case "Urgent":
                    String urgentItem = commandArr[1];
                    if (!items.contains(urgentItem)){
                        items.add(0, urgentItem);
                    }
                    break;
                //"Unnecessary {item}" - remove the item with the given name, only if it exists in the list.
                // Otherwise, skip this command.
                case "Unnecessary":
                    String unnecessaryItem = commandArr[1];
                    items.remove(unnecessaryItem);
                    break;
                //"Correct {oldItem} {newItem}" - if the item with the given old name exists, change its name with the new one.
                // Otherwise, skip this command.
                case "Correct":
                    String oldItem = commandArr[1];
                    String newItem = commandArr[2];
                    if (items.contains(oldItem)) {
                        int indexToCorrect = items.indexOf(oldItem);
                        items.set(indexToCorrect, newItem);
                    }
                //"Rearrange {item}" - if the grocery exists in the list, remove it from its current position and add it at the end of the list.
                // Otherwise, skip this command.
                case "Rearrange":
                    String rearrangeItem = commandArr[1];
                    if(items.contains(rearrangeItem)){
                        items.remove(rearrangeItem);
                        items.add(rearrangeItem);
                    }
                    break;
            }
            command = input.nextLine();
        }
        System.out.println(items.toString().replaceAll("[\\[\\]]",""));
    }
}
