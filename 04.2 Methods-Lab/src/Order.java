import java.util.Scanner;

public class Order {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String product = input.nextLine();
        int count = Integer.parseInt(input.nextLine());

        switch (product){
            case "coffee":
                //· coffee – 1.50
                total(1.50, count);
                break;
            case "water":
                //· water – 1.00
                total(1.00, count);
                break;
            case "coke":
                //· coke – 1.40
                total(1.4, count);
                break;
            case "snacks":
                //· snacks – 2.00
                total(2, count);
                break;
        }
    }
    public static void total(double price, int count){
        System.out.printf("%.2f", price * count);
    }
}
