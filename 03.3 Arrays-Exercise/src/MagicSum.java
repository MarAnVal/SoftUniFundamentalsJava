import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] theArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < theArr.length - 1; i++){
            for (int j = i + 1; j < theArr.length; j++){
                if (theArr[i] + theArr[j] == n){
                    System.out.printf("%d %d%n", theArr[i], theArr[j]);
                }
            }
        }
    }
}
