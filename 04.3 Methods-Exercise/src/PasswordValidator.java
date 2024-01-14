import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();

        printIsPasswordValid(password);
    }
    public static void printIsPasswordValid(String password){
        //· "Password must be between 6 and 10 characters";
        if (!isLengthValid(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        //· "Password must consist only of letters and digits";
        if (!isContentValid(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        //· "Password must have at least 2 digits".
        if (!isDigitsIncluded(password)){
            System.out.println("Password must have at least 2 digits");
        }
        //If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule, print a message:
        if (isLengthValid(password) && isContentValid(password) && isDigitsIncluded(password)){
            System.out.println("Password is valid");
        }

    }
    public static boolean isLengthValid (String password){
        //· 6 – 10 characters (inclusive);
        if (password.length() >= 6 && password.length() <= 10){
            return true;
        } else return false;
    }

    public static boolean isContentValid (String password){
        // · Consists only of letters and digits;
        // 48-57 65-90 97-122
        char [] arr = password.toCharArray();
        for (char ch: arr){
            if(((int) ch < 48) || (((int) ch > 57) && ((int) ch < 65)) ||
                    (((int) ch > 90) && ((int) ch < 97)) || ((int) ch > 122)){
                return false;
            }
        }
        return true;
    }

    public static boolean isDigitsIncluded (String password){
        //· Have at least 2 digits.
        // 48-57
        char [] arr = password.toCharArray();
        int count = 0;
        for (char ch: arr){
            if((int) ch >= 48 && (int) ch <= 57){
               count++;
            }
        }
        return count >= 2;
    }
}
