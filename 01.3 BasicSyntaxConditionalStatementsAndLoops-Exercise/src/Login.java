import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will be given a string representing a username
        //The password will be that username reversed.
        String userName = input.nextLine();
        String password = "";
        int counterWrongInputPass = 0;
        String inputPassword = input.nextLine();
        for (int i = userName.length() - 1; i >= 0; i--){
            password = password + userName.charAt(i);
        }
        while (!inputPassword.equals(password)){
            counterWrongInputPass++;
            if (counterWrongInputPass == 4){
                System.out.printf("User %s blocked!", userName);
                break;
            } else
            System.out.println("Incorrect password. Try again.");
            inputPassword = input.nextLine();
        }
        if (counterWrongInputPass < 4){
            System.out.printf("User %s logged in.", userName);
        }
    }
}
