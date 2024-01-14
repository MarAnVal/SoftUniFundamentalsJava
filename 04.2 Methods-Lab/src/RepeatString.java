import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        int n = Integer.parseInt(input.nextLine());
        repeat(n, text);

    }
    public static void repeat(int n, String text){
        String result = "";
        for (int i = 0; i < n; i++){
            result += text;
        }
        System.out.println(result);
    }
}
