import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        //Print every row of the table in the following format:
        //{theInteger} X {times} = {product}
        for (int i = 1; i <= 10; i++){
            System.out.printf("%d X %d = %d%n", num, i, num*i);
        }
    }
}
