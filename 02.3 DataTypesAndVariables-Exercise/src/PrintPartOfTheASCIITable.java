import java.util.Scanner;

public class PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = Integer.parseInt(input.nextLine());
        int end = Integer.parseInt(input.nextLine());
        for (int i = start; i <= end; i++){
            char letter = (char) i;
            System.out.printf("%c ", letter);
        }
    }
}
