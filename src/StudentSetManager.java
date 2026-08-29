import java.util.HashSet;
import java.util.Scanner;

// This class runs the student set manager program.
public class StudentSetManager {

    // Run the program.
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create HashSet to store unique student IDs
        HashSet<Integer> studentIds = new HashSet<>();

        // Ask user for number of student IDs
        System.out.print("Enter number of student IDs: ");
        // Read the number of students from the user.
        int numberOfStudents = input.nextInt();

        // Check if number is valid
        if (numberOfStudents <= 0) {

            // Display information to the user.
            System.out.println("Invalid number of students.");

        // Handle the other case.
        } else {

            // Read student IDs
            for (int i = 1; i <= numberOfStudents; i++) {

                // Display information to the user.
                System.out.print("Enter student ID " + i + ": ");
                // Read the student id from the user.
                int studentId = input.nextInt();

                // Try to add ID to HashSet
                boolean added = studentIds.add(studentId);

                // Display message if duplicate
                if (!added) {
                    // Display information to the user.
                    System.out.println("Duplicate ID detected. ID was not added.");
                }
            }

            // Count unique IDs
            int uniqueStudents = studentIds.size();

            // Determine registration type
            String registrationType;

            // Check whether this condition is true.
            if (uniqueStudents < 5) {
                // Set the registration type value.
                registrationType = "Small Registration";
            // Check the next condition.
            } else if (uniqueStudents <= 10) {
                // Set the registration type value.
                registrationType = "Medium Registration";
            // Handle the other case.
            } else {
                // Set the registration type value.
                registrationType = "Large Registration";
            }

            // Display results
            System.out.println("Total IDs entered: " + numberOfStudents);
            // Display information to the user.
            System.out.println("Total unique student IDs: " + uniqueStudents);
            // Display information to the user.
            System.out.println("All unique student IDs: " + studentIds);
            // Display information to the user.
            System.out.println("Registration classification: " + registrationType);
        }

        // Close Scanner
        input.close();
    }
}