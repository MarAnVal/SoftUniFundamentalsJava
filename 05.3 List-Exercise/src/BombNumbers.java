import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int [] commandNumbers = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bomb = commandNumbers[0];
        int power = commandNumbers[1];
        for (int i = 0; i < numbers.size(); i++) {
            int element = numbers.get(i);

            if (element == bomb){
                int powerLeft = i - power;
                int powerRight = i + power;
                if (powerLeft < 0){
                    powerLeft = 0;
                }
                if (powerRight >= numbers.size()){
                    powerRight = numbers.size() - 1;
                }
                for (int j = 0; j < 1 + powerRight - powerLeft; j++) {
                    numbers.remove(powerLeft);
                }
                    i = -1;
                }
            }
        int sum = 0;
        for (int element :numbers) {
            sum += element;
        }
        System.out.println(sum);
        }

    }

