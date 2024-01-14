import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· First line: n - number of commands – integer.
        //· Next n lines: commands in one of two possible formats:
        //o Register: "register {username} {licensePlateNumber}"
        //o Unregister: "unregister {username}"
        int n = Integer.parseInt(input.nextLine());
        LinkedHashMap<String, String> parkingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(" ");
            String userName = line[1];
            switch (line[0]) {
                case "register":
                    //· "register {username} {licensePlateNumber}":
                    if (parkingMap.containsKey(userName)) {
                        //o The system only supports one car per user at the moment,
                        // so if a user tries to register another license plate using the same username,
                        // the system should print: "ERROR: already registered with plate number {licensePlateNumber}"
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingMap.get(userName));
                    } else {
                        //o If the aforementioned checks pass successfully, the plate can be registered,
                        // so the system should print: "{username} registered {licensePlateNumber} successfully"
                        String plateNumber = line[2];
                        parkingMap.put(userName, plateNumber);
                        System.out.printf("%s registered %s successfully%n", userName, plateNumber);
                    }
                    break;
                case "unregister":
                    //"unregister {username}":
                    //o If the user is not present in the database,
                    // the system should print: "ERROR: user {username} not found"
                    if (!parkingMap.containsKey(userName)){
                        System.out.printf("ERROR: user %s not found%n", userName);
                    } else {
                        //o If the aforementioned check passes successfully,
                        // the system should print: "{username} unregistered successfully"
                        parkingMap.remove(userName);
                        System.out.printf("%s unregistered successfully%n", userName);
                    }
                    break;
            }

        }
        //After you execute all of the commands, print all the currently
        // registered users and their license plates in the format:
        //· "{username} => {licensePlateNumber}"
        for (Map.Entry<String, String> entry : parkingMap.entrySet()) {
            System.out.printf("%s => %s%n",entry.getKey(), entry.getValue());
        }

    }
}
