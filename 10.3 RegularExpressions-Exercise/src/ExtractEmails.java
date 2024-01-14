import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        String regex = "(\\s|^)(?<email>(?<username>([A-Za-z0-9]+[\\-\\_\\.]?[A-Za-z0-9]+)+)@(?<host>[A-Za-z0-9]+-?[A-Za-z0-9]+(\\.[A-Za-z0-9]+-?[A-Za-z0-9]+)+))([\\s,.]|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            System.out.println(matcher.group("email"));
        }
    }
}
