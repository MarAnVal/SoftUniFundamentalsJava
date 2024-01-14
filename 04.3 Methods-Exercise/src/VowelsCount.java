import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        System.out.println(numberOfVowels(text));
    }
    public static int numberOfVowels (String text){
        text = text.toLowerCase();
        char [] arr = text.toCharArray();
        int count = 0;
        for (char ch : arr) {
            if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        return count;
    }
}
