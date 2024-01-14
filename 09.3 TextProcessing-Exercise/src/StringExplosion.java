import java.util.Scanner;

public class StringExplosion {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String result = "";
        int indexOfExplosion = text.indexOf('>');

        while(indexOfExplosion > -1){
            result = String.format("%s%s", result, text.substring(0, indexOfExplosion + 1));
            int explosion = Integer.parseInt(String.valueOf(text.charAt(indexOfExplosion + 1)));
            text = text.substring(indexOfExplosion + 1);
            if (explosion > text.length()){
                explosion = text.length();
            }
            for (int i = 0; i < explosion; i++) {
                if(text.charAt(i) == '>'){
                    explosion += Integer.parseInt(String.valueOf(text.charAt(i+1))) + 1;
                    result = String.format("%s>",result);
                }
                if (explosion > text.length()){
                    explosion = text.length();
                }
            }
            text = text.substring(explosion);
            indexOfExplosion = text.indexOf('>');
        }
        result = String.format("%s%s", result, text);
        System.out.println(result);
    }
}
