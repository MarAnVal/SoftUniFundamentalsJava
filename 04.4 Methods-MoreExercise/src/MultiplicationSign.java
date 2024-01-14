import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(input.nextLine());
        }
        printResult(numbers);

    }
    public static boolean isItZero(int [] arr){
        for (int element: arr) {
            if (element == 0){
                return true;
            }
        }
        return false;
    }
    //negative, positive, or zer
    public static void printResult(int [] arr){
        if(!isItZero(arr)){
            if(isItPositive(arr)){
                // positive
                System.out.println("positive");
            } else {
                // negative
                System.out.println("negative");
            }
        } else {
            // zero
            System.out.println("zero");
        }
    }

    public static boolean isItPositive(int [] arr){
        int countNegative = 0;
        for (int element: arr) {
            if (element < 0) {
                countNegative++;
            }
        }
        if (countNegative % 2 != 0){
            return false;
        } else
            return true;
    }
}
