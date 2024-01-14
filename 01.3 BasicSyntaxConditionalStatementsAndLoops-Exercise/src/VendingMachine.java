import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Until you receive "Start" you will be given different coins that are being inserted into the machine.
        // You have to sum them to have the total money inserted.
        // There is a problem though. Your vending machine only works with 0.1, 0.2, 0.5, 1, and 2 coins
        // If someone tries to insert some other coins, you have to display "Cannot accept {money}",
        // where the value is formatted to the second digit after the decimal point and not add it to the total money
        String coinInsert = input.nextLine();
        double sum = 0;
        while (!coinInsert.equals("Start")){
            double currentCoin = Double.parseDouble(coinInsert);
            if (currentCoin == 0.1 || currentCoin == 0.2 || currentCoin == 0.5 || currentCoin == 1 || currentCoin == 2){
             sum += currentCoin;
            } else
                System.out.printf("Cannot accept %s%n", coinInsert);
            coinInsert = input.nextLine();
        }
        //until you receive "End" you will be given products to purchase.
        //Your machine has, however, only "Nuts", "Water", "Crisps", "Soda", "Coke"
        //                  The prices are: 2.0,    0.7,    1.5,      0.8,     1.0 respectively.
        //If the person tries to purchase a not existing product, print "Invalid product".
        //If person try to purchase a product for which he doesn't have money print "Sorry, not enough money"
        //If the person purchases a product successfully print "Purchased {product name}"
        String product = input.nextLine();
        while (!product.equals("End")){
            double productPrice = 0;
            switch (product){
                case "Nuts":
                    productPrice = 2.0; break;
                case "Water":
                    productPrice = 0.7; break;
                case "Crisps":
                    productPrice = 1.5; break;
                case "Soda":
                    productPrice = 0.8; break;
                case "Coke":
                    productPrice = 1.0; break;
                default:
                    System.out.println("Invalid product");
            }
            if ((sum - productPrice) < 0 && productPrice > 0){
                System.out.println("Sorry, not enough money");
            } else if (productPrice > 0){
                System.out.printf("Purchased %s%n", product);
                sum -=productPrice;
            }
            product = input.nextLine();
        }
        //After the "End" command,
        //print the money that is left formatted to the second decimal point in the format "Change: {money left}".
        System.out.printf("Change: %.2f", sum);
    }
}
