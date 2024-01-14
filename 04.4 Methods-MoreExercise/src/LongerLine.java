import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] firstLine = new int[4];
        int [] secondLine = new int[4];
        for (int i = 0; i < 4; i++) {
            firstLine[i] = Integer.parseInt(input.nextLine());
        }
        for (int i = 0; i < 4; i++) {
            secondLine[i] = Integer.parseInt(input.nextLine());
        }
        getLongerLine(firstLine, secondLine);

    }
    public static int [] sortPoints(int [] line){
        if (getPoweredDistancePoint(line[0], line[1]) > getPoweredDistancePoint(line[2], line[3])){
            int buffer = line[3];
            line[3] = line[1];
            line[1] = buffer;
            buffer = line[2];
            line[2] = line[0];
            line[0] = buffer;
        }
        return line;
    }

    // а^2 + b^2 = c^2 Phytagorean theorem
    public static int getPoweredDistancePoint(int x, int y){
        return x * x + y * y;
    }

    public static void getLongerLine(int [] line1, int [] line2){
        sortPoints(line1);
        sortPoints(line2);
        if (getPoweredLineLength(line1) >= getPoweredLineLength(line2)) {
            printCoordinates(line1);
        } else {
            printCoordinates(line2);
        }
    }
    // а^2 + b^2 = c^2 Phytagorean theorem
    // a = |x1 - x2| b = |y2 - x1|
    public static int getPoweredLineLength(int [] line){
        return ((line[0] - line[2]) * (line[0] - line[2])) + ((line[3] - line[1]) * (line[3] - line[1]));
    }

    public static void printCoordinates(int [] arr){
        System.out.printf("(%d, %d)(%d, %d)", arr[0], arr[1], arr[2], arr[3]);
    }
}

