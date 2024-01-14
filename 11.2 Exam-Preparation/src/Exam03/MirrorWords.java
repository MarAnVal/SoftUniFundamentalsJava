package Exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String regex = "([#@])(?<firstWord>[a-zA-Z]{3,})\\1\\1(?<secondWord>[a-zA-Z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<String> mirrorList = new ArrayList<>();
        List<String> matcherList = new ArrayList<>();

        while (matcher.find()) {
            matcherList.add(matcher.group());
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            boolean isMatch = true;
            if (firstWord.length() == secondWord.length()) {
                int j = secondWord.length() - 1;
                for (int i = 0; i < firstWord.length(); i++) {
                    if (firstWord.charAt(i) != secondWord.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                    j--;
                }
            } else {
                isMatch = false;
            }
            if (isMatch) {
                String element = String.format("%s <=> %s", firstWord, secondWord);
                mirrorList.add(element);
            }
        }
        if (matcherList.isEmpty()) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else {
            System.out.printf("%d word pairs found!%n", matcherList.size());
            if (mirrorList.isEmpty()) {
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                System.out.println(String.join(", ", mirrorList));
            }
        }
    }
}
