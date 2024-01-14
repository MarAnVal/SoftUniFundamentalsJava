import java.util.LinkedHashMap;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, String> morseCode = new LinkedHashMap<>();
        morseCode.put(".-","A");
        morseCode.put("-...", "B");
        morseCode.put("-.-.", "C");
        morseCode.put("-..", "D");
        morseCode.put(".", "E");
        morseCode.put("..-.", "F");
        morseCode.put("--.", "G");
        morseCode.put("....", "H");
        morseCode.put("..", "I");
        morseCode.put(".---", "J");
        morseCode.put("-.-", "K");
        morseCode.put(".-..", "L");
        morseCode.put("--", "M");
        morseCode.put("-.", "N");
        morseCode.put("---", "O");
        morseCode.put(".--.", "P");
        morseCode.put("--.-", "Q");
        morseCode.put(".-.", "R");
        morseCode.put("...", "S");
        morseCode.put("-", "T");
        morseCode.put("..-", "U");
        morseCode.put("...-", "V");
        morseCode.put(".--", "W");
        morseCode.put("-..-", "X");
        morseCode.put("-.--", "Y");
        morseCode.put("--..", "Z");
        morseCode.put("|", " ");
        String [] line = input.nextLine().split(" ");
        String result = "";
        for (int i = 0; i < line.length; i++) {
            result = String.format("%s%s", result, morseCode.get(line[i]));
        }
        System.out.println(result);
    }
}
