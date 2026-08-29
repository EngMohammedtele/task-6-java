import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This class runs the employee directory map program.
public class EmployeeDirectoryMap {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Map each employee ID to the employee's name.
        HashMap<Integer, String> employees = new HashMap<>();

        // Read the number of employees
        System.out.print("Enter the number of employees: ");
        // Read the number of employees from the user.
        int numberOfEmployees = scanner.nextInt();
        // Clear the remaining new line from the input.
        scanner.nextLine();

        // Check whether this condition is true.
        if (numberOfEmployees <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of employees.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read and store employee records
        for (int i = 1; i <= numberOfEmployees; i++) {
            // Display information to the user.
            System.out.print("Enter employee ID: ");
            // Read the employee id from the user.
            int employeeId = scanner.nextInt();
            // Clear the remaining new line from the input.
            scanner.nextLine();

            // Display information to the user.
            System.out.print("Enter employee name: ");
            // Read the employee name from the user.
            String employeeName = scanner.nextLine();

            // Check whether this condition is true.
            if (employees.containsKey(employeeId)) {
                // Display information to the user.
                System.out.println(
                        "Employee ID already exists. Please enter a unique ID."
                );
            // Handle the other case.
            } else {
                // Add a key and value to the employees.
                employees.put(employeeId, employeeName);
            }
        }

        // Search for an employee
        System.out.print("\nEnter an employee ID to search for: ");
        // Read the search id from the user.
        int searchId = scanner.nextInt();

        // Check whether this condition is true.
        if (employees.containsKey(searchId)) {
            // Display information to the user.
            System.out.println("Employee Found: " + employees.get(searchId));
        // Handle the other case.
        } else {
            // Display information to the user.
            System.out.println("Employee ID not found.");
        }

        // Classify the company
        String classification;

        // Check whether this condition is true.
        if (employees.size() < 5) {
            // Set the classification value.
            classification = "Small Company";
        // Check the next condition.
        } else if (employees.size() <= 10) {
            // Set the classification value.
            classification = "Medium Company";
        // Handle the other case.
        } else {
            // Set the classification value.
            classification = "Large Company";
        }

        // Display results
        System.out.println("\nTotal employee records entered: " + numberOfEmployees);
        // Display information to the user.
        System.out.println("Total unique employees: " + employees.size());
        // Display information to the user.
        System.out.println("All employee IDs and names:");

        // Go through each item in the collection.
        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            // Display information to the user.
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display information to the user.
        System.out.println("Company classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}