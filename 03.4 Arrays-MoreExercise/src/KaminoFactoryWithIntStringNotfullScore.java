import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactoryWithIntStringNotfullScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· The first line holds the length of the sequences – integer in the range [1…100].
        //· On the next lines, until you receive "Clone them!"
        // you will be receiving sequences (at least one) of ones and zeroes,
        // split by "!" (one or several).
        int n = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        int index = n +1;
        int maxSum = 0;
        int count = 1;
        int bestCount = 0;
        int [] bestSequence = new int[n];
        int allOnes = 0;
        int bufferOnes;
        String sequence;
        boolean flag;

        while (!line.equals("Clone them!")){
            // remove multiple !
            bufferOnes = 0;
            for (int i = 0; i < line.length() - 1; i++){
                if (line.charAt(i) == '!' & line.charAt(i+1) == '!'){
                    line = line.substring(0, i) + line.substring(i +1);
                    i = -1;
                }
            }
            // add the string to int array
            if (line.length() > 2 * n){
                sequence = line.substring(0, 2 * n);
                line = line.substring(2 * n);
                flag = false;
            }
            else {sequence = line; flag = true;}
            int [] dnaArr = Arrays.stream(sequence.split("!")).mapToInt(Integer::parseInt).toArray();

            // find the sequence sum
            for (int j : dnaArr) {
                if (j == 1) {
                    bufferOnes++;
                }
            }
            int bufferSum = 0;
            int bufferIndex = n +1;
            boolean isEqual = false;
            for (int i = 0; i < n - 1; i++){
                if ((dnaArr[i] == 1) && (dnaArr[i + 1] == 1)){
                    if (!isEqual) {bufferSum = 1; bufferIndex = i;}
                    bufferSum++;
                    isEqual = true;
                } else {
                    if (bufferSum > maxSum){
                        maxSum = bufferSum;
                        index = bufferIndex;
                        bestCount = count;
                        System.arraycopy(dnaArr, 0, bestSequence, 0, n);
                        allOnes = bufferOnes;
                    } else if (bufferSum == maxSum){
                        if (bufferIndex < index){
                            index = bufferIndex;
                            for (int w = 0; w < n; w++){
                                bestSequence[w] = dnaArr[w];
                                allOnes = bufferOnes;
                                bestCount = count;
                            }
                        } else if ((bufferIndex == index) && (allOnes < bufferOnes)){
                            System.arraycopy(dnaArr, 0, bestSequence, 0, n);
                            bestCount = count;
                            allOnes = bufferOnes;
                        }
                    }
                }
            }


            count++;
            if (flag){
                line = input.nextLine();
            }
        }
        //The output should be printed on the console and consists of two lines in the following format:
        //"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
        //"{DNA sequence, joined by space}"
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestCount, allOnes);
        for (int item: bestSequence){
            System.out.print(item + " ");
        }
    }
}
