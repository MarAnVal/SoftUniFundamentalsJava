package Exam04;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, you will receive a string with even integers separated by "@" –
        // the neighborhood and the number of hearts for each house.
        int[] houses = Arrays.stream(input.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();
        //On the next lines, until "Love!" is received, you will be getting jump commands in this format: "Jump {length}".
        String command = input.nextLine();
        int currentIndex = 0;

        while (!command.equals("Love!")){
            String[] commandArr = command.split(" ");
            int length = Integer.parseInt(commandArr[1]);
            currentIndex += length;
            if(currentIndex > houses.length - 1){
                currentIndex = 0;
            }
            if (houses[currentIndex] > 2){
            houses[currentIndex] -= 2;
            }  else if (houses[currentIndex] > 0){
                //If the needed hearts for a certain house become equal to 0,
                // print on the console "Place {house_index} has Valentine's day."
                houses[currentIndex] = - 2;
                System.out.printf("Place %d has Valentine's day.%n", currentIndex);

            } else {
                //If Cupid jumps to a house where the needed hearts are already 0,
                // print on the console "Place {house_index} already had Valentine's day."
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }
            command = input.nextLine();
        }

        //"Cupid's last position was {last_position_index}."
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        int count = 0;
        for (int element:houses) {
            if (element > 0) {
                count++;
            }
        }
        if (count > 0){
            //If not, print the count of all houses that didn't celebrate Valentine's Day:
            //"Cupid has failed {houseCount} places."
            System.out.printf("Cupid has failed %d places.%n", count);
        } else {
        //If each house has had Valentine's day, print:
        //"Mission was successful."
            System.out.println("Mission was successful.");
        }

    }
}
