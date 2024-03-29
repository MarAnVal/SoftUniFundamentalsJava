import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String regex = "\\b(?<day>[0-9]{2})([/|\\-|\\.])(?<month>[A-Z][a-z]{2})\\2(?<year>[0-9]{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.printf("Day: %s, Month: %s, Year: %s%n", matcher.group("day"),
                    matcher.group("month"), matcher.group("year"));
        }

    }
}
