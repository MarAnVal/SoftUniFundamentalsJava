import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String result = "";
        for (int i = 0; i < 3; i++){
            result = result + input.nextLine().charAt(0) + "";
        }
        System.out.println(result);
    }
}
