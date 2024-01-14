import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        boolean isNumSpecial = false;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (i > 0) {
                sum += i % 10; i = i / 10; }
            isNumSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            String result = isNumSpecial + "";
            String buffer = result.substring(0,1);
            buffer = buffer.toUpperCase();
            buffer = buffer + result.substring(1,result.length());
            System.out.printf("%d -> %s%n", num, buffer);
            sum = 0;
            i = num;
        }
    }
}
