import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int elndLoop = numbers.size() / 2;
        for (int i = 0; i < elndLoop; i++) {
            int number1 = numbers.get(i);
            int number2 = numbers.get(numbers.size() - 1);
            numbers.set(i, number1 + number2);
            numbers.remove(numbers.size() - 1);
        }
        DecimalFormat df = new DecimalFormat("0.##");
        String lineString = "";
        for (double element: numbers) {
            lineString = lineString + df.format(element) + " ";
        }
        System.out.println(lineString);
    }
}
