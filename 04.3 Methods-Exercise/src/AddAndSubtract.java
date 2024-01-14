import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = Integer.parseInt(input.nextLine());
        int number2 = Integer.parseInt(input.nextLine());
        int number3 = Integer.parseInt(input.nextLine());

        System.out.println(subtract(number1, number2, number3));
    }

    public static int sum(int number1, int number2){
        return number1 + number2;
    }

    public static int subtract(int number1, int number2, int number3){
        return sum(number1, number2) - number3;
    }
}
