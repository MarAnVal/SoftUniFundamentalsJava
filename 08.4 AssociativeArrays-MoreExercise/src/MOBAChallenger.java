import java.util.*;
import java.util.stream.Collectors;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //"{player} -> {position} -> {skill}"
        //"{player} vs {player}"
        //"Season end"
        LinkedHashMap<String, List<String>> playerPositionSkill = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> playerPosition = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> playerTotalSkill = new LinkedHashMap<>();

        String line = input.nextLine();
        while (!line.equals("Season end")) {
            //"{player} -> {position} -> {skill}"
            //"{player} vs {player}"
            String command = line.split(" ")[1];
            switch (command) {
                case "->":
                    String player = line.split(" ")[0];
                    String position = line.split(" ")[2];
                    String skill = line.split(" ")[4];
                    //- {position} <::> {skill}"
                    String positionSkill = String.format("- %s <::> %s", position, skill);
                    if (!playerPositionSkill.containsKey(player)) {
                        playerPositionSkill.put(player, new ArrayList<>());
                        playerPositionSkill.get(player).add(positionSkill);

                        playerPosition.put(player, new ArrayList<>());
                        playerPosition.get(player).add(position);

                        playerTotalSkill.put(player, Integer.parseInt(skill));
                    } else {
                        if (!playerPosition.get(player).contains(position)) {
                            playerPositionSkill.get(player).add(positionSkill);

                            playerPosition.get(player).add(position);

                            playerTotalSkill.put(player, playerTotalSkill.get(player) + Integer.parseInt(skill));
                        } else {
                            for (int i = 0; i < playerPositionSkill.get(player).size(); i++) {
                                if (playerPositionSkill.get(player).get(i).split(" ")[0].equals(position)) {
                                    Integer oldSkill = Integer.parseInt(playerPositionSkill.get(player).get(i).split(" <::> ")[1]);
                                    if (oldSkill < Integer.parseInt(skill)) {
                                        playerPositionSkill.get(player).set(i, positionSkill);

                                        playerTotalSkill.put(player, playerTotalSkill.get(player) - oldSkill + Integer.parseInt(skill));

                                        i = playerPositionSkill.get(player).size();
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "vs":
                    String player1 = line.split(" ")[0];
                    String player2 = line.split(" ")[2];
                    if (playerPosition.containsKey(player1) && playerPosition.containsKey(player2)) {
                        for (int i = 0; i < playerPosition.get(player1).size(); i++) {
                            if (playerPosition.get(player2).contains(playerPosition.get(player1).get(i))) {
                                if (playerTotalSkill.get(player1) > playerTotalSkill.get(player2)) {
                                    playerPositionSkill.remove(player2);
                                    playerPosition.remove(player2);
                                    playerTotalSkill.remove(player2);
                                    i = playerPosition.get(player1).size();
                                } else if (playerTotalSkill.get(player1) < playerTotalSkill.get(player2)) {
                                    playerPositionSkill.remove(player1);
                                    playerPosition.remove(player1);
                                    playerTotalSkill.remove(player1);
                                    i = playerPosition.get(player1).size();
                                }
                            }
                        }
                    }
                    break;
            }

            line = input.nextLine();
        }

        playerTotalSkill = playerTotalSkill.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        playerTotalSkill = playerTotalSkill.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : playerTotalSkill.entrySet()) {
            //"{player}: {totalSkill} skill
            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue());
            String player = entry.getKey();
            Collections.sort(playerPositionSkill.get(player));
            for (int i = 0; i < playerPositionSkill.get(player).size() - 1; i++) {
                int skillI = Integer.parseInt(playerPositionSkill.get(player).get(i).split(" <::> ")[1]);
                int skillJ = Integer.parseInt(playerPositionSkill.get(player).get(i + 1).split(" <::> ")[1]);
                if (skillJ > skillI) {
                    String buffer = playerPositionSkill.get(player).get(i);
                    playerPositionSkill.get(player).set(i, playerPositionSkill.get(player).get(i + 1));
                    playerPositionSkill.get(player).set(i + 1, buffer);
                    i = -1;
                }
            }
            for (String element : playerPositionSkill.get(player)) {
                System.out.println(element);
            }
        }

    }
}
