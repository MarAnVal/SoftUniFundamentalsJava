package Exam01;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        double withoutTax = 0;
        while(!line.equals("special") && !line.equals("regular")){
            double currentPrice = Double.parseDouble(line);
            if(currentPrice <= 0){
                System.out.println("Invalid price!");
            } else {
                withoutTax += currentPrice;
            }
            line = input.nextLine();
        }
        if (withoutTax == 0){
            System.out.println("Invalid order!");
        }else {
            double tax = withoutTax * 0.2;
            double total = withoutTax + tax;
            if (line.equals("special")){
                //The discount is applied only on the total price. Discount is only applicable to the final price!
                total *= 0.9;
            }
            //"Congratulations you've just bought a new computer!
            //Price without taxes: {total price without taxes}$
            //Taxes: {total amount of taxes}$
            //-----------
            //Total price: {total price with taxes}$"
            //All prices should be displayed to the second digit after the decimal point
            System.out.printf("Congratulations you've just bought a new computer!%n");
            System.out.printf("Price without taxes: %.2f$%n", withoutTax);
            System.out.printf("Taxes: %.2f$%n", tax);
            System.out.printf("-----------%n");
            System.out.printf("Total price: %.2f$", total);

        }
    }
}
