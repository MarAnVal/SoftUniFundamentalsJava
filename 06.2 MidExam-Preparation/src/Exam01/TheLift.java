package Exam01;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int waitingPeople = Integer.parseInt(input.nextLine());
        int[] wagons = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int capacity = 4;

        for (int i = 0; i < wagons.length; i++) {
            int freeSpace = capacity - wagons[i];
            if (freeSpace > 0){
                if (waitingPeople> 0 && waitingPeople >= freeSpace){
                    waitingPeople -= freeSpace;
                    wagons[i] = capacity;
                } else if (waitingPeople > 0 && waitingPeople < freeSpace){
                    wagons[i] += waitingPeople;
                    waitingPeople -= freeSpace;
                } else {
                    waitingPeople -= freeSpace;
                }
            }
        }
        if (waitingPeople > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
        }else if (waitingPeople < 0){
            System.out.printf("The lift has empty spots!%n");
        }
        for (int element:wagons) {
            System.out.print(element + " ");
        }
    }
}
