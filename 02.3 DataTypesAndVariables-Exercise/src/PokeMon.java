import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· The input consists of 3 lines.
        // On the first line, you will receive N – an integer.
        // On the second line, you will receive M – an integer.
        // On the third line, you will receive Y – an integer.
        int power = Integer.parseInt(input.nextLine());
        int distance = Integer.parseInt(input.nextLine());
        int factor = Integer.parseInt(input.nextLine());
        int count = 0;
        double factorPoint = power / 2.0;
        // power = power - distance; count ++; until power >= distance
        // if power became equal 50% of original than power = power / factor; if factor = 0 skipp
        while (power >= distance){
            power -= distance;
            count++;
            if (power == factorPoint && factor != 0){
                power /= factor;
            }
        }
        System.out.printf("%d%n%d%n", power, count);
    }
}
