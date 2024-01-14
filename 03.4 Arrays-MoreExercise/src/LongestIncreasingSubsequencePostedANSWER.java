import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequencePostedANSWER {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Логиката не е ясна???????????
        int [] theArr = Arrays.stream(input.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int maxLength = 0;
        int lastIndex = -1;
        int[] len = new int[theArr.length];
        int[] previous = new int[theArr.length];

        for (int i = 0; i < theArr.length; i++) {
            len[i] = 1;
            previous[i] = -1;

            for (int k = 0; k < i; k++) {
                if (theArr[k] < theArr[i] && len[k] + 1 > len[i]) {
                    len[i] = len[k] + 1;
                    previous[i] = k;
                }
            }

            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }

        int[] lis = new int[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1)  {
            lis[currentIndex] = theArr[lastIndex];
            currentIndex--;
            lastIndex = previous[lastIndex];
        }
        for (int li : lis) {
            System.out.print(li + " ");
        }
    }
}
