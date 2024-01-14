import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String namesLine = input.nextLine();
        String names = "[A-Z][a-z]+";
        Pattern pattern = Pattern.compile(names);
        Matcher matcher = pattern.matcher(namesLine);
        LinkedHashMap<String, Integer> racersMap = new LinkedHashMap<>();
        while (matcher.find()) {
            racersMap.putIfAbsent(matcher.group(), 0);
        }
        String raceLine = input.nextLine();
        while (!raceLine.equals("end of race")) {
            String nameRacerPattern = "[A-Za-z]?";
            pattern = Pattern.compile(nameRacerPattern);
            matcher = pattern.matcher(raceLine);
            String nameRacer = "";
            while (matcher.find()) {
                nameRacer = String.format("%s%s", nameRacer, matcher.group());
            }
            if (racersMap.containsKey(nameRacer)) {
                String distance = "\\d";
                pattern = Pattern.compile(distance);
                matcher = pattern.matcher(raceLine);
                while (matcher.find()) {
                    racersMap.put(nameRacer, racersMap.get(nameRacer) + Integer.parseInt(matcher.group()));
                }
            }
            raceLine = input.nextLine();
        }
        racersMap = racersMap.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int count = 1;
        for (Map.Entry<String, Integer> entry : racersMap.entrySet()) {
            if (count < 2) {
                System.out.printf("%dst place: %s%n", count, entry.getKey());
            } else if (count < 3) {
                System.out.printf("%dnd place: %s%n", count, entry.getKey());
            } else {
                System.out.printf("%drd place: %s%n", count, entry.getKey());
            }
            count++;
            if (count > 3) {
                break;
            }
        }
    }
}
