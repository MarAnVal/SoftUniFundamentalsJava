import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String regex = "%(?<name>[A-Z][a-z]+)%([^\\|\\$\\%\\.]*)<(?<item>\\w+)>([^\\|\\$\\%\\.]*)\\|(?<count>\\d+)\\|([^\\|\\$\\%\\.\\d]*)(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);
        double total = 0.0;
        while (!line.equals("end of shift")) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String name = matcher.group("name");
                String item = matcher.group("item");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                total += count * price;
                System.out.printf("%s: %s - %.2f%n", name, item, price * count);
            }
            line = input.nextLine();
        }
        System.out.printf("Total income: %.2f", total);
    }
}

