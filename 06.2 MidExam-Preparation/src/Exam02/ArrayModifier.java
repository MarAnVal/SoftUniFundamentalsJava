package Exam02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] numbersArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //On the first input line, you will be given the initial array values separated by a single space.
        //On the next lines you will receive commands until you receive the command "end". The commands are as follow:
        String commandStr = input.nextLine();

        while(!commandStr.equals("end")){
            String [] commandArr = commandStr.split(" ");
            switch (commandArr[0]){
            //"swap {index1} {index2}" takes two elements and swap their places.
                case "swap":
                    int indexSwapOne = Integer.parseInt(commandArr[1]);
                    int indexSwapTwo = Integer.parseInt(commandArr[2]);
                    int bufferElement = numbersArr[indexSwapOne];
                    numbersArr[indexSwapOne] = numbersArr[indexSwapTwo];
                    numbersArr[indexSwapTwo] = bufferElement;
                    break;
            //"multiply {index1} {index2}" takes element at the 1st index and multiply it with the element at 2nd index.
            // Save the product at the 1st index.
                case "multiply":
                    int indexMultiplyOne = Integer.parseInt(commandArr[1]);
                    int indexMultiplyTwo = Integer.parseInt(commandArr[2]);
                    int product = numbersArr[indexMultiplyOne] * numbersArr[indexMultiplyTwo];
                    numbersArr[indexMultiplyOne] = product;
                    break;
            //"decrease" decreases all elements in the array with 1.
                case "decrease":
                    for (int i = 0; i < numbersArr.length; i++) {
                        numbersArr[i]--;
                    }
                    break;
            }
            commandStr = input.nextLine();
        }
        //The output should be printed on the console and consist of elements of the modified
        //array – separated by a comma and a single space ", ".
        for (int i = 0; i < numbersArr.length; i++) {
            if (i == numbersArr.length - 1){
                System.out.print(numbersArr[i]);
            } else {
                System.out.print(numbersArr[i] + ", ");
            }
        }
    }
}
