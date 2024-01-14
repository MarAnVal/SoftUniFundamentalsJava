import java.util.Scanner;


public class ExamTask01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //needed exp real number - [0.00 - 400 000.00]
        double neededExp = Double.parseDouble(input.nextLine());
        //count of battles int - [0..500]
        int battleCount = Integer.parseInt(input.nextLine());
        boolean isDone = false;
        int currentBattle = 1;

        while(currentBattle <= battleCount && !isDone){
            double currentExp = Double.parseDouble(input.nextLine());
            //every 3rd battle +15% exp of the current battle
            if(currentBattle % 3 == 0 && currentBattle % 15 != 0){
                currentExp *= 1.15;
            }
            //every 5th battle -10% exp of the current battle
            if (currentBattle % 5 == 0 && currentBattle % 15 != 0){
                currentExp *= 0.9;
            }
            //every 15th battle +5% exp of the current battle
            if (currentBattle % 15 == 0){
                currentExp *= 1.05;
            }
            //stop when needed exp is got
            neededExp -= currentExp;
            if (neededExp <= 0){
                isDone = true;
                break;
            }

            currentBattle++;
        }
        if (isDone){
            System.out.printf("Player successfully collected his needed experience for %d battles.%n", currentBattle);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n", neededExp);
        }
    }
}
