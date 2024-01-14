import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String regex = "^([\\$\\%])(?<tag>[A-Z][a-z]{2,})\\1: (\\[)(?<firstNumber>[0-9]+)(\\])(\\|)\\3(?<secondNumber>[0-9]+)\\5\\6\\3(?<thirdNumber>[0-9]+)\\5\\6$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            String message = "";
            if (matcher.find()) {
                int firstChar = Integer.parseInt(matcher.group("firstNumber"));
                int secondChar = Integer.parseInt(matcher.group("secondNumber"));
                int thirdChar = Integer.parseInt(matcher.group("thirdNumber"));
                String tag = matcher.group("tag");
                message = String.format("%c%c%c", firstChar, secondChar, thirdChar);
                //"{tag}: {decryptedMessage}"
                System.out.printf("%s: %s%n", tag, message);
            } else {
                //"Valid message not found!"
                System.out.println("Valid message not found!");
            }
        }
    }
}
