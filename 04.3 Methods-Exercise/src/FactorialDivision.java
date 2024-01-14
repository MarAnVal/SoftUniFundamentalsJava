import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = Integer.parseInt(input.nextLine());
        int number2 = Integer.parseInt(input.nextLine());
        System.out.printf("%.2f", getDevision(number1, number2));
    }
    public static long getFacrotial(int n){
        long result = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        return result;
    }
    public static double getDevision(int number1, int number2){
        return 1.0 * getFacrotial(number1) / getFacrotial(number2);
    }
}
