import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number = Double.parseDouble(input.nextLine());
        int power = Integer.parseInt(input.nextLine());
        double result = poweredNumber(number, power);
        DecimalFormat df = new DecimalFormat("0.#####");
        System.out.printf(df.format(result));
    }

    public static double poweredNumber(double number, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }
}

