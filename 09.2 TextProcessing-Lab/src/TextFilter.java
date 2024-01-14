import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] bannedWordsArr = input.nextLine().split(", ");
        String text = input.nextLine();
        StringBuilder result = new StringBuilder(text);

        for (int i = 0; i < bannedWordsArr.length; i++) {
            String bannedWord = bannedWordsArr[i];
            String replacement = "";
            for (int j = 0; j < bannedWord.length(); j++) {
                replacement = String.format("%s*", replacement);
            }
            while(result.indexOf(bannedWord) > -1){
                result.replace(result.indexOf(bannedWord), result.indexOf(bannedWord) + bannedWord.length(), replacement);
            }
        }
        System.out.println(result);
    }

}
