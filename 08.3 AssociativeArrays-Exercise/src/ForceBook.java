import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You should end your program when you receive the command "Lumpawaroo"
        String line = input.nextLine();
        LinkedHashMap<String, List<String>> sidesMap = new LinkedHashMap<>();
        while (!line.equals("Lumpawaroo")) {
            String user, side, command;
            if (line.contains("->")){
                command = "->";
            } else command = "|";
            String sideUsed = "";
            boolean userUsed = false;

            switch (command) {
                //If you receive "force_side | force_user":
                //· If there is no such force user and no such force side -> create a new force side and add the force
                // user to the corresponding side.
                //· Only if there is no such force user on any force side -> add the force user to the corresponding side.
                //· If there is such force user already -> skip the command and continue to the next operation.
                case "|":
                    user = line.split(" \\| ")[1];
                    side = line.split(" \\| ")[0];
                    for (Map.Entry<String, List<String>> entry : sidesMap.entrySet()) {
                        if (entry.getValue().contains(user)) {
                            userUsed = true;
                            sideUsed = entry.getKey();
                        }
                    }
                    if (!userUsed) {
                        sidesMap.putIfAbsent(side, new ArrayList<>());
                        sidesMap.get(side).add(user);
                    }
                    break;
                //If you receive a "force_user -> force_side":
                //· If there is such force user already -> change their side.
                //· If there is no such force user on any force side -> add the force user to the corresponding force side.
                //· If there is no such force user and no such force side -> create a new force side and add
                // the force user to the corresponding side.
                //· Then you should print on the console: "{force_user} joins the {force_side} side!".
                case "->":
                    user = line.split(" -> ")[0];
                    side = line.split(" -> ")[1];
                    for (Map.Entry<String, List<String>> entry : sidesMap.entrySet()) {
                        if (entry.getValue().contains(user)) {
                            userUsed = true;
                            sideUsed = entry.getKey();
                        }
                    }
                    if (userUsed) {
                        sidesMap.get(sideUsed).remove(user);
                    }
                    sidesMap.putIfAbsent(side, new ArrayList<>());
                    sidesMap.get(side).add(user);
                    System.out.printf("%s joins the %s side!%n", user, side);
                    break;
            }

            line = input.nextLine();
        }
        //"Side: {forceSide}, Members: {forceUsers.Count}
        //! {forceUser}
        //! {forceUser}
        //! {forceUser}"
        for (Map.Entry<String, List<String>> entry : sidesMap.entrySet()) {
            if (!entry.getValue().isEmpty()){
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (String element: entry.getValue()) {
                    System.out.printf("! %s%n", element);
                }
            }
        }

    }
}
