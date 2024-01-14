import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char letter = input.nextLine().charAt(0);
        int valueOfLetter = (int) letter;
        //System.out.println(valueOfLetter);
        if (valueOfLetter > 96 && valueOfLetter < 123){
            System.out.println("lower-case");
        } else if (valueOfLetter >64 && valueOfLetter < 133){
            System.out. println("upper-case");
        }

    }
}
