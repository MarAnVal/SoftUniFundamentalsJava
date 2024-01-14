import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //width and length
        int width = Integer.parseInt(input.nextLine());
        int length = Integer.parseInt(input.nextLine());

        int area = area(width, length);
        System.out.println(area);
    }
    public static int area(int width, int length){
        return width * length;
    }
}
