import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        //Read an integer n from the console
        printTopNumbers(n);

    }
    public static void printTopNumbers(int n){
        // Find all top numbers in the range [1 … n]
        for (int i = 1; i <= n ; i++) {
            if (isDevidedByEght(i) && isOddDigitIncluded(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isDevidedByEght(int number){
        //· Its sum of digits is divisible by 8, e.g. 8, 16, 88.
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        if (sum % 8 == 0){
            return true;
        } else
            return false;
    }

    public static boolean isOddDigitIncluded(int number){
        //· Holds at least one odd digit, e.g. 232, 707, 87578.
        while (number > 0){
            int digit = number % 10;
            if (digit % 2 != 0){
                return true;
            } else {
                number /= 10;
            }
        }
        return false;
    }
}
