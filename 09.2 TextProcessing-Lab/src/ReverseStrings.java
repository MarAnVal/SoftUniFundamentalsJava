import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();

        while (!word.equals("end")) {
            String reversedWord = "";
            for (int i = 0; i < word.length(); i++) {
                reversedWord = word.charAt(i) + reversedWord;
            }
            System.out.printf("%s = %s%n", word, reversedWord);
            word = input.nextLine();
        }
    }
}
