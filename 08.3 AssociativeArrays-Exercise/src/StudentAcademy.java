import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //On the first line, you will receive number n.
        // After that, you will receive n pair of row
        int n = Integer.parseInt(input.nextLine());
        LinkedHashMap<String, Double> studentsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = input.nextLine();
            Double grade = Double.parseDouble(input.nextLine());
            studentsMap.putIfAbsent(name, grade);
            studentsMap.put(name, (studentsMap.get(name) + grade) / 2);
        }
        for (Map.Entry<String, Double> entry : studentsMap.entrySet()) {
            //"{name} –> {averageGrade}"
            if (entry.getValue() >= 4.5){
                System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
            }
        }

    }
}
