import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, String> contestPassword = new HashMap<>();
        //"{contest}:{password for contest}
        String line = input.nextLine();
        while (!line.equals("end of contests")) {
            contestPassword.put(line.split(":")[0], line.split(":")[1]);

            line = input.nextLine();
        }
        //"{contest}=>{password}=>{username}=>{points}"
        line = input.nextLine();
        TreeMap<String, List<String>> userContests = new TreeMap<>();
        HashMap<String, Integer> userTotalPoints = new HashMap<>();
        while (!line.equals("end of submissions")) {
            String contest = line.split("=>")[0];
            String password = line.split("=>")[1];
            String user = line.split("=>")[2];
            int points = Integer.parseInt(line.split("=>")[3]);
            if (contestPassword.containsKey(contest)) {
                if (contestPassword.get(contest).equals(password)) {
                    userContests.putIfAbsent(user, new ArrayList<>());
                    userContests.get(user).add(contest + " -> " + points);

                    userTotalPoints.putIfAbsent(user, 0);
                    userTotalPoints.put(user, userTotalPoints.get(user) + points);
                }
            }

            line = input.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : userContests.entrySet()) {
            for (int i = 0; i < entry.getValue().size() - 1; i++) {
                for (int j = i + 1; j < entry.getValue().size(); j++) {
                    String currentUser = entry.getKey();
                    List<String> currentContest = entry.getValue();
                    int pointsI = Integer.parseInt(currentContest.get(i).split(" -> ")[1]);
                    int pointsJ = Integer.parseInt(currentContest.get(j).split(" -> ")[1]);
                    String contestI = currentContest.get(i).split(" -> ")[0];
                    String contestJ = currentContest.get(j).split(" -> ")[0];
                    if (contestI.equals(contestJ)) {
                        if (pointsI < pointsJ) {
                            int newPoints = userTotalPoints.get(currentUser) - pointsI;
                            userTotalPoints.put(currentUser, newPoints);
                            entry.getValue().remove(i);
                            i--;
                        } else {
                            int newPoints = userTotalPoints.get(currentUser) - pointsJ;
                            userTotalPoints.put(currentUser, newPoints);
                            entry.getValue().remove(j);
                            j--;
                        }
                    } else if (Integer.parseInt(entry.getValue().get(i).split(" -> ")[1]) <
                            Integer.parseInt(entry.getValue().get(j).split(" -> ")[1])) {
                        String buffer = entry.getValue().get(i);
                        entry.getValue().remove(i);
                        entry.getValue().add(buffer);
                        i = 0;
                    }
                }
            }
        }
        String bestCandidate = "";
        int bestPoints = 0;
        for (Map.Entry<String, Integer> entry : userTotalPoints.entrySet()) {
            if (entry.getValue() > bestPoints) {
                bestPoints = entry.getValue();
                bestCandidate = entry.getKey();
            }
        }
        //· On the first line, print the best user in a format:
        // "Best candidate is {user} with total {total points} points.".
        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestPoints);
        //· Then print all students ordered as mentioned above in format:
        //"{user1 name}
        //# {contest1} -> {points}
        //# {contest2} -> {points}"
        System.out.println("Ranking:");
        for (Map.Entry<String, List<String>> entry : userContests.entrySet()) {
            System.out.println(entry.getKey());
            for (String element : entry.getValue()) {
                System.out.printf("#  %s%n", element);
            }
        }

        System.out.println();
    }
}
