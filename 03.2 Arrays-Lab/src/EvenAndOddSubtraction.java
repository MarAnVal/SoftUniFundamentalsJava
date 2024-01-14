import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] myArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < myArr.length; i ++){
            if (myArr[i] % 2 == 0){
                sumEven += myArr[i];
            } else
                sumOdd += myArr[i];
        }
        System.out.println(sumEven - sumOdd);
    }
}
