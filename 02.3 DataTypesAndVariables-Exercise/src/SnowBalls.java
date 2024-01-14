import java.util.Scanner;

public class SnowBalls {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will receive N – an integer, the number of snowballs
        int n = Integer.parseInt(input.nextLine());
        int maxSnowballSnow = 0;
        int maxSnowballTime = 0;
        int maxSnowballQuality = 0;
        double maxSnowballValue = 0;
        for (int i = 0; i < n; i++){
            // you will get after n times 3 lines:
            //· On the first line, you will get the snowballSnow – an integer.
            int snowballSnow = Integer.parseInt(input.nextLine());
            //· On the second line, you will get the snowballTime – an integer.
            int snowballTime = Integer.parseInt(input.nextLine());
            //· On the third line, you will get the snowballQuality – an integer.
            int snowballQuality = Integer.parseInt(input.nextLine());
            //For each snowball, you must calculate its snowballValue by the following formula:
            //(snowballSnow / snowballTime) ^ snowballQuality

                double buffer = snowballSnow * 1.0 / snowballTime;
                double snowballValue = Math.pow(buffer, snowballQuality);
            if (maxSnowballValue < snowballValue){
                maxSnowballSnow = snowballSnow;
                maxSnowballQuality = snowballQuality;
                maxSnowballTime = snowballTime;
                maxSnowballValue = snowballValue;
            }

        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnowballSnow, maxSnowballTime, maxSnowballValue, maxSnowballQuality);
    }
}
