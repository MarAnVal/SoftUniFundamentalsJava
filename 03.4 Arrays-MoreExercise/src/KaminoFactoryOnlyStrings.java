import java.util.Objects;
import java.util.Scanner;

public class KaminoFactoryOnlyStrings {
    public static String onlyNums(String stt){
        stt = stt.replaceAll("!", "");
        if (stt.isEmpty()){
            stt = "0";
        }
        return stt;
    }
    public static String maxSequenceOnlyNums(String stt){
        String stt1 = onlyNums(stt);
        String [] arr = stt1.split("0");
        int sum = 0;
        String maxSequence = "0";
        int curentSequence;
        for (String s : arr) {
            sum += s.length();
            curentSequence = s.length();
            if (curentSequence > toInt(maxSequence)) {
                maxSequence = curentSequence + "";
            }
        }
        if (sum == 0){
            return "0";
        } else {
            return maxSequence;
        }
    }
    public static String maxOnesIncludeOnlyNums(String stt){
        stt = onlyNums(stt);
        int sum = 0;
        String textSum;
        for (int i = 0; i < stt.length(); i++){
            if(stt.charAt(i) == '1'){
                sum++;
            }
        }
        textSum = "" + sum;
        return textSum;
    }
    public static String index (String stt, int size){
        stt = onlyNums(stt);
        String [] arr = stt.split("0");
        int sum = 0;
        int maxSequence = 0;
        int curentSequence;
        String sequence = "";
        int index;
        for (String s : arr) {
            sum += arr.length;
            curentSequence = s.length();
            if (curentSequence > maxSequence) {
                maxSequence = curentSequence;
                sequence = s;
            }
        }
        if (sum == 0){
            return "0";
        } else {
            index = size - stt.indexOf(sequence);
            return "" + index;
            //returns the index reversed for easier operations later
        }
    }
    public static void assignValueArr (String [] arr1, String [] arr2){
        // both arrays have same length and arr1 assign the value of arr2
        for (int i = 0; i < arr1.length; i++){
            if (Objects.equals(arr1[i], "")){
                arr1[i] = "0";
            }
            arr1[i] = arr2[i];
        }
    }
    public static void addValueResult(String[] arr1, String stt, int size, int testCount){
        // maxSequence, indexReversed, OnesIncluded, sequence
        arr1[0] = maxSequenceOnlyNums(stt);
        arr1[1] = index(stt, size);
        arr1[2] = maxOnesIncludeOnlyNums(stt);
        arr1[3] = onlyNums(stt);
        arr1[4] = testCount + "";
    }
    public static String bestDNAprint(String [] arr, int size){
        // return the element with the sample of the result's array as string with needed lenght if the original string starts with 0
        String print = arr[3];
        for (int i = 0; i < size; i++){
            if (print.length()< size){
                print = "0" + print;
            } else break;
        }
        for (int i = 1; i < print.length() ; i+=2){
            print = print.substring(0,i) + " " + print.substring(i);
        }
        return print;
    }
    public static String print (String[] arr, int size){
        //"Best DNA sample {testCount} with sum: {bestSequenceSum}."
        //"{DNA sequence, joined by space}"
        return "Best DNA sample " + arr[4] + " with sum: " + arr[2] + ".%n" + bestDNAprint(arr, size);
    }
    public static int toInt (String stt){
        if (Objects.equals(stt, "")){
            stt = "0";
        }
        return Integer.parseInt(stt);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        String [] currentBestResult = new String[5];// maxSequence, indexReversed, OnesIncluded, DNAonlyNums, testNum
        String [] result = new String[5];
        int testCount = 1;
        addValueResult(result,line,size,testCount);
        while (!line.equals("Clone them!")){
            addValueResult(currentBestResult, line, size,testCount);
            for (int i = 0;i < currentBestResult.length - 2; i++){
                // check without last element where is the line turned in nums without 0 in front
                if (toInt(currentBestResult[i]) > toInt(result[i])){
                    assignValueArr(result, currentBestResult);
                    break;
                } else if (toInt(currentBestResult[i]) < toInt(result[i])){
                    break;
                } else if ((i == currentBestResult.length - 3) && toInt(currentBestResult[2]) == 0) {
                    if (toInt(result[4]) == 0) {
                        result[4] = currentBestResult[4];
                    }
                }
            }
            line = input.nextLine();
            testCount++;
        }
        System.out.printf(print(result, size));

    }
}

