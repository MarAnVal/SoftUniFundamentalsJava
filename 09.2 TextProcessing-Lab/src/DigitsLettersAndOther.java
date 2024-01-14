import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        StringBuilder text = new StringBuilder(line);
        String digits = "";
        String letters = "";
        String other = "";
        while (text.length() > 0) {
            if (Character.isDigit(text.charAt(0))) {
                digits = String.format("%s%c", digits, text.charAt(0));
                text.replace(0, 1, "");
            } else if (Character.isLetter(text.charAt(0))) {
                letters = String.format("%s%c", letters, text.charAt(0));
                text.replace(0, 1, "");
            } else {
                other = String.format("%s%c", other, text.charAt(0));
                text.replace(0, 1, "");
            }
        }
        System.out.printf("%s%n%s%n%s%n", digits, letters, other);
    }
}
