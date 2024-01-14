import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //"{username}-{language}-{points}"
        String line = input.nextLine();
        List<String> bannedUsers = new ArrayList<>();
        LinkedHashMap<String, Integer> languageSubmissions = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> usersPoints = new LinkedHashMap<>();

        while (!line.equals("exam finished")) {
            //"{username}-banned"
            String user = line.split("-")[0];
            if (line.split("-")[1].equals("banned")) {
                bannedUsers.add(user);
            } else {
                //"{username}-{language}-{points}"
                String language = line.split("-")[1];
                int points = Integer.parseInt(line.split("-")[2]);

                languageSubmissions.putIfAbsent(language, 0);
                languageSubmissions.put(language, languageSubmissions.get(language) + 1);

                usersPoints.putIfAbsent(user, 0);
                if (usersPoints.get(user) < points){
                    usersPoints.put(user, points);
                }

            }
            line = input.nextLine();
        }
        //"Results:
        //{username} | {points}
        //{username2} | {points}
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : usersPoints.entrySet()) {
            if (!bannedUsers.contains(entry.getKey())) {
                System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
            }
        }
        //"Submissions:
        //{language1} - {submissions_count}
        //{language2} - {submissions_count}
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languageSubmissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }

    }
}


