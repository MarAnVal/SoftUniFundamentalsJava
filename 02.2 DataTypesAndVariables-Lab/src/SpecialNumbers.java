import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //A number is special when its sum of digits is 5, 7, or 11.
        //Write a program to read an integer n
        //for all numbers in the range 1…n to print the number and if it is special or not (True / False).
        int n = Integer.parseInt(input.nextLine());
        for (int i = 1; i < n +1; i++){
            int currentNum = i;
            int sum = 0;
            while (currentNum != 0){
                sum += currentNum % 10;
                currentNum = currentNum / 10;
            }
            System.out.printf("%d -> ", i);
            if (sum == 7 || sum == 5 || sum == 11){
                System.out.println("True");
            } else
                System.out.println("False");
        }
    }
}
