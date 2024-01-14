import java.util.Scanner;

public class ExamTask02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] cars = input.nextLine().split(">>");
        double totalTaxes = 0.0;

        for (int i = 0; i < cars.length; i++) {
            String[] currentCar = cars[i].split(" ");
            double carTax = 0.0;
            double yearsTax = 0.0;
            double kmTax = 0.0;
            boolean validCar = true;
            switch (currentCar[0]){
                //"family"
                case "family":
                    //50 euro; -5 euro per year, +12 euro per 3k KM
                    carTax = 50;
                    yearsTax = Integer.parseInt(currentCar[1]) * 5;
                    kmTax = (Integer.parseInt(currentCar[2]) / 3000 ) * 12;
                    break;
                //"heavyDuty"
                case "heavyDuty":
                    //80 euro; -8 euro per year, +14 euro per 9k KM
                    carTax = 80;
                    yearsTax = Integer.parseInt(currentCar[1]) * 8;
                    kmTax = (Integer.parseInt(currentCar[2]) / 9000 ) * 14;
                    break;
                //"sports"
                case "sports":
                    //100 euro; -9 euro per year, +18 euro per 2k KM
                    carTax = 100;
                    yearsTax = Integer.parseInt(currentCar[1]) * 9;
                    kmTax = (Integer.parseInt(currentCar[2]) / 2000 ) * 18;
                    break;
                default:
                    System.out.println("Invalid car type.");
                    validCar = false;
                    break;
            }
            if(validCar){
            double totalTax = carTax - yearsTax + kmTax;
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", currentCar[0], totalTax);
                totalTaxes += totalTax;
            }
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n", totalTaxes);
    }
}
