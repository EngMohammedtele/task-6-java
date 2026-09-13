import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This class runs the employee salary manager program.
public class EmployeeSalaryManager {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Create a HashMap to store salaries as key and value pairs.
        Map<Integer, Double> salaries = new HashMap<>();

        // Read the initial number of employees
        System.out.print("Enter the number of employees: ");
        // Read the number of employees from the user.
        int numberOfEmployees = scanner.nextInt();

        // Check whether this condition is true.
        if (numberOfEmployees <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of employees.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read initial employee records
        for (int i = 1; i <= numberOfEmployees; i++) {
            // Display information to the user.
            System.out.print("Enter employee ID: ");
            // Read the employee id from the user.
            int employeeId = scanner.nextInt();

            // Display information to the user.
            System.out.print("Enter employee salary: ");
            // Read the salary from the user.
            double salary = scanner.nextDouble();

            // Check whether this condition is true.
            if (salary < 0) {
                System.out.println("Salary cannot be negative. Record not added.");
            } else if (salaries.containsKey(employeeId)) {
                // Display information to the user.
                System.out.println("Employee ID already exists. Record not added.");
            // Handle the other case.
            } else {
                // Add a key and value to the salaries.
                salaries.put(employeeId, salary);
            }
        }

        // Store the choice.
        int choice;

        // Display the menu repeatedly
        do {
            // Display information to the user.
            System.out.println("\n===== EMPLOYEE SALARY MENU =====");
            // Display information to the user.
            System.out.println("1. Add Employee");
            // Display information to the user.
            System.out.println("2. Search Employee");
            // Display information to the user.
            System.out.println("3. Update Salary");
            // Display information to the user.
            System.out.println("4. Remove Employee");
            // Display information to the user.
            System.out.println("5. Display All Employees");
            // Display information to the user.
            System.out.println("6. Display Salary Statistics");
            // Display information to the user.
            System.out.println("7. Exit");
            // Display information to the user.
            System.out.print("Enter your choice: ");

            // Read the choice from the user.
            choice = scanner.nextInt();

            // Choose an action from the menu choice.
            switch (choice) {
                // Handle this menu choice.
                case 1:
                    // Add a new employee
                    System.out.print("Enter employee ID: ");
                    // Read the new employee id from the user.
                    int newEmployeeId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (salaries.containsKey(newEmployeeId)) {
                        // Display information to the user.
                        System.out.println("Employee ID already exists.");
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.print("Enter salary: ");
                        // Read the new salary from the user.
                        double newSalary = scanner.nextDouble();

                        if (newSalary < 0) {
                            System.out.println("Salary cannot be negative. Employee not added.");
                        } else {
                            // Add a key and value to the salaries.
                            salaries.put(newEmployeeId, newSalary);
                            // Display information to the user.
                            System.out.println("Employee added successfully.");
                        }
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 2:
                    // Search for an employee
                    System.out.print("Enter employee ID: ");
                    // Read the search id from the user.
                    int searchId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (salaries.containsKey(searchId)) {
                        // Display information to the user.
                        System.out.println(
                                "Salary: " + salaries.get(searchId)
                        );
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.println("Employee not found.");
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 3:
                    // Update an employee salary
                    System.out.print("Enter employee ID: ");
                    // Read the update id from the user.
                    int updateId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (salaries.containsKey(updateId)) {
                        // Display information to the user.
                        System.out.print("Enter the new salary: ");
                        // Read the updated salary from the user.
                        double updatedSalary = scanner.nextDouble();

                        if (updatedSalary < 0) {
                            System.out.println("Salary cannot be negative. Salary not updated.");
                        } else {
                            // Replace a value in the salaries.
                            salaries.replace(updateId, updatedSalary);
                            // Display information to the user.
                            System.out.println("Salary updated successfully.");
                        }
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.println("Employee not found.");
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 4:
                    // Remove an employee
                    System.out.print("Enter employee ID: ");
                    // Read the remove id from the user.
                    int removeId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (salaries.remove(removeId) != null) {
                        // Display information to the user.
                        System.out.println("Employee removed successfully.");
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.println("Employee not found.");
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 5:
                    // Display all employees
                    System.out.println("\nAll employees:");

                    // Check whether this condition is true.
                    if (salaries.isEmpty()) {
                        // Display information to the user.
                        System.out.println("No employee records found.");
                    // Handle the other case.
                    } else {
                        // Repeat the loop for the required number of times.
                        for (Map.Entry<Integer, Double> entry
                                : salaries.entrySet()) {
                            // Display information to the user.
                            System.out.println(
                                    "ID: " + entry.getKey()
                                            + " | Salary: " + entry.getValue()
                            );
                        }
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 6:
                    // Calculate salary statistics
                    if (salaries.isEmpty()) {
                        // Display information to the user.
                        System.out.println("No salary records available.");
                        // Leave this menu choice.
                        break;
                    }

                    // Calculate and store the highest salary.
                    double highestSalary = Double.NEGATIVE_INFINITY;
                    // Calculate and store the lowest salary.
                    double lowestSalary = Double.MAX_VALUE;
                    // Store the total payroll.
                    double totalPayroll = 0;

                    // Go through each item in the collection.
                    for (double salary : salaries.values()) {
                        // Check whether this condition is true.
                        if (salary > highestSalary) {
                            // Set the highest salary value.
                            highestSalary = salary;
                        }

                        // Check whether this condition is true.
                        if (salary < lowestSalary) {
                            // Set the lowest salary value.
                            lowestSalary = salary;
                        }

                        // Update the total payroll calculation.
                        totalPayroll += salary;
                    }

                    // Divide the total payroll by the number of employees.
                    double averageSalary = totalPayroll / salaries.size();

                    // Display information to the user.
                    System.out.printf("Highest salary: %.2f%n", highestSalary);
                    // Display information to the user.
                    System.out.printf("Lowest salary: %.2f%n", lowestSalary);
                    // Display information to the user.
                    System.out.printf("Average salary: %.2f%n", averageSalary);
                    // Display information to the user.
                    System.out.printf("Total payroll: %.2f%n", totalPayroll);
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 7:
                    // Exit the program
                    System.out.println("Exiting program.");
                    // Leave this menu choice.
                    break;

                // Handle an invalid menu choice.
                default:
                    // Display information to the user.
                    System.out.println("Invalid menu choice.");
            }

        // Check whether the menu should run again.
        } while (choice != 7);

        // Close the Scanner.
        scanner.close();
    }
}
