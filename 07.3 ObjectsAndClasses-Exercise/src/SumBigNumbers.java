import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger firstNumber = new BigInteger(input.nextLine());
        BigInteger secondNumber = new BigInteger(input.nextLine());
        System.out.println(firstNumber.add(secondNumber));
    }
}
