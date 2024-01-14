import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] text = input.nextLine().toLowerCase(Locale.ROOT).split(" ");
        List <String> result = new ArrayList<>();
        LinkedHashMap<String, Integer> occurrenceMap = new LinkedHashMap<>();
        for (int i = 0; i < text.length; i++) {
            String currentElement = text[i];
            occurrenceMap.putIfAbsent(currentElement, 0);
            occurrenceMap.put(currentElement, occurrenceMap.get(currentElement) +1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            if (entry.getValue() % 2 != 0){
                 result.add(entry.getKey());
            }
        }
        System.out.printf("%s", String.join(", ", result));

    }
}
