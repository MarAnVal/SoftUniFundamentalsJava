package Exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String regex = "([=/])(?<location>[A-Z][a-zA-Z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<String> locations = new ArrayList<>();
        while(matcher.find()){
            locations.add(matcher.group("location"));
        }
        System.out.printf("Destinations: %s%n", String.join(", ", locations));
        int points = 0;
        for (String element: locations) {
            points += element.length();
        }
        System.out.printf("Travel Points: %d", points);
    }
}
