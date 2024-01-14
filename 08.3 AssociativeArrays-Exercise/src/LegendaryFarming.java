import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· Each line comes in the following format: "{quantity1} {material1} {quantity2} {material2} … {quantityN} {materialN}"

        LinkedHashMap<String, Integer> lootMap = new LinkedHashMap<>();
        //"shards: {numberOfShards}
        lootMap.put("shards", 0);
        //fragments: {numberOfFragments}
        lootMap.put("fragments", 0);
        //motes: {numberOfMotes}"
        lootMap.put("motes", 0);

        HashMap<String, String> legendaryMap = new HashMap<>();
        //· "Shadowmourne" - requires 250 Shards
        legendaryMap.put("shards", "Shadowmourne");
        //· "Valanyr" - requires 250 Fragments
        legendaryMap.put("fragments", "Valanyr");
        //· "Dragonwrath" - requires 250 Motes
        legendaryMap.put("motes", "Dragonwrath");

        boolean legendaryGot = false;
            while (!legendaryGot) {
            List<String> lineList = Arrays.stream(input.nextLine().toLowerCase(Locale.ROOT)
                    .split("\\s+")).collect(Collectors.toList());
            while (!lineList.isEmpty()) {
                int quantity = Integer.parseInt(lineList.get(0));
                String material = lineList.get(1);

                lootMap.putIfAbsent(material, 0);
                lootMap.put(material, lootMap.get(material) + quantity);

                if (lootMap.get(material) >= 250 && legendaryMap.containsKey(material)) {
                    //· On the first line, print the obtained item in the format: "{Legendary item} obtained!" .
                    //· On the next three lines, print the remaining key materials.
                    //· On the several final lines, print the junk items.
                    //· All materials should be printed in the format: "{material}: {quantity}".
                    //· The output should be lowercase, except for the first letter of the legendary.
                    System.out.printf("%s obtained!%n", legendaryMap.get(material));
                    lootMap.put(material, lootMap.get(material) - 250);
                    for (Map.Entry<String, Integer> entry : lootMap.entrySet()) {
                        System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
                    }
                    legendaryGot = true;
                    break;
                }

                lineList.remove(0);
                lineList.remove(0);
            }

        }
    }
}

