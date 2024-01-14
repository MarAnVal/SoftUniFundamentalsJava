import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = Integer.parseInt(input.nextLine());
        int num2 = Integer.parseInt(input.nextLine());


        System.out.printf("%d X %d = %d%n", num1, num2, num1*num2);

        for (int i = num2+1; i <= 10; i++){
            System.out.printf("%d X %d = %d%n", num1, i, num1*i);
        }
    }
}
