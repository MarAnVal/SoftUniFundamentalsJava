import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int houers = Integer.parseInt(input.nextLine());
        int mins = Integer.parseInt(input.nextLine());

        mins = mins + 30;
        if (mins > 60){
            houers++;
            if (houers > 23){
                houers = 0;
            }
            mins = mins - 60;
        }
        System.out.printf("%d:%02d", houers, mins);

    }
}
