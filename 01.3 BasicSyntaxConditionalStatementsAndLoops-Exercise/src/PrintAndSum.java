import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = Integer.parseInt(input.nextLine());
        int end = Integer.parseInt(input.nextLine());
        int sum = 0;

        for (int i = start; i <= end; i++){
            System.out.printf("%d ", i);
            sum += i;
        }
        System.out.printf("%nSum: %d", sum);

    }
}
