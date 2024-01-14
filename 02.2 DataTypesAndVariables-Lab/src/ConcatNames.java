import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Read two names and a delimiter. Print the names joined by the delimiter.
        String firstName = input.nextLine();
        String secondName = input.nextLine();
        String result = firstName + input.nextLine() + secondName;

        System.out.println(result);
    }
}
