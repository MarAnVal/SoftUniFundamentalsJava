import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· The first input line will contain the array of data.
        List<String> data = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
        //· On the next several input lines, you will receive commands in the format specified above.
        String command = input.nextLine();
        //· The input ends when you receive the command "3:1".
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).length() == 0){
                data.remove(i);
                i = -1;
            }
        }
        while (!command.equals("3:1")){
            String[] commandArr = command.split(" ");
            switch (commandArr[0]){
            //· merge {startIndex} {endIndex}
            //merge command, you must merge all elements from the startIndex to the endIndex.
            //In other words, you should concatenate them. Example: {abc def ghi} -> merge 0 1 -> {abcdef, ghi}
            //If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it
            //· The strings in the array may contain any ASCII character except whitespace.
            //· The startIndex and the endIndex will be in the range [-1000, 1000].
            //· The endIndex will ALWAYS be GREATER than the startIndex
                case "merge":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);
                    if(endIndex < 0){
                        break;
                    } else if (endIndex > data.size() - 1){
                        endIndex = data.size() - 1;
                    }
                    if(startIndex < 0){
                        startIndex = 0;
                    } else if (startIndex > data.size()){
                        break;
                    }
                    for (int i = 0; i < endIndex - startIndex; i++) {
                        String newData = data.get(startIndex) + data.get(startIndex + 1);
                        data.set(startIndex, newData);
                        data.remove(startIndex + 1);
                    }
                    break;
            //· divide {index} {partitions}
            //you must DIVIDE the element at the given index into several small substrings with equal length.
            //The count of the substrings should be equal to the given partitions.
            //Example: {abcdef ghi jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}
            //If the string CANNOT be exactly divided into the given partitions, make all partitions except the LAST with EQUAL LENGTHS,
            // and make the LAST one – the LONGEST.
            //Example: {abcd efgh ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
            //· The index in the divide command will ALWAYS be INSIDE the array.
            //· The partitions will be in the range [0, 100].
                case "divide":
                    int index = Integer.parseInt(commandArr[1]);
                    int partitions = Integer.parseInt(commandArr[2]);
                    String text = data.get(index);
                    int partitionLength = text.length() / partitions;
                    if (partitionLength != 0){
                        data.remove(index);
                        for (int i = partitions; i > 0 ; i--) {
                            String elementToAdd = text.substring((i - 1) * partitionLength, text.length());
                            text = text.substring(0, (i - 1) * partitionLength);
                            data.add(index, elementToAdd);

                        }
                    }
                    break;
            }

            command = input.nextLine();
        }


        //· As output, you must print a single line containing the array elements, joined by a space.
        System.out.println(data.toString().replaceAll("[\\[\\],]",""));
    }
}

