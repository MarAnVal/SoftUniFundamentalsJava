import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ch1 = input.nextLine().charAt(0);
        char ch2 = input.nextLine().charAt(0);

        System.out.println(charactersInRange(ch1, ch2));
    }
    public static String charactersInRange(char ch1, char ch2){
        int start = (int) ch1;
        int end = (int) ch2;
        if (end < start){
            int buffer = end;
            end = start;
            start = buffer;
        }
        String result = "";
        for (int i = start + 1; i < end; i++){
            result = result + (char) i + " ";
        }
        return result;
    }
}
