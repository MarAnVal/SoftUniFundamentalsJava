import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] ticketsArr = line.split("\\s*,\\s+");
        for (String s : ticketsArr) {
            if (s.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                String left = s.substring(0, 10);
                String regexLeft = "[\\$]+|[\\@]+|[\\^]+|[\\#]+";
                Pattern pattern = Pattern.compile(regexLeft);
                Matcher matcher = pattern.matcher(left);
                boolean notWinner = true;
                while (matcher.find()) {
                    int length = matcher.group().length();
                    if (length > 5) {
                        String right = s.substring(10);
                        String regexRight = String.format("[\\%c]{6,}", matcher.group().charAt(0));
                        pattern = Pattern.compile(regexRight);
                        matcher = pattern.matcher(right);
                        if (matcher.find()) {
                            if (length > matcher.group().length()){
                                length = matcher.group().length();
                            }
                            if (length == 10) {
                                System.out.printf("ticket \"%s\" - %d%s Jackpot!%n", s, length, matcher.group().charAt(0));
                            } else {
                                System.out.printf("ticket \"%s\" - %d%s%n", s, length, matcher.group().charAt(0));
                            }
                            notWinner = false;
                        }
                    }
                }
                if (notWinner) {
                    System.out.printf("ticket \"%s\" - no match%n", s);
                }
            }
        }
    }
}