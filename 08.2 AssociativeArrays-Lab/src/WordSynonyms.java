import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap <String, List<String>> wordsMap = new LinkedHashMap<>();
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            String word = input.nextLine();
            String synonym = input.nextLine();
            wordsMap.putIfAbsent(word, new ArrayList<>());
            wordsMap.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : wordsMap.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }

    }
}
