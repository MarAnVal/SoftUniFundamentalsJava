import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger bigNumber = new BigInteger(input.nextLine());
        int number = Integer.parseInt(input.nextLine());

        BigInteger result = bigNumber.multiply(BigInteger.valueOf(number));
        System.out.println(result);
    }
}
