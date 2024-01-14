import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numberArr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeMap<Integer, Integer> numberCounts = new TreeMap<>();
        for (int i = 0; i < numberArr.length; i++) {
            numberCounts.putIfAbsent(numberArr[i], 0);
            numberCounts.put(numberArr[i], numberCounts.get(numberArr[i]) +1);
        }
        for (Map.Entry <Integer, Integer> entry: numberCounts.entrySet()) {
            System.out.printf("%d -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}


