import java.util.Scanner;

public class RecursiveFibonacci {
    public  static int getFibonaci (int k){
        if (k > 0 && k <=2) {
            return 1;
        }else if (k > 2)  {
            return getFibonaci(k-1) + getFibonaci(k -2);

        } else
            return 0;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int result = getFibonaci(n);
        System.out.println(result);
    }
}
