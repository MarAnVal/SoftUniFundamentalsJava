import java.util.Scanner;

public class FribonacciSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = Integer.parseInt(input.nextLine());

        printFibonaci(k);
    }

    public  static long [] getFibonaci (int k){
        long [] arr = new long [k + 1];
        if(k > 0 && k < 3){
            for (int i = 1; i <= k; i++) {
                arr[i] = 1;
            }
            arr[0] = 0;
            return arr;
        } else if (k == 0){
            arr[0] = 0;
            return arr;
        } else {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= k; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr;
        }

    }

    public static void printFibonaci(int k){
        long [] arr = getFibonaci(k);
        for (int i = 1; i <= k; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
