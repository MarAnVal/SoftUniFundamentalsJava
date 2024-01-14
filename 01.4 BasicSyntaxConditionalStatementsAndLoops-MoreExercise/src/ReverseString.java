import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        for (int i = string.length() - 1; i >= 0; i--){
            System.out.printf("%c", string.charAt(i));
        }
    }
}
