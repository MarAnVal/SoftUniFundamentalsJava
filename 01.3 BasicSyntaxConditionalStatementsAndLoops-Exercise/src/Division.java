import java.util.Scanner;

public class Division {
    public static void main(String[] args) {

        //You will be given an integer
        //2, 3, 6, 7, 10. You should always take the bigger division.
        //If the number is not divisible by any given number, print "Not divisible".
        //Otherwise, print "The number is divisible by {number}".
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        if (num % 10 == 0){
            System.out.printf("The number is divisible by 10");
        } else if (num % 7 == 0){
            System.out.printf("The number is divisible by 7");
        } else if (num % 6 == 0){
            System.out.printf("The number is divisible by 6");
        } else if (num % 3 == 0){
            System.out.printf("The number is divisible by 3");
        } else if (num % 2 == 0){
            System.out.printf("The number is divisible by 2");
        } else
            System.out.print("Not divisible");

    }
}
