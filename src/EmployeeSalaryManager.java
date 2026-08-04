import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeSalaryManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Double> salaries = new HashMap<>();

        // Read the initial number of employees
        System.out.print("Enter the number of employees: ");
        int numberOfEmployees = scanner.nextInt();

        if (numberOfEmployees <= 0) {
            System.out.println("Invalid number of employees.");
            scanner.close();
            return;
        }

        // Read initial employee records
        for (int i = 1; i <= numberOfEmployees; i++) {
            System.out.print("Enter employee ID: ");
            int employeeId = scanner.nextInt();

            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();

            if (salaries.containsKey(employeeId)) {
                System.out.println("Employee ID already exists. Record not added.");
            } else {
                salaries.put(employeeId, salary);
            }
        }

        int choice;

        // Display the menu repeatedly
        do {
            System.out.println("\n===== EMPLOYEE SALARY MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Display Salary Statistics");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new employee
                    System.out.print("Enter employee ID: ");
                    int newEmployeeId = scanner.nextInt();

                    if (salaries.containsKey(newEmployeeId)) {
                        System.out.println("Employee ID already exists.");
                    } else {
                        System.out.print("Enter salary: ");
                        double newSalary = scanner.nextDouble();

                        salaries.put(newEmployeeId, newSalary);
                        System.out.println("Employee added successfully.");
                    }
                    break;

                case 2:
                    // Search for an employee
                    System.out.print("Enter employee ID: ");
                    int searchId = scanner.nextInt();

                    if (salaries.containsKey(searchId)) {
                        System.out.println(
                                "Salary: " + salaries.get(searchId)
                        );
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    // Update an employee salary
                    System.out.print("Enter employee ID: ");
                    int updateId = scanner.nextInt();

                    if (salaries.containsKey(updateId)) {
                        System.out.print("Enter the new salary: ");
                        double updatedSalary = scanner.nextDouble();

                        salaries.replace(updateId, updatedSalary);
                        System.out.println("Salary updated successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    // Remove an employee
                    System.out.print("Enter employee ID: ");
                    int removeId = scanner.nextInt();

                    if (salaries.remove(removeId) != null) {
                        System.out.println("Employee removed successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    // Display all employees
                    System.out.println("\nAll employees:");

                    if (salaries.isEmpty()) {
                        System.out.println("No employee records found.");
                    } else {
                        for (Map.Entry<Integer, Double> entry
                                : salaries.entrySet()) {
                            System.out.println(
                                    "ID: " + entry.getKey()
                                            + " | Salary: " + entry.getValue()
                            );
                        }
                    }
                    break;

                case 6:
                    // Calculate salary statistics
                    if (salaries.isEmpty()) {
                        System.out.println("No salary records available.");
                        break;
                    }

                    double highestSalary = Double.MIN_VALUE;
                    double lowestSalary = Double.MAX_VALUE;
                    double totalPayroll = 0;

                    for (double salary : salaries.values()) {
                        if (salary > highestSalary) {
                            highestSalary = salary;
                        }

                        if (salary < lowestSalary) {
                            lowestSalary = salary;
                        }

                        totalPayroll += salary;
                    }

                    double averageSalary = totalPayroll / salaries.size();

                    System.out.printf("Highest salary: %.2f%n", highestSalary);
                    System.out.printf("Lowest salary: %.2f%n", lowestSalary);
                    System.out.printf("Average salary: %.2f%n", averageSalary);
                    System.out.printf("Total payroll: %.2f%n", totalPayroll);
                    break;

                case 7:
                    // Exit the program
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 7);

        scanner.close();
    }
}