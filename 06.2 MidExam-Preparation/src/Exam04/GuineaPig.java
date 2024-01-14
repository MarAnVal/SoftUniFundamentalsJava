 package Exam04;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line – quantity food in kilograms - a floating-point number in the range [0.0 – 10000.0]
        //On the second line – quantity hay in kilograms - a floating-point number in the range [0.0 – 10000.0]
        //On the third line – quantity cover in kilograms - a floating-point number in the range [0.0 – 10000.0]
        //On the fourth line – guinea's weight in kilograms - a floating-point number in the range [0.0 – 10000.0]
        double food = Double.parseDouble(input.nextLine()) * 1000;
        double hay = Double.parseDouble(input.nextLine()) * 1000;
        double cover = Double.parseDouble(input.nextLine()) * 1000;
        double Puppy = Double.parseDouble(input.nextLine()) * 1000;
        int days = 1;
        boolean isEnough = true;

        while(days < 31 && isEnough){
            //Every day Puppy eats 300 gr of food.
            food -= 300;
            if (days % 2 == 0){
                //Every second day Merry first feeds the pet, then gives it a certain amount of hay equal to 5% of the rest of the food.
                hay -= food * 0.05;
            }
            if (days % 3 == 0){
                //On every third day, Merry puts Puppy cover with a quantity of 1/3 of its weight.
                cover -= Puppy / 3;
            }
            if (food <= 0 || hay <= 0 || cover <= 0){
                isEnough = false;
                break;
            }
            days++;
        }
        if (isEnough){
            //If the food, the hay, and the cover are enough, print:
            //"Everything is fine! Puppy is happy! Food: {excessFood}, Hay: {excessHay}, Cover: {excessCover}."
            //The output values must be formatted to the second decimal place!
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", food / 1000, hay / 1000, cover / 1000);
        } else {
            //If one of the things is not enough, print:
            //"Merry must go to the pet store!"
            System.out.println("Merry must go to the pet store!");

        }
    }
}
