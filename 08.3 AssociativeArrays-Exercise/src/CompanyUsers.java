import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, List<String>> companyMap = new LinkedHashMap<>();
        String line = input.nextLine();
//· Until you receive "End", the input come in the format: "{companyName} -> {employeeId}".
        while (!line.equals("End")) {
            String company = line.split(" -> ")[0];
            companyMap.putIfAbsent(company, new ArrayList<>());
            String id = line.split(" -> ")[1];
            if (!companyMap.get(company).contains(id)) {
                companyMap.get(company).add(id);
            }
            line = input.nextLine();
        }
//"{company_name}
//-- {id1}
//-- {id2}
        for (Map.Entry<String, List<String>> entry : companyMap.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            for (String element: entry.getValue()) {
                System.out.printf("-- %s%n", element);
            }
        }

    }
}
