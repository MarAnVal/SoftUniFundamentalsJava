import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List <String> wordsList = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
        Random rnd = new Random();

        while(!wordsList.isEmpty()){
            int index = rnd.nextInt(wordsList.size());
            System.out.println(wordsList.get(index));
            wordsList.remove(index);
        }

    }
}