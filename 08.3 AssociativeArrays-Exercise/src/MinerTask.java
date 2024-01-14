import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int lineCount = 1;
        String resource = "";
        int quantity = 0;
        LinkedHashMap <String, Integer> resourceMap = new LinkedHashMap<>();
        while (!line.equals("stop")){
            if(lineCount % 2 != 0){
                resource = line;
            } else {
                quantity = Integer.parseInt(line);
                resourceMap.putIfAbsent(resource , 0);
                resourceMap.put(resource, resourceMap.get(resource) + quantity);
            }
            line = input.nextLine();
            lineCount++;
        }
        for (Map.Entry<String, Integer> entry : resourceMap.entrySet()) {
            //"{resource} –> {quantity}"
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
