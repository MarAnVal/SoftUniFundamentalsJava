import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while(firstPlayer.size() != 0 && secondPlayer.size() != 0){
            int firstPlayerCard = firstPlayer.get(0);
            firstPlayer.remove(0);
            int secondPlayerCard = secondPlayer.get(0);
            secondPlayer.remove(0);
            if (firstPlayerCard > secondPlayerCard){
                firstPlayer.add(Integer.valueOf(firstPlayerCard));
                firstPlayer.add(Integer.valueOf(secondPlayerCard));
            } else if (firstPlayerCard < secondPlayerCard){
                secondPlayer.add(Integer.valueOf(secondPlayerCard));
                secondPlayer.add(Integer.valueOf(firstPlayerCard));
            }
        }
        int sum = 0;
        if (firstPlayer.isEmpty()){
            for (int element:secondPlayer) {
                sum += element;
            }
            System.out.printf("Second player wins! Sum: %d%n", sum);
        } else {
            for (int element:firstPlayer) {
                sum += element;
            }
            System.out.printf("First player wins! Sum: %d%n", sum);
        }

    }
}
