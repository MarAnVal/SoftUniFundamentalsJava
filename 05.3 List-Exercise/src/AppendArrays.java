import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //§ Arrays are separated by "|".
        //§ Values are separated by spaces (" ", one or several).
        //§ Order the arrays from the last to the first and their values from left to right.

        String[] arrays = input.nextLine().split("\\|");
        List<String> resultList = new ArrayList<>();

        for (int i = arrays.length - 1; i >= 0; i--) {
            List<String> bufferList =new ArrayList<String>(Arrays.asList(arrays[i].split(" ")));
            for (int j = 0; j < bufferList.size(); j++) {
                if(bufferList.get(j).length() == 0){
                    bufferList.remove(j);
                    j = -1;
            }

            }
            resultList.addAll(bufferList.subList(0, bufferList.size()));
        }
        System.out.println(resultList.toString().replaceAll("[\\[\\],]",""));
    }
}
