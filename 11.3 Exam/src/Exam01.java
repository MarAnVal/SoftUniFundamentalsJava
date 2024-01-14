import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, Integer> userSentMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> userReceivedMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> userTotalMap = new LinkedHashMap<>();
        int capacity = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        while(!line.equals("Statistics")){
            String command = line.split("=")[0];
            switch (command) {
                //"Add={username}={sent}={received}"
                case "Add":
                    //add the user if not exist with the given sent and received
                    //if user exist skipp command
                    String userAdd = line.split("=")[1];
                    if (!userTotalMap.containsKey(userAdd)) {
                        int sentAdd = Integer.parseInt(line.split("=")[2]);
                        int receivedAdd = Integer.parseInt(line.split("=")[3]);
                        userReceivedMap.put(userAdd, receivedAdd);
                        userSentMap.put(userAdd, sentAdd);
                        userTotalMap.put(userAdd, receivedAdd + sentAdd);
                    }
                    break;
                //"Message={sender}={receiver}"
                case "Message":
                    String sender = line.split("=")[1];
                    String receiver = line.split("=")[2];
                    if(userTotalMap.containsKey(sender) && userTotalMap.containsKey(receiver)){
                        userSentMap.put(sender, userSentMap.get(sender) + 1);
                        userTotalMap.put(sender, userTotalMap.get(sender) + 1);
                        userReceivedMap.put(receiver, userReceivedMap.get(receiver) + 1);
                        userTotalMap.put(receiver, userTotalMap.get(receiver) + 1);
                        if (userTotalMap.get(sender) >= capacity){
                            //"{username} reached the capacity!"
                            System.out.printf("%s reached the capacity!%n", sender);
                            userSentMap.remove(sender);
                            userReceivedMap.remove(sender);
                            userTotalMap.remove(sender);
                        }
                        if (!sender.equals(receiver)){
                            if (userTotalMap.get(receiver) >= capacity){
                                System.out.printf("%s reached the capacity!%n", receiver);
                                userSentMap.remove(receiver);
                                userReceivedMap.remove(receiver);
                                userTotalMap.remove(receiver);
                            }
                        }

                    }
                    break;
                //"Empty={username}"
                case "Empty":
                    String userEmpty = line.split("=")[1];
                    if (!userEmpty.equals("All")){
                        userSentMap.remove(userEmpty);
                        userReceivedMap.remove(userEmpty);
                        userTotalMap.remove(userEmpty);
                    } else {
                        userSentMap = new LinkedHashMap<>();
                        userReceivedMap = new LinkedHashMap<>();
                        userTotalMap = new LinkedHashMap<>();
                    }
                    break;
            }
            line = input.nextLine();
        }
        //"Users count: {count}
        System.out.printf("Users count: %d%n", userTotalMap.size());
        for (Map.Entry<String, Integer> entry : userTotalMap.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }

    }
}
