import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int [] reversedArr = new int[n];
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(input.nextLine());
            reversedArr[n-1-i] = num;
        }
        for (int item : reversedArr) {
            System.out.print(item + " ");
        }
    }
}
