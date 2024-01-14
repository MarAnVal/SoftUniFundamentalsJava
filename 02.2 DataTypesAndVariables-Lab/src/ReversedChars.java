import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String result = input.nextLine().charAt(0) +"";
        for(int i = 0; i < 2; i++){
            result = input.nextLine().charAt(0) + " " + result;
        }
        System.out.println(result);
    }
}
