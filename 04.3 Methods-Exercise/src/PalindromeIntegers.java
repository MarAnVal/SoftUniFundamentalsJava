import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        while (!number.equals("END")){
            if(isItPalindrome(number)){
                System.out.println(true);
            } else
                System.out.println(false);
            number = input.nextLine();
        }
    }
    public static boolean isItPalindrome(String text){
        char [] arr = text.toCharArray();
        if (arr.length == 1){
            return true;
        } else {
            for (int i = 0; i < arr.length / 2; i++) {
                if (arr[i] != arr[arr.length - 1 - i]){
                    return false;
                }
            }
            return true;
        }
    }
}
