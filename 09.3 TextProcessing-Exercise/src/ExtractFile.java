import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        String fileName = line.substring(line.lastIndexOf("\\") + 1, line.lastIndexOf("."));
        String extension = line.substring(line.lastIndexOf(".") + 1);
        System.out.printf("File name: %s%nFile extension: %s%n", fileName, extension);
    }
}
