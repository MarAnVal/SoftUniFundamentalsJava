import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TheOrders {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        LinkedHashMap <String, Double[]> ordersMap = new LinkedHashMap<>();
        while (!line.equals("buy")){
            Double[] priceQuantity = new Double[2];
            Double[] buffer = {0.0, 0.0};
            String key = line.split(" ")[0];
            ordersMap.putIfAbsent(key, buffer);
            priceQuantity[0] = Double.parseDouble(line.split(" ")[1]);
            priceQuantity[1] = Double.parseDouble(line.split(" ")[2]);
            priceQuantity[1] = priceQuantity[1] + ordersMap.get(key)[1];
            ordersMap.put(key, priceQuantity);

            line = input.nextLine();

        }

        for (Map.Entry<String, Double[]> entry : ordersMap.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()[0] * entry.getValue()[1]);
        }


    }
}
