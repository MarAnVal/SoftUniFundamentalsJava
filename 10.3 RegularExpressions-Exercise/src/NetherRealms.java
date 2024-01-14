import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] names = line.split("\\s*,\\s*");
        for (int i = 0; i < names.length; i++) {
            String element = names[i];
            if (element.isEmpty() || element.contains(" ")) {
                continue;
            } else {
                String regexHealth = "[^0-9/\\*\\-\\+\\.\\n]";
                Pattern pattern = Pattern.compile(regexHealth);
                Matcher matcher = pattern.matcher(element);
                int health = 0;
                while (matcher.find()) {
                    char currentChar = matcher.group().charAt(0);
                    health += (int) currentChar;
                }
                String regexDamage = "[\\+\\-]?[0-9]+\\.[0-9]+|[\\+\\-]?[0-9]+|[\\*/]";
                pattern = Pattern.compile(regexDamage);
                matcher = pattern.matcher(element);
                double damage = 0;
                double multiply = 1;
                double divide = 1.0;
                while (matcher.find()) {
                    switch (matcher.group()) {
                        case "/":
                            divide *= 2;
                            break;
                        case "*":
                            multiply *= 2;
                            break;
                        default:
                            damage += Double.parseDouble(matcher.group());
                    }
                }
                damage *= multiply;
                damage /= divide;
                System.out.printf("%s - %d health, %.2f damage%n", element, health, damage);
            }
        }


    }
}
