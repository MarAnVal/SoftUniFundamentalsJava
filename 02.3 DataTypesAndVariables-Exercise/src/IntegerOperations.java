import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        num += Integer.parseInt(input.nextLine());
        num /= Integer.parseInt(input.nextLine());
        num *= Integer.parseInt(input.nextLine());
        System.out.println(num);
    }
}
