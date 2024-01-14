package Exam05;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);
        Matcher matcherDigits = patternDigits.matcher(line);
        long pointsNeeded = 1;
        while (matcherDigits.find()) {
            int digit = Integer.parseInt(matcherDigits.group());
            pointsNeeded *= digit;
        }
        //On the first line of the output, print the obtained Cool threshold in the format:
        //"Cool threshold: {coolThresholdSum}"
        System.out.printf("Cool threshold: %s%n", pointsNeeded);

        String regexEmoji = "([:\\*]){2}(?<word>[A-Z][a-z]{2,})\\1{2}";
        Pattern patternEmoji = Pattern.compile(regexEmoji);
        Matcher matcherEmoji = patternEmoji.matcher(line);
        List<String> emojiList = new ArrayList<>();
        List<String> printEmoji = new ArrayList<>();
        while (matcherEmoji.find()) {
            emojiList.add(matcherEmoji.group("word"));
            printEmoji.add(matcherEmoji.group());

        }
        //On the following line, print the count of all emojis found in the text in format:
        //"{countOfAllEmojis} emojis found in the text. The cool ones are:
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiList.size());
        while (!emojiList.isEmpty()) {
            String emoji = emojiList.get(0);
            long sum = 0;
            for (int i = 0; i < emoji.length(); i++) {
                char currentChar = emoji.charAt(i);
                sum += currentChar;
            }
            //{cool emoji 1}
            //{cool emoji 2}
            //…
            //{cool emoji N}"
            if (sum >= pointsNeeded) {
                System.out.println(printEmoji.get(0));
            }
            printEmoji.remove(0);
            emojiList.remove(0);
        }
    }
}

