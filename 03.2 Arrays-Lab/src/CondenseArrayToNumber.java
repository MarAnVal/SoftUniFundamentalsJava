import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] mainArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] condensedArr = new int[mainArr.length - 1];

//        for (int i = 0; i < mainArr.length; i++){
//            if (mainArr.length == 1){
//                break;
//            }
//            if (i == mainArr.length - 1){
//                int [] bufferArr = new int [condensedArr.length - 1];
//                mainArr = condensedArr;
//                condensedArr = bufferArr;
//                i = -1;
//            } else
//            condensedArr[i] = mainArr[i] + mainArr[i +1];
//       }
        while (mainArr.length > 1){
        for (int i = 0; i < condensedArr.length; i++){
            condensedArr[i] = mainArr[i] + mainArr[i + 1];
        }
        int [] buffer = new int[condensedArr.length - 1];
        mainArr = condensedArr;
        condensedArr = buffer;
        }
        System.out.println(mainArr[0]);
    }
}
