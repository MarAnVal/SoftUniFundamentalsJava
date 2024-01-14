import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        int sum = 0;
        for (int i = 0; i < num.length(); i++){
            sum += (int) num.charAt(i) - 48;
        }
        System.out.println(sum);
    }
}
