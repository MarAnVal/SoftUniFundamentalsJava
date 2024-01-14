import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· On the first line, you will receive integer N – the count of orders the shop will receive.
        //· For each order, you will receive the following information:
        //      o Price per capsule - floating-point number in the range [0.00…1000.00].
        //      o Days – integer in the range [1…31].
        //      o Capsules count - integer in the range [0…2000].
        // for any order totalPrice = ((daysInMonth * capsulesCount) * pricePerCapsule)
        int n = Integer.parseInt(input.nextLine());
        double totalPrice = 0;
        for (int i = 0; i < n; i++){
            double pricePerCapsule = Double.parseDouble(input.nextLine());
            int daysInMonth = Integer.parseInt(input.nextLine());
            int capsulesCount = Integer.parseInt(input.nextLine());
            double currentPrice = 0;
            //The output should consist of N + 1 line. For each order, you must print a single line in the following format:
            //"The price for the coffee is: ${price}"
            //On the last line, you need to print the total price in the following format:
            // "Total: ${totalPrice}"
            //The price must be formatted to 2 decimal places.
            currentPrice = daysInMonth * capsulesCount * pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n", currentPrice);
            totalPrice += currentPrice;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
