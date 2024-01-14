import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulatorNoTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, the initial array is received as a line of integers, separated by a single space.
        //· On the next lines, until the command "end" is received, you will receive the array manipulation commands.
        //· The input data will always be valid and in the format described. There is no need to check it explicitly.
        int [] numbers = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String comandPlusIndex = input.nextLine();

        while (!comandPlusIndex.equals("end")){
            String [] command = comandPlusIndex.split(" ");
            switch (command[0]){
                case "exchange":
                    if (Long.parseLong(command[1]) > numbers.length || Long.parseLong(command[1]) < 0){
                        System.out.println("Invalid index");
                    } else {
                        numbers = exchange(command, numbers);
                    }
                    break;
                case "max":
                    printMax(command, numbers);
                    break;
                case "min":
                    printMin(command, numbers);
                    break;
                case "first":
                    printFirst(command, numbers);
                    break;
                case "last":
                    printLast(command, numbers);
                    break;
                //· end – stop taking input and print the final state of the array.
            }
            comandPlusIndex = input.nextLine();
        }
        System.out.println(formatPrintArr(numbers, numbers.length));
    }

    public static String formatPrintArr(int[] arr, int printedElements){
        if (printedElements == 0){
            return "[]";
        } else {
            String text = "";
            for (int i = 0; i < printedElements; i++) {
                if(i != printedElements - 1){
                    text = text + arr[i] + ", ";
                } else {
                    text = text + arr[i];
                }
            }
            return "[" + text + "]";
        }
    }
     public static int[] reverseArr(int[] arr, int printedElements){
        if (printedElements == 0){
            return arr;
        } else {
            int[] buffer = new int[arr.length];
            int j = 0;
            for (int i = printedElements - 1; i >= 0 ; i--) {
                buffer [j] = arr[i];
                j++;
            }
            return buffer;
        }
     }

    //· exchange {index} – splits the array after the given index and exchanges the places
    // of the two resulting subarrays. E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
    //o If the index is outside the boundaries of the array, print "Invalid index".
    public static int[] exchange(String[] comandArr, int[] theArr) {
        int index = Integer.parseInt(comandArr[1]);
        int [] bufferArr1 = subArr(theArr, index + 1, theArr.length);
        int [] bufferArr2 = subArr(theArr, 0, index + 1);
        fullArr(bufferArr1, bufferArr2, theArr);
        return theArr;
    }

    public static int[] subArr (int[] arr, int start, int end){
        int[] buffer = new int[end - start];
        int k = 0;
        for (int i = start; i < end; i++) {
           buffer[k] = arr[i];
           k++;
        }
        return buffer;
    }

    public static int[] fullArr(int[] infront, int[] back, int[] result){
        int k = 0;
        int l = 0;
        for (int i = 0; i < result.length; i++) {
            if(i < infront.length){
                result[i] = infront[k];
                k++;
            }else {
                result[i] = back[l];
                l++;
            }
        }
        return result;
    }

    //· max even/odd – returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
    //o If there are two or more equal min/max elements, return the index of the rightmost one.
    //o If a min/max even/odd element cannot be found, print "No matches".
    public static void printMax(String [] command, int[] theArr){
        switch (command[1]){
            case "even":
                System.out.println(maxEvenIndex(theArr));
                break;
            case "odd":
                System.out.println(maxOddIndex(theArr));
                break;
        }
    }

    public static String maxEvenIndex(int[] theArr){
        int maxElement = 0;
        int maxIndex = -1;
        for (int i = 0; i < theArr.length; i++) {
            if (theArr[i] % 2 == 0){
                if(maxIndex == -1){
                    maxElement = theArr[i];
                    maxIndex = i;
                } else if (maxElement < theArr[i]){
                    maxElement = theArr[i];
                    maxIndex = i;
                }
            }
        }
        if (maxIndex == - 1){
            return "No matches";
        } else {
            return maxIndex + "";
        }
    }

    public static String maxOddIndex(int[] theArr){
        int maxElement = 0;
        int maxIndex = -1;
        for (int i = 0; i < theArr.length; i++) {
            if (theArr[i] % 2 != 0){
                if(maxIndex == -1){
                    maxElement = theArr[i];
                    maxIndex = i;
                } else if (maxElement < theArr[i]){
                    maxElement = theArr[i];
                    maxIndex = i;
                }
            }
        }
        if (maxIndex == - 1){
            return "No matches";
        } else {
            return maxIndex + "";
        }
    }

    //· min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
    //o If there are two or more equal min/max elements, return the index of the rightmost one.
    //o If a min/max even/odd element cannot be found, print "No matches".
    public static void printMin(String [] command, int[] theArr){
        switch (command[1]){
            case "even":
                System.out.println(minEvenIndex(theArr));
                break;
            case "odd":
                System.out.println(minOddIndex(theArr));
                break;
        }
    }

    public static String minEvenIndex(int[] theArr){
        int minElement = 0;
        int minIndex = -1;
        for (int i = 0; i < theArr.length; i++) {
            if (theArr[i] % 2 == 0){
                if(minIndex == -1){
                    minElement = theArr[i];
                    minIndex = i;
                } else if (minElement > theArr[i]){
                    minElement = theArr[i];
                    minIndex = i;
                }
            }
        }
        if (minIndex == - 1){
            return "No matches";
        } else {
            return minIndex + "";
        }
    }

    public static String minOddIndex(int[] theArr){
        int minElement = 0;
        int minIndex = -1;
        for (int i = 0; i < theArr.length; i++) {
            if (theArr[i] % 2 != 0){
                if(minIndex == -1){
                    minElement = theArr[i];
                    minIndex = i;
                } else if (minElement > theArr[i]){
                    minElement = theArr[i];
                    minIndex = i;
                }
            }
        }
        if (minIndex == - 1){
            return "No matches";
        } else {
            return minIndex + "";
        }
    }

    //· first {count} even/odd – returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
    //o If the count is greater than the array length, print "Invalid count".
    //o If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements, print an empty array "[]".
    public static void printFirst(String[] command, int[] theArr){
        switch (command[2]){
            case "even":
                System.out.println(firstEven(theArr, command[1]));
                break;
            case "odd":
                System.out.println(firstOdd(theArr, command[1]));
                break;
        }
    }

    public static String firstEven (int[] theArr, String number){
        int elementsNumber = Integer.parseInt(number);
        if(elementsNumber > theArr.length){
            return "Invalid count";
        } else{
            int[] buffer = new int[elementsNumber];
            int count = 0;
            int k = 0;
            for (int i = 0; i < theArr.length; i++) {
                if (k < buffer.length){
                    if(theArr[i] % 2 == 0){
                        buffer[k] = theArr[i];
                        k++;
                        count++;
                    }else
                        return formatPrintArr(buffer, count);
                }
            }
            return formatPrintArr(buffer, count);
        }
    }

    public static String firstOdd(int[] theArr, String number){
        int elementsNumber = Integer.parseInt(number);
        if(elementsNumber > theArr.length){
            return "Invalid count";
        } else{
            int[] buffer = new int[elementsNumber];
            int count = 0;
            int k = 0;
            for (int i = 0; i < theArr.length; i++) {
                if (k < buffer.length){
                    if(theArr[i] % 2 != 0){
                        buffer[k] = theArr[i];
                        k++;
                        count++;
                    }
                }else break;
            }
            return formatPrintArr(buffer, count);
        }
    }

    //· last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
    //o If the count is greater than the array length, print "Invalid count".
    //o If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements, print an empty array "[]".
    public static void printLast(String[] command, int[] theArr){
        switch (command[2]){
            case "even":
                System.out.println(lastEven(theArr, command[1]));
                break;
            case "odd":
                System.out.println(lastOdd(theArr, command[1]));
                break;
        }
    }

    public static String lastEven(int[] theArr, String number){
        int elementsNumber = Integer.parseInt(number);
        if(elementsNumber > theArr.length){
            return "Invalid count";
        } else{
            int[] buffer = new int[elementsNumber];
            int count = 0;
            int k = 0;
            for (int i = theArr.length - 1; i >= 0; i--) {
                if (k < buffer.length){
                    if(theArr[i] % 2 == 0){
                        buffer[k] = theArr[i];
                        k++;
                        count++;
                    }
                }else return formatPrintArr(reverseArr(buffer, count), count);
            }
            return formatPrintArr(reverseArr(buffer, count), count);
        }
    }

    public static String lastOdd(int[] theArr, String number){
        int elementsNumber = Integer.parseInt(number);
        if(elementsNumber > theArr.length){
            return "Invalid count";
        } else{
            int[] buffer = new int[elementsNumber];
            int count = 0;
            int k = 0;
            for (int i = theArr.length - 1; i >= 0; i--) {
                if (k < buffer.length){
                    if(theArr[i] % 2 != 0){
                        buffer[k] = theArr[i];
                        k++;
                        count++;
                    }
                }else return formatPrintArr(reverseArr(buffer, count), count);
            }
            return formatPrintArr(reverseArr(buffer, count), count);
        }
    }


}