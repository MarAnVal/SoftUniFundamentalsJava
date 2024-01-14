import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, the initial array is received as a line of integers, separated by a single space.
        int[] theArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //· On the next lines, until the command "end" is received, you will receive the array manipulation commands.
        //· The input data will always be valid and in the format described. There is no need to check it explicitly.
        String commandStr = input.nextLine();
        while(!commandStr.equals("end")){
            String[] commandArr = commandStr.split(" ");
            switch (commandArr[0]) {
                    //exchange {index} – splits the array after the given index and exchanges the places
                    // of the two resulting subarrays. E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
                    //o If the index is outside the boundaries of the array, print "Invalid index".
                case "exchange":
                    int exchangeIndex = Integer.parseInt(commandArr[1]);
                    if (exchangeIndex >= 0 && exchangeIndex < theArr.length) {
                        int[] subArrStart = new int[exchangeIndex + 1];
                        int[] subArrEnd = new int[theArr.length - subArrStart.length];
                        for (int i = 0; i < subArrStart.length; i++) {
                            subArrStart[i] = theArr[i];
                            theArr[i] = 0;
                        }
                        int k = 0;
                        for (int i = subArrStart.length; i < theArr.length; i++) {
                            subArrEnd[k] = theArr[i];
                            theArr[i] = 0;
                            k++;
                        }
                        for (int i = 0; i < subArrEnd.length; i++) {
                            theArr[i] = subArrEnd[i];
                        }
                        k = 0;
                        for (int i = subArrEnd.length; i < theArr.length; i++) {
                            theArr[i] = subArrStart[k];
                            k++;
                        }
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                    //· max even/odd – returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
                    //o If there are two or more equal min/max elements, return the index of the rightmost one.
                    //o If a min/max even/odd element cannot be found, print "No matches".
                case "max":

                    break;
                    //· min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
                    //o If there are two or more equal min/max elements, return the index of the rightmost one.
                    //o If a min/max even/odd element cannot be found, print "No matches".
                case "min":
                    
                    break;
                    //· first {count} even/odd – returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
                    //o If the count is greater than the array length, print "Invalid count".
                    //o If there are not enough elements to satisfy the count, print as many as you can.
                    // If there are zero even/odd elements, print an empty array "[]".

                    //· last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
                    //o If the count is greater than the array length, print "Invalid count".
                    //o If there are not enough elements to satisfy the count, print as many as you can.
                    // If there are zero even/odd elements, print an empty array "[]".
            }
            commandStr = input.nextLine();
        }

    }
}
