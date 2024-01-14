import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> theList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String commandStr = input.nextLine();

        while(!commandStr.equals("end")) {
            String [] commandArr = commandStr.split(" ");
            switch (commandArr[0]) {
                //Contains {number} – check if the list contains the number. If yes, print "Yes", otherwise, print "No such number"
                case "Contains":
                    int elementToFind = Integer.parseInt(commandArr[1]);
                    if(theList.contains(elementToFind)){
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                //Print even – print all the numbers that are even separated by a space
                //Print odd – print all the numbers that are oddly separated by a space
                case "Print":
                    int k = 0;
                    if (commandArr[1].equals("odd")){
                        k = 1;
                    }
                    for (int element: theList) {
                        if (element % 2 == k){
                            System.out.print(element + " ");
                        }
                    }
                    System.out.println();
                    break;
                //Get sum – print the sum of all the numbers
                case "Get":
                    long sum = 0;
                    for (int element: theList) {
                        sum += element;
                    }
                    System.out.println(sum);
                    break;
                //Filter {condition} {number} – print all the numbers that fulfill that condition.
                //The condition will be either '<', '>', ">=", "<="
                case "Filter":
                    int fix = 0;
                    String condition = commandArr[1];
                    int number = Integer.parseInt(commandArr[2]);
                    if (condition.length() > 1){
                        fix = 1;
                        condition = condition.substring(0,1);
                    }
                    switch (condition){
                        case "<":
                            number += fix;
                            for (int element:theList){
                            if(element < number){
                                System.out.print(element + " ");
                            }
                        }
                            break;
                        case ">":
                            number -= fix;
                            for (int element:theList){
                                if(element > number){
                                    System.out.print(element + " ");
                                }
                            }
                            break;
                    }
                    System.out.println();
                    break;
            }
            commandStr = input.nextLine();
        }

    }
}
