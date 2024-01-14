import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = Integer.parseInt(input.nextLine());
        int number2 = Integer.parseInt(input.nextLine());
        int number3 = Integer.parseInt(input.nextLine());

        System.out.println(minimum(number1, number2, number3));
    }

    public static int minimum(int num1, int num2, int num3) {
        if (num1 <= num2 && num1 <= num3){
            return num1;
        } else if (num2 <= num1 && num2 <= num3){
            return num2;
        } else {
            return num3;
        }

    }
}
