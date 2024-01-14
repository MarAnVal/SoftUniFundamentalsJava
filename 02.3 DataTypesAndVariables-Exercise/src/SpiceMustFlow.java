import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int yield = Integer.parseInt(input.nextLine());
        int total = 0;
        int workDays = 0;

        while (yield >= 100){
            total = total + yield - 26;
            yield -= 10;
            workDays++;
        }
        total -= 26;
        if (total < 0){
            total = 0;
        }
        System.out.printf("%d%n%d%n", workDays, total);
    }
}
