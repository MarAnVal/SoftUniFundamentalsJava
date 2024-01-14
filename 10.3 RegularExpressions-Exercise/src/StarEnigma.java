import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<String> attakedPlanet = new ArrayList<>();
        List<String> destroyedPlanet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String message = input.nextLine();
            String regex = "[starSTAR]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);
            int key = 0;
            while (matcher.find()) {
                key++;
            }
            String code = "";
            for (int j = 0; j < message.length(); j++) {
                int decode = message.charAt(j) - key;
                char newChar = (char) decode;
                code = String.format("%s%c", code, newChar);
            }

            regex = "@(?<name>[[A-Z][a-z]]+)[^@\\-\\!\\:\\>]*:*(?<population>\\d+)[^@\\-\\!\\:\\>]*\\!(?<type>[AD])\\![^@\\-\\!\\:\\>]*\\-\\>(?<soldier>\\d+)";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(code);

            while (matcher.find()) {
                System.out.printf("");
                String type = matcher.group("type");
                String planetName = matcher.group("name");
                switch (type) {
                    case "A":
                        attakedPlanet.add(planetName);
                        break;
                    case "D":
                        destroyedPlanet.add(planetName);
                        break;
                }
                Collections.sort(attakedPlanet);
                Collections.sort(destroyedPlanet);
            }
        }
        System.out.printf("Attacked planets: %d%n", attakedPlanet.size());
        for (String element : attakedPlanet) {
            System.out.printf("-> %s%n", element);
        }
        System.out.printf("Destroyed planets: %d%n", destroyedPlanet.size());
        for (String element : destroyedPlanet) {
            System.out.printf("-> %s%n", element);
        }


    }
}
