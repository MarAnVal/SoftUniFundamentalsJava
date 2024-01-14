import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String key = input.nextLine().replaceAll(" ", "");
        String line = input.nextLine();
        while (!line.equals("find")){
            String keyStr = "";
            for (int i = 0; i < line.length() / key.length(); i++) {
                keyStr = String.format("%s%s",keyStr, key);
            }
            keyStr = String.format("%s%s",keyStr, key.substring(0, line.length() % key.length()));
            String result = "";
            for (int i = 0; i < line.length(); i++) {
                int currentChar = (int) line.charAt(i);
                int currentKey = Integer.parseInt(String.valueOf(keyStr.charAt(i)));
                int newChar = currentChar - currentKey;
                result = String.format("%s%c", result, (char) newChar);
            }
            String type = result.substring(result.indexOf("&") + 1, result.lastIndexOf("&"));
            String coordinates = result.substring(result.indexOf("<") +1, result.indexOf(">"));
            System.out.printf("Found %s at %s%n", type, coordinates);
            line = input.nextLine();
        }
    }
}
