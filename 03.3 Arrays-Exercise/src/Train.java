import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int [] train = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            train[i] = Integer.parseInt(input.nextLine());
            sum += train[i];
        }
        for (int item: train){
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
