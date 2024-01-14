import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· On the first input line - lost games count – integer in the range [0, 1000].
        //· On the second line – headset price - the floating-point number in the range [0, 1000].
        //· On the third line – mouse price - the floating-point number in the range [0, 1000].
        //· On the fourth line – keyboard price - the floating-point number in the range [0, 1000].
        //· On the fifth line – display price - the floating-point number in the range [0, 1000].
        int gameLost = Integer.parseInt(input.nextLine());
        double headsetPrice = Double.parseDouble(input.nextLine());
        double mousePrice = Double.parseDouble(input.nextLine());
        double keyboardPrice = Double.parseDouble(input.nextLine());
        double displayPrice = Double.parseDouble(input.nextLine());

        //Every second lost game, Peter trashes his headset.
        //Every third lost game, Peter trashes his mouse.
        //When Peter trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
        //(Every 6th game)
        //Every second time when he trashes his keyboard, he also trashes his display
        //(every 12th game)
         double rageExpenses = headsetPrice * (gameLost / 2) + mousePrice * (gameLost / 3) + keyboardPrice * ( gameLost / 6) + displayPrice * ( gameLost / 12);

         //· As output you must print Peter's total expenses: "Rage expenses: {expenses} lv."
        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}
