import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        Collections.reverse(secondList);
        int firstInterval = 0;
        int secondInterval = 0;
        if (firstList.size() > secondList.size()){
            firstInterval = firstList.get(firstList.size() - 1);
            firstList.remove(firstList.size() - 1);
            secondInterval = firstList.get(firstList.size() - 1);
            firstList.remove(firstList.size() - 1);
        } else {
            firstInterval = secondList.get(secondList.size() - 1);
            secondList.remove(secondList.size() - 1);
            secondInterval = secondList.get(secondList.size() - 1);
            secondList.remove(secondList.size() - 1);
        }
        for (int i = 0; i < firstList.size(); i++) {
            result.add(Integer.valueOf(firstList.get(i)));
            result.add(Integer.valueOf(secondList.get(i)));
        }

        if (firstInterval > secondInterval){
            int buffer = firstInterval;
            firstInterval = secondInterval;
            secondInterval = buffer;
        }

        Collections.sort(result);
        for (int element:result) {
            if (element > firstInterval && element < secondInterval){
                System.out.print(element + " ");
            }
        }
    }
}

