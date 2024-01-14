import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        String firstPart = input[0];
        String secondPart = input[1];
        String thirdPart = input[2];
        LinkedHashMap<Character, Integer> letters = new LinkedHashMap<>();

        Pattern patternText = Pattern.compile("([#$%*&])(?<letters>[A-Z]+)\\1");
        Matcher matcherText = patternText.matcher(firstPart);

        String capitalLetters = "";
        while (matcherText.find()) {
            capitalLetters = matcherText.group("letters");
        }


        //([65-90]{1,2})\:([0-9]{2})

        for (int i = 0; i < capitalLetters.length(); i++) {
            char symbol = capitalLetters.charAt(i);
            Pattern patternDigits = Pattern.compile("(?<letter>[0-9]{2}):(?<length>[0-9]{2})");
            Matcher matcherDigits = patternDigits.matcher(secondPart);

            while (matcherDigits.find()) {
                int asciiCode = Integer.parseInt(matcherDigits.group("letter"));
                int length = Integer.parseInt(matcherDigits.group("length"));

                if (symbol == asciiCode) {
                    letters.putIfAbsent(symbol, length + 1);
                }
            }
        }

        String[] thirdText = thirdPart.split("\\s+");
        for (int i = 0; i < capitalLetters.length(); i++) {

            char firstLetter = capitalLetters.charAt(i);
            int length = letters.get(firstLetter);

            for (String word : thirdText) {

                int lengthWord = word.length();
                char firstChar = word.charAt(0);

                if (lengthWord == length && firstLetter == firstChar) {
                    System.out.println(word);
                }
            }

        }
    }
}
