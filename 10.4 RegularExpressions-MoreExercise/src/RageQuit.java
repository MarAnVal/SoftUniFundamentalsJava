import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine().toUpperCase(Locale.ROOT);
        List<String> count = new ArrayList<>();
        String regex = "(?<string>[^0-9]+)(?<number>[1-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            String text = matcher.group("string");
            int number = Integer.parseInt(matcher.group("number"));
            for (int i = 0; i < number; i++) {
                result.add(text);
            }
            String regexUnique = "[^0-9]";
            Pattern patternUnique = Pattern.compile(regexUnique);
            Matcher matcherUnique = patternUnique.matcher(text);
            while (matcherUnique.find()) {
                if (!count.contains(matcherUnique.group())) {
                    count.add(matcherUnique.group());
                }
            }

        }

        System.out.printf("Unique symbols used: %d%n", count.size());
        System.out.println(String.join("", result));
        Collections.sort(count);
        System.out.println();
    }
}
