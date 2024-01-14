import java.util.*;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //"{username} -> {contest} -> {points}"
        String line = input.nextLine();
        LinkedHashMap<String, List<String>> userContest = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> userTotalPoints = new LinkedHashMap<>();
        while (!line.equals("no more time")) {
            String[] lineArr = line.split(" -> ");
            String user = lineArr[0];
            String contest = lineArr[1];
            int points = Integer.parseInt(lineArr[2]);

            if (userContest.containsKey(contest)) {
                boolean userAdded = false;
                for (int i = 0; i < userContest.get(contest).size(); i++) {
                    String userI = userContest.get(contest).get(i).split(" <::> ")[0];
                    int pointsI = Integer.parseInt(userContest.get(contest).get(i).split(" <::> ")[1]);
                    if (user.equals(userI)){
                        userAdded = true;
                        if (points > pointsI) {
                            userContest.get(contest).remove(i);
                            userContest.get(contest).add(user + " <::> " + points);
                            userTotalPoints.put(user, userTotalPoints.get(user) - pointsI + points);

                        }
                    }

                }
                if (!userAdded) {
                    userContest.get(contest).add(user + " <::> " + points);
                    userTotalPoints.putIfAbsent(user, 0);
                    userTotalPoints.put(user, userTotalPoints.get(user) + points);
                }
            } else {
                userContest.put(contest, new ArrayList<>());
                userContest.get(contest).add(user + " <::> " + points);
                userTotalPoints.putIfAbsent(user, 0);
                userTotalPoints.put(user, userTotalPoints.get(user) + points);
            }

            line = input.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : userContest.entrySet()) {
            Collections.sort(entry.getValue());
            for (int i = 0; i < entry.getValue().size() - 1; i++) {
                int pointsI = Integer.parseInt(entry.getValue().get(i).split(" <::> ")[1]);
                int pointsJ = Integer.parseInt(entry.getValue().get(i + 1).split(" <::> ")[1]);
                if (pointsI < pointsJ) {
                    String currentArrElement = entry.getValue().get(i);
                    entry.getValue().set(i, entry.getValue().get(i + 1));
                    entry.getValue().set(i + 1, currentArrElement);
                    i = -1;
                }
            }
        }

        //"{constestName}: {participants.Count} participants
        //{position}. {username} <::> {points}"
        for (Map.Entry<String, List<String>> entry : userContest.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("%d. %s%n", i + 1, entry.getValue().get(i));
            }
        }
        userTotalPoints = userTotalPoints.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        userTotalPoints = userTotalPoints.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Individual standings:");
        //Individual standings:
        //1. Sam -> 600
        //2. Pitter -> 550
        //3. Anna -> 400
        //4. Peter -> 350
        //5. George -> 300
        int i = 1;
        for (Map.Entry<String, Integer> entry : userTotalPoints.entrySet()) {

            System.out.printf("%d. %s -> %d%n", i, entry.getKey(), entry.getValue());
            i++;
        }

    }
}
