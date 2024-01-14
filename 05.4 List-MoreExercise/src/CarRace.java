import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> raceLine = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double firstSum = firstSum(raceLine, raceLine.size() / 2);
        double secondSum = secondSum(raceLine, raceLine.size() / 2);
        if (firstSum < secondSum){
            System.out.printf("The winner is left with total time: %.1f", firstSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f", secondSum);
        }


    }

    public static double firstSum (List<Integer> raceLine, int end){
        double sum = 0;
        for (int i = 0; i < end; i++) {
            int currentElement = raceLine.get(i);
            if(currentElement == 0){
                sum *= 0.8;
            } else
                sum += currentElement;

        }

        return sum;
    }

    public static double secondSum (List<Integer> raceLine, int end){
        double sum = 0;
        for (int i = raceLine.size() - 1 ; i > end; i--) {
            int currentElement = raceLine.get(i);
            if(currentElement == 0){
                sum *= 0.8;
            } else
                sum += currentElement;

        }

        return sum;
    }

}
