import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine().replaceAll("\\s+","");
        LinkedHashMap <Character, Integer> charCount = new LinkedHashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            charCount.putIfAbsent(currentChar, 0);
            charCount.put(currentChar, charCount.get(currentChar) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
