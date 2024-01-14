import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] mainArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isNotEqual = true;
        for (int i = 0; i < mainArr.length; i++){
            int sumLeft = 0;
            int sumRight = 0;
            if (i > 0){
                for (int j = i - 1; j > -1; j --){
                    sumLeft += mainArr[j];
                }
            }
            if (i < mainArr.length - 1){
                for (int k = i + 1; k < mainArr.length; k ++){
                    sumRight += mainArr[k];
                }
            }
            if (sumLeft == sumRight){
                System.out.print(i);
                isNotEqual = false;
            }
        }
        if (isNotEqual){
            System.out.print("no");
        }
    }
}
