import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String regex = ">{2}(?<item>\\w+)<{2}(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)\\b";
        Pattern pattern = Pattern.compile(regex);

        double totalPrice = 0.0;
        List<String> furniture = new ArrayList<>();

        while (!line.equals("Purchase")) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String item = matcher.group("item");
                furniture.add(item);
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price * quantity;
            }
            line = input.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalPrice);

    }
}
