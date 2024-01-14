import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Your task is to find out if the brackets are balanced.
        //That means after every closing bracket should follow an opening one.
        //Nested parentheses are not valid, and if two consecutive
        // opening brackets exist, the expression should be marked as unbalanced.
        //· On the first line, you will receive n – the number of lines that will follow.
        //· On the next n lines, you will receive "(", ")" or another string
        int n = Integer.parseInt(input.nextLine());
        String buffer = "";
        for (int i = 0; i < n; i++){
            String line = input.nextLine();
            buffer = buffer + line;
        }
        boolean flag = true;
        for (int j = 0; j < buffer.length(); j++){
            char ch = buffer.charAt(j);
            if (flag){
                if (ch == '(') {
                    flag = false;
                    continue;
                } else if (ch == ')'){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                if (ch == ')') {
                    flag = true;
                    continue;
                } else if (ch == '('){
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("BALANCED");
        } else
            System.out.println("UNBALANCED");
    }
}
