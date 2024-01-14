import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //· Until you receive "end", the input come in the format: "{courseName} : {studentName}".
        //· The product data is always delimited by " : ".
        String line = input.nextLine();
        LinkedHashMap <String, List <String>> coursesMap = new LinkedHashMap<>();

        while (!line.equals("end")){
            String course = line.split(" : ")[0];
            coursesMap.putIfAbsent(course, new ArrayList<>());
            String student = line.split( " : ")[1];
            if (!coursesMap.get(course).contains(student)){
                coursesMap.get(course).add(student);
            }
            line = input.nextLine();
        }
        //Print information about each course, following the format: "{courseName}: {registeredStudents}"
        //· Print information about each student, following the format: "-- {studentName}"
        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey(), entry.getValue().size());
            for (String element: entry.getValue()) {
                System.out.printf("-- %s%n", element);
            }
        }

    }
}
