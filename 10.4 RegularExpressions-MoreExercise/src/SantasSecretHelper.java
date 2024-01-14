import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int key = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        List<String> goodKids = new ArrayList<>();
        while(!line.equals("end")){
            String decoded = "";
            for (int i = 0; i < line.length(); i++) {
                char currentLetter = line.charAt(i);
                char newLetter = (char) (currentLetter - key);
                decoded = String.format("%s%c", decoded, newLetter);
            }
           String regex = "@(?<name>[A-Za-z]+)([^@\\-!:>]+)!(?<type>[G])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decoded);
            if (matcher.find()){
                goodKids.add(matcher.group("name"));
            }
            line = input.nextLine();
        }
        for (String name: goodKids) {
            System.out.println(name);
        }
    }
}
