import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> theList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        //Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:
        String commandStr = input.nextLine();
        while (!commandStr.equals("end")) {
            String[] commandArr = commandStr.split(" ");
            switch (commandArr[0]) {
                //Add {number}: add a number to the end of the list
                case "Add":
                    int number = Integer.parseInt(commandArr[1]);
                    theList.add(number);
                    break;
                //Remove {number}: remove a number from the list
                case "Remove":
                    int element = Integer.parseInt(commandArr[1]);
                    theList.remove(Integer.valueOf(element));
                    break;
                //RemoveAt {index}: remove a number at a given index
                case "RemoveAt":
                    int index = Integer.parseInt(commandArr[1]);
                    theList.remove(index);
                    break;
                //Insert {number} {index}: insert a number at a given index
                case "Insert":
                    int toInsert = Integer.parseInt(commandArr[1]);
                    int indexToInsert = Integer.parseInt(commandArr[2]);
                    theList.add(indexToInsert, toInsert);
                    break;
            }
            commandStr = input.nextLine();
        }
        //When you receive the "end" command, print the final state of the list (separated by spaces).
        System.out.println(theList.toString().replaceAll("[\\[\\],]" , ""));
    }
}
