import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] firstArr = input.nextLine().split(" ");
        String [] secondArr = input.nextLine().split(" ");

        for (int i = 0; i < secondArr.length; i++){
            for (int j = 0; j < firstArr.length; j++){
                if (firstArr[j].equals(secondArr[i])){
                    System.out.print(secondArr[i] + " ");
                }
            }
        }
    }
}
