import java.util.*;
import java.util.stream.Collectors;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, String> nameHatPhysics = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> hatNames = new LinkedHashMap<>();
        String line = input.nextLine();

        while(!line.equals("Once upon a time")){
            //"{dwarfName} <:> {dwarfHatColor} <:> {dwarfPhysics}"
            String dwarfName = line.split(" <:> ")[0];
            String dwarfHat = line.split(" <:> ")[1];
            int dwarfPhysics = Integer.parseInt(line.split(" <:> ")[2]);
            String mapKey = dwarfHat + " " + dwarfName;
            if (nameHatPhysics.containsKey(mapKey)){
                int dwarfPhysicsExist = Integer.parseInt(nameHatPhysics.get(mapKey));
                if (dwarfPhysics > dwarfPhysicsExist){
                    nameHatPhysics.put(mapKey, dwarfPhysics + "");
                }
            } else {
                nameHatPhysics.put(mapKey, dwarfPhysics + "");
                hatNames.putIfAbsent(dwarfHat, new ArrayList<>());
                hatNames.get(dwarfHat).add(dwarfName);
            }
            line = input.nextLine();
        }
        for (Map.Entry<String, String> entry : nameHatPhysics.entrySet()) {
            String hat = entry.getKey().split(" ")[0];
            String value = entry.getValue();
            int hatCount = 0 - hatNames.get(hat).size();
            entry.setValue(value + " " + hatCount);
        }


        nameHatPhysics = nameHatPhysics.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, String> entry : nameHatPhysics.entrySet()) {
            //(Blue) Peter <-> 10000
            System.out.printf("(%s) %s <-> %s%n", entry.getKey().split(" ")[0], entry.getKey().split(" ")[1],
                    entry.getValue().split(" ")[0]);
        }

    }
}
