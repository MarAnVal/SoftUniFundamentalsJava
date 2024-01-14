import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Write a program that converts British pounds to US dollars formatted to the 3rd decimal point.
        //1 British Pound = 1.36 Dollars
        double pounds = Double.parseDouble(input.nextLine());
        double dolars = pounds * 1.36;

        System.out.printf("%.3f", dolars);
    }
}
