package Exam02;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        LinkedHashMap<String, String> plantRarityMap = new LinkedHashMap<>();
        LinkedHashMap<String, List<Integer>> plantRateMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String plant = line.split("<->")[0];
            String rarity = line.split("<->")[1];
            plantRarityMap.put(plant, rarity);
            plantRateMap.putIfAbsent(plant, new ArrayList<>());
        }
        String line = input.nextLine();
        while (!line.equals("Exhibition")) {
            String command = line.split(": ")[0];
            String parts = line.split(": ")[1];
            switch (command) {
                case "Rate":
                    //"Rate: {plant} - {rating}" – add the given rating to the plant (store all ratings)
                    String plantRate = parts.split(" - ")[0];
                    int rate = Integer.parseInt(parts.split(" - ")[1]);
                    if (plantRateMap.containsKey(plantRate)) {
                        plantRateMap.get(plantRate).add(0, rate);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    //"Update: {plant} - {new_rarity}" – update the rarity of the plant with the new one
                    String plantRarity = parts.split(" - ")[0];
                    String rarity = parts.split(" - ")[1];
                    if (plantRarityMap.containsKey(plantRarity)) {
                        plantRarityMap.put(plantRarity, rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    //"Reset: {plant}" – remove all the ratings of the given plant
                    if (plantRateMap.containsKey(parts)) {
                        plantRateMap.put(parts, new ArrayList<>());
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
            line = input.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, String> entry : plantRarityMap.entrySet()) {
            //- {plant_name1}; Rarity: {rarity}; Rating: {average_rating}
            String plant = entry.getKey();
            String rarity = entry.getValue();
            double averageRate = 0.0;
            if (!plantRateMap.get(plant).isEmpty()) {
                for (Integer e : plantRateMap.get(plant)) {
                    averageRate += e;
                }
                averageRate /= plantRateMap.get(plant).size();
            }

            System.out.printf("- %s; Rarity: %s; Rating: %.2f%n", plant, rarity, averageRate);
        }
    }
}
