import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDirectoryMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> employees = new HashMap<>();

        // Read the number of employees
        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine();

        if (numberOfEmployees <= 0) {
            System.out.println("Invalid number of employees.");
            scanner.close();
            return;
        }

        // Read and store employee records
        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter employee name: ");
            String employeeName = scanner.nextLine();

            if (employees.containsKey(employeeId)) {
                System.out.println(
                        "Employee ID already exists. Please enter a unique ID."
                );
            } else {
                employees.put(employeeId, employeeName);
            }
        }

        // Search for an employee
        System.out.print("\nEnter an employee ID to search for: ");
        int searchId = scanner.nextInt();

        if (employees.containsKey(searchId)) {
            System.out.println("Employee Found: " + employees.get(searchId));
        } else {
            System.out.println("Employee ID not found.");
        }

        // Classify the company
        String classification;

        if (employees.size() < 5) {
            classification = "Small Company";
        } else if (employees.size() <= 10) {
            classification = "Medium Company";
        } else {
            classification = "Large Company";
        }

        // Display results
        System.out.println("\nTotal employee records entered: " + numberOfEmployees);
        System.out.println("Total unique employees: " + employees.size());
        System.out.println("All employee IDs and names:");

        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Company classification: " + classification);

        scanner.close();
    }
}