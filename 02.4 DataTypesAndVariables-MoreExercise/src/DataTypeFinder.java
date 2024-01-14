import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //You will receive input until you receive "END". Find what data type is the input. Possible data types are:
        //· Integer
        //· Floating point
        //· Characters
        //· Boolean
        //· Strings
        //Print the result in the following format: "{input} is {data type} type".
        String line = input.nextLine();

        while (!line.equals("END")) {
            String buffer = line.toLowerCase();
            String typeOfInput = "";
            int pointCount = 0;
            int negativeCount = 0;
            for (int i = 0; i < buffer.length(); i++){
                char ch = buffer.charAt(i);
                boolean digits = Character.isDigit(ch);
                if (ch == '.' && pointCount < 1 && i > negativeCount && i != buffer.length() - 1){
                    pointCount++;
                    typeOfInput = "floating point";
                } else if (ch == '-' && i == 0){
                    negativeCount ++;
                } else if (!digits){
                    typeOfInput = "string";
                    break;
                }else if (typeOfInput.equals("")){
                    typeOfInput = "integer";
                }


            }
            if (buffer.length() == 1 && (negativeCount == 1 || typeOfInput.equals("string"))){
                typeOfInput = "character";
            }
            if (buffer.equals("true") || buffer.equals("false")){
                typeOfInput = "boolean";
            }
            System.out.printf("%s is %s type%n", line, typeOfInput);
            line = input.nextLine();

        }
    }
}
