import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] firstArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] secondArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < firstArr.length; i++){
            if (firstArr[i] != secondArr[i]){
                sum = i;
                flag = false;
                break;
            } else {
                sum += firstArr[i];
            }

        }
        if (flag){
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else
            System.out.printf("Arrays are not identical. Found difference at %d index.", sum);
    }
}
