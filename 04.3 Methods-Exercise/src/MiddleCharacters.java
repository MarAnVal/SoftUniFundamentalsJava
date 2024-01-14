import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        printMiddleChar(text);
    }
    public static void printMiddleChar(String text){
        if (text.length() % 2 == 0){
            int middle = text.length() / 2;
            System.out.print(text.charAt(middle-1));
            System.out.println(text.charAt(middle));
        } else {
            int middle = text.length() / 2;
            System.out.println(text.charAt(middle));
        }
    }
}
