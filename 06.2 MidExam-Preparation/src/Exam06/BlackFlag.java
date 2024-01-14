package Exam06;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the 1st line, you will receive the days of the plunder – an integer number in the range [0…100000]
        int days = Integer.parseInt(input.nextLine());
        //On the 2nd line, you will receive the daily plunder – an integer number in the range [0…50]
        int dailyPlunder = Integer.parseInt(input.nextLine());
        //On the 3rd line, you will receive the expected plunder – a real number in the range [0.0…10000.0]
        double expectedPlunder = Double.parseDouble(input.nextLine());
        double totalPlunder = 0;
        int today = 1;
        while (today <= days) {
            //Each day they gather the plunder.
            totalPlunder += dailyPlunder;
            //Every third day they add additional plunder to their total gain, which is 50% of the daily plunder.
            if (today % 3 == 0) {
                totalPlunder += dailyPlunder * 0.5;
            }
            //Every fifth day the pirates encounter a warship, and after the battle, they lose 30% of their total plunder.
            if (today % 5 == 0) {
                totalPlunder *= 0.7;
            }
            today++;
        }
        double percent = (100 * totalPlunder) / expectedPlunder;
        if (percent >= 100){
            //If the gained plunder is more or equal to the target, print the following:
            // "Ahoy! {totalPlunder} plunder gained."
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
            } else {
            //If the gained plunder is less than the target. Calculate the percentage left and print the following:
            //"Collected only {percentage}% of the plunder."
            //Both numbers should be formatted to the 2nd decimal place.
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }
    }
}
