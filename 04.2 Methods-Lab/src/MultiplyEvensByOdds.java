import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());
        number = Math.abs(number);
        System.out.println(getMultipliedSums(number));
    }
    public static int getMultipliedSums(int number){
        String text = "" + number;
        int [] digits = Arrays.stream(text.split("")).mapToInt(Integer::parseInt).toArray();
        return getSum(digits,0) * getSum(digits,1);

    }
    public static int getSum(int [] arr, int start){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if ((arr[i]+start) % 2 == 0){
                //if the number is odd been added odd number to it is getting even so is put start to switch from odd to even
                //when start is even sum is the sum ot odd digits
                //when start is odd sum is the sum of even digits
                sum += arr[i];
            }
        }
        return sum;
    }
}
