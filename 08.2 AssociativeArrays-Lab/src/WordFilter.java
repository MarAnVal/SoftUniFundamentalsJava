import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] words = Arrays.stream(input.nextLine().split(" ")).filter(e -> e.length() % 2 == 0).toArray(String[]::new);

        for (String element: words) {
            System.out.println(element);
        }
    }
}
