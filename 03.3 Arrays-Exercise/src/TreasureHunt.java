import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lineChest = input.nextLine();
        String [] chest = new String [1];
        for (int w = 0; w < lineChest.length(); w++){
            if (lineChest.charAt(w) == '|') {
                chest[chest.length-1] = lineChest.substring(0,w);
                String [] buffer = new String[chest.length + 1];
                System.arraycopy(chest, 0, buffer, 0, chest.length);
                chest = buffer;
                lineChest = lineChest.substring(w + 1);
                w = 0;
            } else if (w == lineChest.length() - 1) {
                chest[chest.length-1] = lineChest;
            }
        }

        String [] whatToDo = input.nextLine().split(" ");

        while (!whatToDo[0].equals("Yohoho!")){
            switch (whatToDo[0]){
                //· "Loot {item1} {item2}…{itemn}":
                //o Pick up treasure loot along the way. Insert the items at the beginning of the chest.
                //o If an item is already contained, don't insert it.
                case "Loot":
                    for (int i = 1; i < whatToDo.length; i++){
                        boolean isThere = false;
                        for (String s : chest) {
                            if (whatToDo[i].equals(s)) {
                                isThere = true;
                                break;
                            }
                        }
                        if (!isThere){
                            String [] buffer = new String[chest.length + 1];
                            System.arraycopy(chest, 0, buffer, 1, buffer.length - 1);
                                    buffer[0] = whatToDo[i];
                                    chest = buffer;
                        }
                    }
                    break;
                //· "Drop {index}":
                //o Remove the loot at the given position and add it to the end of the treasure chest.
                //o If the index is invalid, skip the command.
                case "Drop":
                    int index = Integer.parseInt(whatToDo[1]);
                    if (index >= 0 && index < chest.length) {
                        String buffer = chest[index];
                        for (int i = index; i < chest.length - 1; i++) {
                            chest[i] = chest[i + 1];
                        }
                        chest[chest.length - 1] = buffer;
                    }
                    break;
                //· "Steal {count}":
                //o Someone steals the last count loot items. If there are fewer items than the given count, remove as many as there are.
                //o Print the stolen items separated by ", ":
                //"{item1}, {item2}, {item3} … {itemn}"
                case "Steal":
                    int count = Integer.parseInt(whatToDo[1]);
                    if (count > chest.length){
                        count = chest.length;
                    }
                    for (int r = count; r > 0; r--){
                        System.out.print(chest[chest.length - r]);
                        if (r != 1){
                            System.out.print(", ");
                        }
                    }
                    String [] buffer = new String[chest.length - count];
                    System.arraycopy(chest, 0, buffer, 0, buffer.length);
                    chest = buffer;
                    System.out.println();
                    break;
            }
            String nextLine = input.nextLine();
            whatToDo = nextLine.split(" ");
        }
        //In the end, output the average treasure gain,
        //which is the sum of all treasure items length divided by
        // the count of all items inside the chest formatted to the second decimal point:
        //"Average treasure gain: {averageGain} pirate credits."
        //If the chest is empty, print the following message:
        //"Failed treasure hunt."
        if (chest.length != 0) {
            double gain = 0.0;
            for (String loot : chest) {
                gain += loot.length();
            }
            gain = gain / chest.length;
            System.out.printf("Average treasure gain: %.2f pirate credits.", gain);
        } else
            System.out.println("Failed treasure hunt.");
    }
}

