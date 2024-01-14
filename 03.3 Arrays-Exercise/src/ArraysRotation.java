import java.util.Arrays;
import java.util.Scanner;

public class ArraysRotation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                int [] mainArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(input.nextLine());

        for (int j = 0; j < rotations; j++){
            int buffer = mainArr[0];
            for (int i = 0; i < mainArr.length - 1; i ++){
                mainArr[i] = mainArr[i + 1];
            }
            mainArr[mainArr.length - 1] = buffer;
        }
        for (int item: mainArr){
            System.out.print(item + " ");
        }
    }
}
