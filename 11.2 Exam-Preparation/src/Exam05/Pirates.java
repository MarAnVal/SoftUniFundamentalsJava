package Exam05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String towns = input.nextLine();
        //{town}||{population}||{gold}
        LinkedHashMap<String, Integer> townPopulationMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> townGoldMap = new LinkedHashMap<>();
        //On the first lines, until the "Sail" command, you will be receiving strings representing
        // the cities with their gold and population, separated by "||"
        while (!towns.equals("Sail")) {
            String city = towns.split("\\|\\|")[0];
            int population = Integer.parseInt(towns.split("\\|\\|")[1]);
            int gold = Integer.parseInt(towns.split("\\|\\|")[2]);

            townGoldMap.putIfAbsent(city, 0);
            townGoldMap.put(city, townGoldMap.get(city) + gold);

            townPopulationMap.putIfAbsent(city, 0);
            townPopulationMap.put(city, townPopulationMap.get(city) + population);

            towns = input.nextLine();
        }
        //On the following lines, until the "End" command, you will be receiving strings representing the
        // actions described above, separated by "=>"
        String events = input.nextLine();
        while (!events.equals("End")) {
            String command = events.split("\\=\\>")[0];
            switch (command) {
                //"Plunder=>{town}=>{people}=>{gold}"
                case "Plunder":
                    String targetPlunder = events.split("\\=\\>")[1];
                    int killed = Integer.parseInt(events.split("\\=\\>")[2]);
                    int stolenGold = Integer.parseInt(events.split("\\=\\>")[3]);
                    //You have successfully attacked and plundered the town, killing the given number of people and
                    // stealing the respective amount of gold.
                    townPopulationMap.put(targetPlunder, townPopulationMap.get(targetPlunder) - killed);
                    townGoldMap.put(targetPlunder, townGoldMap.get(targetPlunder) - stolenGold);
                    //For every town you attack print this message:
                    // "{town} plundered! {gold} gold stolen, {people} citizens killed."
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                            targetPlunder, stolenGold, killed);
                    //If any of those two values (population or gold) reaches zero, the town is disbanded.
                    //You need to remove it from your collection of targeted cities and print the following message:
                    // "{town} has been wiped off the map!"
                    if (townGoldMap.get(targetPlunder) <= 0 || townPopulationMap.get(targetPlunder) <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", targetPlunder);
                        townGoldMap.remove(targetPlunder);
                        townPopulationMap.remove(targetPlunder);
                    }
                    //There will be no case of receiving more people or gold than there is in the city.
                    break;
                case "Prosper":
                    //"Prosper=>{town}=>{gold}"
                    String targetProsper = events.split("\\=\\>")[1];
                    int goldGian = Integer.parseInt(events.split("\\=\\>")[2]);
                    //There has been dramatic economic growth in the given city, increasing its
                    // treasury by the given amount of gold.
                    if (goldGian >= 0) {
                        townGoldMap.put(targetProsper, townGoldMap.get(targetProsper) + goldGian);
                        //If the given gold is a valid amount, increase the town's gold reserves by the respective
                        // amount and print the following message:
                        //"{gold added} gold added to the city treasury. {town} now has {total gold} gold."
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                goldGian, targetProsper, townGoldMap.get(targetProsper));
                    } else {
                        //The gold amount can be a negative number, so be careful. If a negative amount of gold
                        // is given, print: "Gold added cannot be a negative number!" and ignore the command.
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            events = input.nextLine();
        }
//After receiving the "End" command, if there are any existing settlements on your list of targets,
// you need to print all of them, in the following format:
//"Ahoy, Captain! There are {count} wealthy settlements to go to:
//{town1} -> Population: {people} citizens, Gold: {gold} kg
//{town2} -> Population: {people} citizens, Gold: {gold} kg
//   …
//{town…n} -> Population: {people} citizens, Gold: {gold} kg"
        if (!townGoldMap.isEmpty()){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townGoldMap.size());
            for (Map.Entry<String, Integer> entry : townGoldMap.entrySet()) {
                String town = entry.getKey();
                int population = townPopulationMap.get(town);
                int gold = entry.getValue();
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", town, population, gold);
            }

        } else {
//If there are no settlements left to plunder, print:
//"Ahoy, Captain! All targets have been plundered and destroyed!"
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
