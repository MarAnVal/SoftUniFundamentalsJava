import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] mainArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 1;
        int [] maxArr = new int[0];
        for (int i = 0; i < mainArr.length - 1; i++){
            for (int j = i + 1; j < mainArr.length; j ++){
                if (mainArr[i] == mainArr[j]){
                    count++;
                    if (j == mainArr.length - 1){
                        int [] buffer = new int[count];
                        for (int l = 0; l < buffer.length; l++){
                            buffer[l] = mainArr[i];
                        }
                        if (buffer.length > maxArr.length){
                            maxArr = buffer;
                        }
                        i = j - 1;
                        count = 1;
                        break;
                    }
                } else {
                    int [] buffer = new int[count];
                    for (int l = 0; l < buffer.length; l++){
                        buffer[l] = mainArr[i];
                    }
                    if (buffer.length > maxArr.length){
                        maxArr = buffer;
                    }
                    i = j - 1;
                    count = 1;
                    break;
                }
            }
        }
        for (int item: maxArr){
            System.out.print(item + " ");
        }
    }
}
