import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String firstText = line.split(" ")[0];
        String secondText = line.split(" ")[1];
        String substring = "";
        if (firstText.length() > secondText.length()) {
            substring = firstText.substring(secondText.length(), firstText.length());
            firstText = firstText.substring(0, secondText.length());
        } else if (firstText.length() < secondText.length()) {
            substring = secondText.substring(firstText.length(), secondText.length());
            secondText = secondText.substring(0, firstText.length());
        }
        int sum = sumTexts(firstText, secondText);
        if (!substring.isEmpty()) {
            sum += sumResidue(substring);
        }
        System.out.println(sum);
    }

    public static int sumTexts(String firstText, String secondText) {
        int sum = 0;
        for (int i = 0; i < firstText.length(); i++) {
            sum += (int) firstText.charAt(i) * (int) secondText.charAt(i);
        }
        return sum;
    }

    public static int sumResidue(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            sum += (int) text.charAt(i);
        }
        return sum;
    }
}
