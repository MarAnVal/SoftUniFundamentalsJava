import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<Character> characters = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (Character.isDigit(currentChar)){
                int num = Integer.parseInt(String.valueOf(currentChar));
                numbers.add(Integer.valueOf(num));
            } else {
                characters.add(currentChar);
            }
        }
        String result = "";
        for (int i = 0; i < numbers.size(); i++){
            int steps = numbers.get(i);
            if (steps > characters.size()){
                steps = characters.size();
                i = numbers.size();
            }
            if (i % 2 == 0){
                for (int j = 0; j < steps; j++) {
                    result = result + characters.get(0);
                    characters.remove(0);
                }
            } else {
                for (int j = 0; j < steps; j++) {
                    characters.remove(0);
                }
            }

        }
        System.out.println(result);
    }
}
