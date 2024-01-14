import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will be given an integer that will be a distance in meters.
        //Write a program that converts meters to kilometers formatted to the second decimal point.

        int meters = Integer.parseInt(input.nextLine());
        double kilometers = meters / 1000.0;

        System.out.printf("%.2f", kilometers);

    }
}
