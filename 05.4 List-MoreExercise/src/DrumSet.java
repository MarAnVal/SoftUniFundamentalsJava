import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, you receive the savings – a floating-point number.
        //· The savings – the floating-point number in the range [0.00, 10000.00].
        double savings = Double.parseDouble(input.nextLine());
        //On the second line, you receive the drum set: a sequence of integers separated by spaces.
        //· The quality of each drum in the drum set – is an integer in the range [1, 1000].
        List<Integer> drumSetOriginal = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        //Until you receive the command "Hit it again, Gabsy!" you will be receiving integers – the hit power Gabsy applies on each drum.
        // · The hit power will be in the range [0, 1000].
        String command = input.nextLine();

        List<Integer> drumSet = new ArrayList<>();
        for (int i = 0; i < drumSetOriginal.size(); i++) {
            drumSet.add(drumSetOriginal.get(i));
        }
        while(!command.equals("Hit it again, Gabsy!")){
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i < drumSet.size(); i++) {
                int drumQuality = drumSet.get(i);
                drumQuality -= hitPower;
                if (drumQuality <= 0){
                    int originalQuality = drumSetOriginal.get(i);
                    double drumPrice = originalQuality * 3;
                    if (drumPrice <= savings){
                        drumSet.set(i, originalQuality);
                        savings -= drumPrice;
                    } else {
                        drumSet.remove(i);
                        drumSetOriginal.remove(i);
                        i--;
                    }
                } else {
                    drumSet.set(i, drumQuality);
                }
            }

            command = input.nextLine();
        }
        //· On the first line, you should print each drum in the drum set, separated by space.
        //· Then you must print the money that is left on the second line in the format "Gabsy has {money left}lv.",
        // formatted with two digits after the decimal point.
        for (int element: drumSet) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
