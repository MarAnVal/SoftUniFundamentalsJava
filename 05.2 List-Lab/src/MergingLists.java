import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int endLoop = 0;
        boolean isFirstBigger = false;
        if(firstList.size() > secondList.size()){
            endLoop = secondList.size();
            isFirstBigger = true;
        } else {
            endLoop = firstList.size();
        }

        for (int i = 0; i < endLoop; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(i));
        }

        if (isFirstBigger){
            result.addAll(firstList.subList(endLoop, firstList.size()));
        } else {
            result.addAll(secondList.subList(endLoop, secondList.size()));
        }
        DecimalFormat df = new DecimalFormat("0.##");
        String lineString = "";
        for (double element: result) {
            lineString = lineString + df.format(element) + " ";
        }
        System.out.println(lineString);
    }
}
