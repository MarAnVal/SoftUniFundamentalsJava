import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstChar = (int) input.nextLine().charAt(0);
        int secondChar = (int) input.nextLine().charAt(0);
        String line = input.nextLine();

        if (firstChar > secondChar) {
            int buffer = firstChar;
            firstChar = secondChar;
            secondChar = buffer;
        }
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            int currentChar = (int) line.charAt(i);
            if (currentChar > firstChar && currentChar < secondChar) {
                result += currentChar;
            }
        }
        System.out.println(result);


    }
}
