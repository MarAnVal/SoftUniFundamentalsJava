package Exam02;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first three lines -  each employee efficiency -  integer in the range [1 - 100]
        //On the fourth line - students count – integer in the range [0 – 10000]
        //Input will always be valid and in the range specified
        int firstEmployeeCapacity = Integer.parseInt(input.nextLine());
        int secondEmployeeCapacity = Integer.parseInt(input.nextLine());
        int turdEmployeeCapacity = Integer.parseInt(input.nextLine());
        int studentsWaiting = Integer.parseInt(input.nextLine());
        int allCapacity = firstEmployeeCapacity + secondEmployeeCapacity + turdEmployeeCapacity;
        int hours = 0;

        while (studentsWaiting > 0){
            hours++;
            if (hours % 4 > 0){
            studentsWaiting -= allCapacity;
            } else {
                continue;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
