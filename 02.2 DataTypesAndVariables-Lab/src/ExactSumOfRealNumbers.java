import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Write a program to enter n numbers and calculate and print their exact sum (without rounding)
        //Use BigDecimal not to lose precision.
        int n = Integer.parseInt(input.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < n; i++){
            BigDecimal currentNum = new BigDecimal(input.nextLine());

            sum = sum.add(currentNum);
        }
        System.out.println(sum);
    }
}
