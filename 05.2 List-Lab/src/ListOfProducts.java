import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int productNumber = Integer.parseInt(input.nextLine());
        List<String> products = new ArrayList<>();

        for (int i = 0; i < productNumber; i++) {
            products.add(input.nextLine());
        }
        Collections.sort(products);

        for (int i = 0; i < products.size(); i++) {
            System.out.println(i +1  + "." + products.get(i));
        }
    }
}
