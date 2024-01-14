import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static String removeDuplicate(String text){
        List<Character> textCharacters = new ArrayList<>();
        textCharacters.add(text.charAt(0));
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != textCharacters.get(textCharacters.size() - 1)){
                textCharacters.add(text.charAt(i));
            }
        }
        String result = "";
        while(!textCharacters.isEmpty()) {
            result = String.format("%s%c", result, textCharacters.get(0));
            textCharacters.remove(0);
        }
    return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String result = removeDuplicate(line);
        System.out.println(result);
    }
}
