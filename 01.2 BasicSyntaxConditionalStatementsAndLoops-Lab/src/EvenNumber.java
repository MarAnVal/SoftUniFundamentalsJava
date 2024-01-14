import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        while (num % 2 != 0){
            System.out.println("Please write an even number.");
            num = Integer.parseInt(input.nextLine());
        }
        System.out.printf("The number is: %d",Math.abs(num));
    }
}
