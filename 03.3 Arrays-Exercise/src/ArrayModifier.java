import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] theArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String [] whatToDo = input.nextLine().split(" ");
//        String whatToDo = line [0];
        while (!whatToDo[0].equals("end")){
            int index1;
            int index2;
            int buffer;
            switch (whatToDo[0]){
                //· "swap {index1} {index2}" takes two elements and swap their places.
                case "swap":
                    index1 = Integer.parseInt(whatToDo[1]);
                    index2 = Integer.parseInt(whatToDo[2]);
                    buffer = theArr[index1];
                    theArr[index1] = theArr[index2];
                    theArr[index2] = buffer;
                    break;
                //· "multiply {index1} {index2}" takes the element at the 1st index and multiplies it with the element at 2nd index. Save the product at the 1st index.
                case "multiply":
                    index1 = Integer.parseInt(whatToDo[1]);
                    index2 = Integer.parseInt(whatToDo[2]);
                    buffer = theArr[index1] * theArr[index2];
                    theArr[index1] = buffer;
                    break;
                //· "decrease" decreases all elements in the array with 1.
                case "decrease":
                    for (int j = 0; j < theArr.length; j++){
                        theArr[j] -= 1;
                    }
                    break;
            }
            String buffer1 = input.nextLine();
            whatToDo = buffer1.split(" ");
        }
        for (int i = 0; i < theArr.length; i++){
            if (i == theArr.length - 1){
                System.out.printf("%d%n", theArr[i]);
            } else
                System.out.print(theArr[i] + ", ");
        }
    }
}

