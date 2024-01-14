import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> guests = new ArrayList<>();
        int n = Integer.parseInt(input.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArr = input.nextLine().split(" ");
            String name = commandArr[0];
            if(commandArr.length > 3){
                if(guests.contains(name)){
                    //· "{name} is not going!"
                    // If you receive the second type of input, you must remove the person if he/she is on the list.
                    // If not, print: "{name} is not in the list!".
                    guests.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            } else {
                //· "{name} is going!"
                //If you receive the first type of input, you have to add the person if he/she is not on the list.
                //If he/she is in the list, print on the console: "{name} is already in the list!".
                if(!guests.contains(name)){
                    guests.add(name);
                } else {
                    System.out.println(name + " is already in the list!");
                }
            }
        }

        for (String guest : guests) {
            System.out.println(guest);
        }
        // In the end, print all guests.
    }
}


