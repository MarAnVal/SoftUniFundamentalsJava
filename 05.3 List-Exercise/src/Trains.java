import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Trains {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> train = Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Integer wagonCapacity = Integer.parseInt(input.nextLine());

        String command = input.nextLine();

        while (!command.equals("end")){
            if (command.contains("Add")) {
                command = command.substring(4, command.length());
                int passegersInNewWagon = Integer.parseInt(command);
                train.add(passegersInNewWagon);
            } else{
                int toGetIn = Integer.parseInt(command);
                for (int i = 0; i < train.size(); i++) {
                    int passegersIn = train.get(i);
                    if (passegersIn + toGetIn <= wagonCapacity){
                        train.set(i, passegersIn + toGetIn);
                        break;
                    }
                }
            }


            command = input.nextLine();
        }
        System.out.println(train.toString().replaceAll("[\\[\\],]",""));

    }
}
