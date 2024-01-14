import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] nums = Arrays.stream(input.nextLine().split( " ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < nums.length; i++){
            boolean isTop = true;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] <= nums[j]){
                    isTop = false;
                    break;
                }
            }
            if (isTop){
                System.out.print(nums[i] + " ");
            }
        }
    }
}
