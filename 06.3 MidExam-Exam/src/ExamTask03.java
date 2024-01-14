import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExamTask03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> cards = Arrays.stream(input.nextLine().split(", ")).collect(Collectors.toList());
        int n = Integer.parseInt(input.nextLine());

        while (n > 0){
            String[] command = input.nextLine().split(", ");
            switch (command[0]){
                //"Add, {CardName}"
                //if card exist in list "Card is already in the deck"
                //if card is added "Card successfully added"
                case "Add":
                    String addCard = command[1];
                    if(!cards.contains(addCard)){
                        cards.add(addCard);
                        System.out.println("Card successfully added");
                    } else {
                        System.out.println("Card is already in the deck");
                    }
                    break;
                //"Remove, {CardName}"
                //if card exist and is removed "Card successfully removed"
                //if card not exist "Card not found"
                case "Remove":
                    String removeCard = command[1];
                    if (cards.contains(removeCard)){
                        cards.remove(removeCard);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                    break;
                //"Remove At, {index}"
                //if card exist and is removed "Card successfully removed"
                //if invalid index "Index out of range"
                case "Remove At":
                    int removeIndex = Integer.parseInt(command[1]);
                    if (removeIndex >= 0 && removeIndex < cards.size()){
                        cards.remove(removeIndex);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
                //"Insert, {index}, {CardName}"
                //if invalid index "Index out of range"
                //if card exist "Card is already added"
                //if card is insert "Card successfully added"
                case "Insert":
                    int insertIndex = Integer.parseInt(command[1]);
                    if (insertIndex >= 0 && insertIndex < cards.size()){
                        String insertCard = command[2];
                        if (!cards.contains(insertCard)){
                            cards.add(insertIndex, insertCard);
                            System.out.println("Card successfully added");
                        } else {
                            System.out.println("Card is already added");
                        }
                    } else {
                        System.out.println("Index out of range");
                    }
                    break;
            }
            n--;
        }
        System.out.println(cards.toString().replaceAll("[\\[\\]]",""));
    }
}
