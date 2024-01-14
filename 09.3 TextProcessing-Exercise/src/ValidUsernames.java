import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> usernames = Arrays.stream(input.nextLine().split(", ")).collect(Collectors.toList());
        for (int i = 0; i < usernames.size(); i++) {
            String currentUsername = usernames.get(i);
            boolean valid = true;
            if (currentUsername.length() > 3 && currentUsername.length() < 16) {
                for (int j = 0; j < currentUsername.length(); j++) {
                    if (!Character.isDigit(currentUsername.charAt(j)) && !Character.isLetter(currentUsername.charAt(j))) {
                        if(currentUsername.charAt(j) != '_' && currentUsername.charAt(j) != '-'){
                            valid = false;
                            break;
                        }
                    }
                }
            } else {
                valid = false;
            }
            if (!valid){
                usernames.remove(i);
                i--;
            }
        }
        for (String element: usernames) {
            System.out.println(element);
        }
    }
}
