import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String result = "";
        for (int i = 0; i < line.length(); i++) {
            int newChar = (int) line.charAt(i) + 3;
            result = String.format("%s%c", result, (char) newChar);
        }
        System.out.println(result);
    }
}
