package Exam01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, you will receive a sequence of elements
        //On the following lines, you will receive integers until the command "end"
        List<String> elements = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
        String commandLine = input.nextLine();
        int moves = 0;

        while(!commandLine.equals("end") && !elements.isEmpty()){
            String [] commandArr = commandLine.split(" ");
            moves ++;
            int indexOne = Integer.parseInt(commandArr[0]);
            int indexTwo = Integer.parseInt(commandArr[1]);
            if (indexOne >= 0 && indexOne < elements.size() && indexOne != indexTwo && indexTwo >= 0 && indexTwo < elements.size()){
                String elementOne = elements.get(indexOne);
                String elementTwo = elements.get(indexTwo);
                if (elementOne.equals(elementTwo)){
                    //Every time the player hit two matching elements, you should remove them from the sequence
                    // and print on the console the following message:
                    //"Congrats! You have found matching elements - ${element}!"
                    System.out.printf("Congrats! You have found matching elements - %s!%n", elementOne);
                    if (indexOne > indexTwo){
                        elements.remove(indexOne);
                        elements.remove(indexTwo);
                    } else {
                        elements.remove(indexTwo);
                        elements.remove(indexOne);
                    }
                } else {
                    //If the player hit two different elements, you should print on the console the following message:
                    //"Try again!"
                    System.out.printf("Try again!%n");

                }
            } else {
                //If the player tries to cheat and enters two equal indexes or indexes which are out of bounds of the
                // sequence, you should add two matching elements at the middle of the sequence in the following format:
                //"-{number of moves until now}a"
                //Then print this message on the console:
                //"Invalid input! Adding additional elements to the board"
                String elementToAdd = "-" + moves + "a";
                int indexToAdd = elements.size() / 2;
                elements.add(indexToAdd, elementToAdd);
                elements.add(indexToAdd, elementToAdd);
                System.out.printf("Invalid input! Adding additional elements to the board%n");
            }
            commandLine = input.nextLine();
        }
        if (elements.isEmpty()){
        //If the player hit all matching elements before he receives "end" from the console,
        // you should print on the console the following message:
        //"You have won in {number of moves until now} turns!"
            System.out.printf("You have won in %d turns!", moves);
        } else {
            //If the player receives "end" before he hits all matching elements, you should print on the console the following message:
            //"Sorry you lose :(
            //{the current sequence's state}"
            System.out.printf("Sorry you lose :(%n");
            for (String element: elements) {
                System.out.print(element + " ");
            }
        }
    }
}
