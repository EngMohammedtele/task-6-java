import java.util.HashSet;
import java.util.Scanner;

public class StudentSetManager {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create HashSet to store unique student IDs
        HashSet<Integer> studentIds = new HashSet<>();

        // Ask user for number of student IDs
        System.out.print("Enter number of student IDs: ");
        int numberOfStudents = input.nextInt();

        // Check if number is valid
        if (numberOfStudents <= 0) {

            System.out.println("Invalid number of students.");

        } else {

            // Read student IDs
            for (int i = 1; i <= numberOfStudents; i++) {

                System.out.print("Enter student ID " + i + ": ");
                int studentId = input.nextInt();

                // Try to add ID to HashSet
                boolean added = studentIds.add(studentId);

                // Display message if duplicate
                if (!added) {
                    System.out.println("Duplicate ID detected. ID was not added.");
                }
            }

            // Count unique IDs
            int uniqueStudents = studentIds.size();

            // Determine registration type
            String registrationType;

            if (uniqueStudents < 5) {
                registrationType = "Small Registration";
            } else if (uniqueStudents <= 10) {
                registrationType = "Medium Registration";
            } else {
                registrationType = "Large Registration";
            }

            // Display results
            System.out.println("Total IDs entered: " + numberOfStudents);
            System.out.println("Total unique student IDs: " + uniqueStudents);
            System.out.println("All unique student IDs: " + studentIds);
            System.out.println("Registration classification: " + registrationType);
        }

        // Close Scanner
        input.close();
    }
}