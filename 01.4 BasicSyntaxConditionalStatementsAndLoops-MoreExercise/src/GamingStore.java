import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, you will receive your current balance – a floating-point number in the range [0.00…5000.00].
        double balance = Double.parseDouble(input.nextLine());
        String game = input.nextLine();
        double price = 0;
        double moneySpent = balance;

        //Until you receive the command "Game Time", you have to keep buying games


            while (!game.equals("Game Time")){
                switch (game){
                    //RoverWatch Origins Edition $39.99
                    case "RoverWatch Origins Edition":
                    //OutFall 4 $39.99
                    case "OutFall 4":
                        price = 39.99;
                        break;
                    //CS: OG $15.99
                    case "CS: OG":
                        price = 15.99;
                        break;
                    //Zplinter Zell $19.99
                    case "Zplinter Zell":
                        price = 19.99;
                        break;
                    //Honored 2 $59.99
                    case "Honored 2":
                        price = 59.99;
                        break;
                    //RoverWatch $29.99
                    case "RoverWatch":
                        price = 29.99;
                        break;
                    //· If a game the user is trying to buy is not present in the table above, print "Not Found" and read the next line.
                    default:
                        System.out.println("Not Found");
                }
                if (price !=0 && price < moneySpent){
                    moneySpent -= price;
                    System.out.printf("Bought %s%n",game);
                    game = input.nextLine();
                } else if (price != 0 && price > moneySpent){
                    System.out.println("Too Expensive");
                    game = input.nextLine();
                } else if  (price != 0 && price == moneySpent){
                    System.out.printf("Bought %s%n",game);
                    System.out.println("Out of money!");
                    moneySpent -= price;
                    break;
                } else
                    game = input.nextLine();
            }

            //When a game is bought, the user's balance decreases by the price of the game.
            //· Alternatively, if the user is trying to buy a game that they can't afford, print "Too Expensive" and read the next line.
            //· If at any point, the user has $0 left, print "Out of money!" and end the program.


        //When you receive "Game Time", print the user's remaining money and total spent on games, rounded to the 2nd decimal place.
        if (moneySpent != 0){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", balance - moneySpent, moneySpent);
        }

    }
}
