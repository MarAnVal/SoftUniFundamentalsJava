import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] numsArr = Arrays.stream(input. nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < numsArr.length; i++){
            if (numsArr[i] % 2 == 0){
                sum += numsArr[i];
            }
        }
        System.out.println(sum);
    }
}
