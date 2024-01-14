import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = Integer.parseInt(input.nextLine());
        int buffer = number;
        int sum = 0;

        while (buffer != 0){
            int curentNum = buffer % 10;
            int currentSum = 1;
            for (int i = 1; i <= curentNum; i++){
               currentSum *= i;
            }
            sum += currentSum;
            buffer /= 10;
        }
        if (number == sum){
            System.out.print("yes");
        } else
            System.out.print("no");

    }
}
