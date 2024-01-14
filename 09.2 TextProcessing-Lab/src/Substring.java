import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String excludedText = input.nextLine();
        String text = input.nextLine();
        StringBuilder result = new StringBuilder(text);

        while(result.indexOf(excludedText) > -1){
            int start = result.indexOf(excludedText);
            int end = result.indexOf(excludedText) + excludedText.length();
            result.replace(start, end, "");
        }
        System.out.println(result);
    }
}
