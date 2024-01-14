import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Day / Age 0 <= age <= 18       18 < age <= 64         64 < age <= 122
        //Weekday       12$                     18$                     12$
        //Weekend       15$                     20$                     15$
        //Holiday       5$                      12$                     10$
        //
        //The input comes in two lines.
        // On the first line, you will receive the type of day. The type of day will always be valid.
        // On the second – is the age of the person. The age will be in the interval [-1000…1000].
        //If the given age does not fit one of the categories, you should print "Error!"
        //Print ticket price according to table with $

        String day = input.nextLine().toLowerCase();
        int age = Integer.parseInt(input.nextLine());
        int price = 0;

        if (age >= 0 && age <= 122){
            //Day / Age 0 <= age <= 18
            //Weekday       12$
            //Weekend       15$
            //Holiday       5$
            if(age <= 18){
                switch (day){
                    case "weekday":
                        price = 12; break;
                    case "weekend":
                        price = 15; break;
                    case "holiday":
                        price = 5; break;
                }
            } else if (age <= 64){
                //Day / Age       18 < age <= 64
                //Weekday              18$
                //Weekend              20$
                //Holiday              12$
                switch (day){
                    case "weekday":
                        price = 18; break;
                    case "weekend":
                        price = 20; break;
                    case "holiday":
                        price = 12; break;
                }
            } else {
                //Day / Age  64 < age <= 122
                //Weekday           12$
                //Weekend           15$
                //Holiday           10$
                switch (day){
                    case "weekday":
                        price = 12; break;
                    case "weekend":
                        price = 15; break;
                    case "holiday":
                        price = 10; break;
                }
            }

        }
        if (price != 0){
            System.out.printf("%d$", price);
        } else
            System.out.print("Error!");

    }
}
