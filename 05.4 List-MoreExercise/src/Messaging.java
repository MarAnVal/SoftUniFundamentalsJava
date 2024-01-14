import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will be given a list of numbers and a string
        List<Integer> givenList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String givenStr = input.nextLine();
        String result = "";
        //For each element of the list, you have to take the sum of its digits and take the element corresponding to that index from the text.
        while(!givenList.isEmpty()){
            //For each element of the list, you have to take the sum of its digits and take the element corresponding to that index from the text.
            int number = givenList.get(0);
            int index = 0;
            while(number != 0){
                index += number % 10;
                number /= 10;
            }
            //If the index is greater than the length of the text, start counting from the beginning
            // (so that you always have a valid index).
            if (index > 0){
                index = index % givenStr.length();
            }
            // After getting the element from the text, you must remove the character you have taken from it
            // (so for the next index, the text will be with one characterless).
            result = result + givenStr.charAt(index);
            if (index == 0){
                givenStr = givenStr.substring(index + 1, givenStr.length());
            } else if(index + 1 < givenStr.length()){
                givenStr = givenStr.substring(0, index) + givenStr.substring(index + 1, givenStr.length());
            } else {
                givenStr = givenStr.substring(0, index);
            }
            givenList.remove(0);
        }
        System.out.println(result);

    }
}
