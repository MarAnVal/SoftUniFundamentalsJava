import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        //Read three real numbers and sort them in descending order. Print each number on a new line
        Scanner input = new Scanner(System.in);
        int num1 = Integer.parseInt(input.nextLine());
        int num2 = Integer.parseInt(input.nextLine());
        int num3 = Integer.parseInt(input.nextLine());
        int buffer = 0;

        for (int i = 0; i < 2; i++){
            if (num2 > num1){
                buffer = num1;
                num1 = num2;
                num2 = buffer;

            }
            if (num3 > num2){
                buffer = num2;
                num2 = num3;
                num3 = buffer;
            }
        }
        System.out.printf("%d%n%d%n%d%n", num1, num2, num3);
    }
}
