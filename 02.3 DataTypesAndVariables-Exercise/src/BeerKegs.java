import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String biggestKeg = "";
        double maxVolume = 0;
        //You will receive 3 * n lines. Each group of lines will be on a new line:
        // First – model – string
        // Second –radius – floating-point number
        // Third – height – integer number
        for (int i = 0; i < n; i++){
            String model = input.nextLine();
            double radius = Double.parseDouble(input.nextLine());
            int height = Integer.parseInt(input.nextLine());
            // V = π * r^2 * h
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > maxVolume){
                maxVolume = volume;
                biggestKeg = model;

            }
        }
        System.out.println(biggestKeg);
    }
}
