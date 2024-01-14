package Exam05;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int studentsNumber = Integer.parseInt(input.nextLine());
        //On the first line, you are going to receive the number of the students – an integer in the range [0…50]
        int lecturesNumber = Integer.parseInt(input.nextLine());
        //On the second line, you will receive the number of the lectures – an integer number in the range [0...50].
        int additionalBonus = Integer.parseInt(input.nextLine());
        //On the third line, you will receive the additional bonus – an integer number in the range [0….100].

        //On the following lines, you will be receiving the attendance of each student.
        //There will never be students with equal bonuses.
        int maxScore = 0;
        while (studentsNumber > 0) {
            int attendance = Integer.parseInt(input.nextLine());
            if (attendance > maxScore) {
                maxScore = attendance;
            }
            studentsNumber--;

        }
        //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})

        double totalBonus = 1.0 * maxScore / lecturesNumber * (5 + additionalBonus);

        //"Max Bonus: {max bonus points}."
        //"The student has attended {student attendances} lectures."
        System.out.printf("Max Bonus: %d.%n", Math.round(totalBonus));
        System.out.printf("The student has attended %d lectures.", maxScore);

    }
}
