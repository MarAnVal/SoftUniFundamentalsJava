package Exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String regex = "([#\\|])(?<type>\\w+[\\s?\\w+]+)\\1(?<date>\\d{2}[/]\\d{2}[/]\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List <String> items = new ArrayList<>();
        int allCalories = 0;
        while (matcher.find()){
            String type = matcher.group("type");
            String date = matcher.group("date");
            String calories = matcher.group("calories");
            String element = String.format("Item: %s, Best before: %s, Nutrition: %s", type, date, calories);
            items.add(element);
            allCalories += Integer.parseInt(calories);
        }
        if(allCalories > 0){
            allCalories /= 2000;
        }
        System.out.printf("You have food to last you for: %d days!%n", allCalories);
        items.forEach(System.out::println);
    }
}
