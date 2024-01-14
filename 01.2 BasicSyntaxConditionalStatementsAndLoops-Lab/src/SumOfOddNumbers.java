import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 1;
        int sum = 0;
        int n = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= n ; i++){
            System.out.println(num);
            sum = sum + num;
            num += 2;
        }
        System.out.printf("Sum: %d", sum);
    }
}
