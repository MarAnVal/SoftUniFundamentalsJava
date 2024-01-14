import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int key = Integer.parseInt(input.nextLine());
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++){
            char ch = input.nextLine().charAt(0);
            int intLetter = (int) ch;
            intLetter += key;
            ch = (char) intLetter;
            System.out.print(ch);
        }
    }
}
