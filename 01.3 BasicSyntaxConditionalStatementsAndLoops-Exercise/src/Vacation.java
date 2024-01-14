import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You are given a group of people,
        // type of the group,
        // on which day of the week they will stay.
        int groupNum = Integer.parseInt(input.nextLine());
        String typeGroup = input.nextLine().toLowerCase();
        String day = input.nextLine().toLowerCase();
        double price = 0;
        switch (typeGroup){
            case "students":
                //          Friday      Saturday        Sunday
                //Students  8.45          9.80          10.46
                switch (day){
                    case "friday":
                        price = groupNum * 8.45; break;
                    case "saturday":
                        price = groupNum * 9.8; break;
                    case "sunday":
                        price = groupNum * 10.46; break;
                }
                //Students – if the group is bigger than or equal to 30 people, you should reduce the total price by 15%
                if (groupNum >= 30){
                    price = price * 0.85;
                }
                break;
            case "business":
                //          Friday      Saturday        Sunday
                //Business  10.90         15.60         16
                //Business – if the group is bigger than or equal to 100 people 10 of them can stay for free.
                if (groupNum >= 100){
                    groupNum -= 10;
                }
                switch (day){
                    case "friday":
                        price = groupNum * 10.9; break;
                    case "saturday":
                        price = groupNum * 15.6; break;
                    case "sunday":
                        price = groupNum * 16; break;
                }
                break;
            case "regular":
                //          Friday      Saturday        Sunday
                //Regular   15             20           22.50
                switch (day){
                    case "friday":
                        price = groupNum * 15; break;
                    case "saturday":
                        price = groupNum * 20; break;
                    case "sunday":
                        price = groupNum * 22.5; break;
                }
                //Regular – if the group is bigger than or equal to 10 and less than or equal to 20 reduce the total price by 5%
                if (groupNum >= 10 && groupNum <= 20){
                    price = price * 0.95;
                }
                break;

        }
        //The output should look like that: "Total price: {price}" formatted to the second decimal point.
        System.out.printf("Total price: %.2f", price);

    }
}
