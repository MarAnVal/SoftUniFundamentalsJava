import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int litersInTank = 0;
        for (int i = 0; i < n; i++){
            int currentLitters = Integer.parseInt(input.nextLine());
            if (litersInTank + currentLitters > 255){
                System.out.println("Insufficient capacity!");
            } else
                litersInTank += currentLitters;
        }
        System.out.println(litersInTank);
    }
}
