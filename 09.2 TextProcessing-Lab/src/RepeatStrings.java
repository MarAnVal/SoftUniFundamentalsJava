import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] line = input.nextLine().split(" ");

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line[i].length(); j++) {
                System.out.print(line[i]);
            }
        }
    }
}
