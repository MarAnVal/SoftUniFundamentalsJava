import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will receive two lines, each containing a floating-point number.
        // Your task is to compare the values of the two numbers.
        // eps = 10^-6
        double num1 = Double.parseDouble(input.nextLine());
        double num2 = Double.parseDouble(input.nextLine());

        num1 = num1 * Math.pow(10, 6);
        num2 = num2 * Math.pow(10, 6);
        long buffer1 = (long) num1;
        long buffer2 = (long) num2;
        if (buffer1 == buffer2){
            System.out.println("True");
        } else
            System.out.println("False");


    }
}
