import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static String left(int [] arr, int index){
        StringBuilder leftSequence;
        if (index == 0){
            leftSequence = new StringBuilder(arr[0] + "_" + "0");
        } else {
            boolean flag = true;
            int point = index;
            leftSequence = new StringBuilder(arr[index] + "_" + index);
            for (int i = index; i > 0 ; i--){
                if (arr[i] > arr[i - 1] && flag){
                    leftSequence.insert(0, arr[i - 1] + "_" + (i - 1) + " ");
                    point = i - 1;
                } else if (arr[point] > arr[i- 1] && !flag){
                    leftSequence.insert(0, arr[i - 1] + "_" + (i - 1) + " ");
                    flag = true;
                    point = i - 1;
                } else if (arr[point] == arr[i- 1] && !flag){
                    point = i -1;
                } else{
                    flag = false;
                }
            }
        }
        return leftSequence.toString();
    }
    public static String right(int [] arr, int index){
        StringBuilder rightSequence = new StringBuilder();
        if (index != arr.length - 1) {
            boolean flag = true;
            int point = index;
            for (int i = index; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1] && flag) {
                    point = i + 1;
                    rightSequence.append(arr[i + 1]).append("_").append(i + 1).append(" ");
                } else if (arr[point] < arr[i + 1] && !flag) {
                    rightSequence.append(arr[i + 1]).append("_").append(i + 1).append(" ");
                    flag = true;
                    point = i + 1;
                } else if (arr[point] == arr[i + 1] && !flag) {
                    point = i + 1;
                } else {
                    flag = false;
                }
            }
        }
        return rightSequence.toString();
    }
    public static int sequenceLength (String stt){
        String [] arr = stt.split(" ");
        return arr.length;
    }
    public static int index (String stt){
        String [] arrString = stt.split(" ");
        String [] firstElement = arrString[0].split("_");
        return Integer.parseInt(firstElement[1]);
    }

    public static String maxSequence(int [] arr){
        String maxSequence = "";
        String currentSequence;

        for (int i = 0; i < arr.length; i++){
            String left = left(arr, i);
            String right = right(arr, i);
            currentSequence = left + " " + right;
            if (sequenceLength(currentSequence) > sequenceLength(maxSequence)) {
               maxSequence = currentSequence;
            } else if (sequenceLength(currentSequence) == sequenceLength(maxSequence)){
                if (index(currentSequence) < index(maxSequence)){
                    maxSequence = currentSequence;
                }
            }
        }
        return maxSequence;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] theArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String test = maxSequence(theArr);
        System.out.println(test);
    }
}
