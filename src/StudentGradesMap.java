import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This class runs the student grades map program.
public class StudentGradesMap {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Create a HashMap to store grades as key and value pairs.
        Map<Integer, Double> grades = new HashMap<>();

        // Read the number of students
        System.out.print("Enter the number of students: ");
        // Read the number of students from the user.
        int numberOfStudents = scanner.nextInt();

        // Check whether this condition is true.
        if (numberOfStudents <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of students.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read and store student grades
        for (int i = 1; i <= numberOfStudents; i++) {
            // Display information to the user.
            System.out.print("Enter student ID: ");
            // Read the student id from the user.
            int studentId = scanner.nextInt();

            // Display information to the user.
            System.out.print("Enter student grade: ");
            // Read the grade from the user.
            double grade = scanner.nextDouble();

            // Check whether this condition is true.
            if (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100. Record not added.");
            } else if (grades.containsKey(studentId)) {
                // Display information to the user.
                System.out.println("Student ID already exists. Record not added.");
            // Handle the other case.
            } else {
                // Add a key and value to the grades.
                grades.put(studentId, grade);
            }
        }

        // Update a student's grade
        System.out.print("\nEnter a student ID to update: ");
        // Read the update id from the user.
        int updateId = scanner.nextInt();

        // Check whether this condition is true.
        if (grades.containsKey(updateId)) {
            // Display information to the user.
            System.out.print("Enter the new grade: ");
            // Read the new grade from the user.
            double newGrade = scanner.nextDouble();

            if (newGrade < 0 || newGrade > 100) {
                System.out.println("Grade must be between 0 and 100. Grade not updated.");
            } else {
                // Replace a value in the grades.
                grades.replace(updateId, newGrade);
                // Display information to the user.
                System.out.println("Grade updated successfully.");
            }
        // Handle the other case.
        } else {
            // Display information to the user.
            System.out.println("Student ID not found.");
        }

        // Calculate the average grade
        double totalGrades = 0;

        // Go through each item in the collection.
        for (double grade : grades.values()) {
            // Update the total grades calculation.
            totalGrades += grade;
        }

        // Use zero when empty or calculate the average grade.
        double averageGrade = grades.isEmpty()
                ? 0
                : totalGrades / grades.size();

        // Classify class performance
        String classification;

        // Check whether this condition is true.
        if (averageGrade < 60) {
            // Set the classification value.
            classification = "Needs Improvement";
        // Check the next condition.
        } else if (averageGrade <= 84) {
            // Set the classification value.
            classification = "Good Performance";
        // Handle the other case.
        } else {
            // Set the classification value.
            classification = "Excellent Performance";
        }

        // Display results
        System.out.println("\nTotal student records: " + grades.size());
        // Display information to the user.
        System.out.println("All student IDs and grades:");

        // Go through each item in the collection.
        for (Map.Entry<Integer, Double> entry : grades.entrySet()) {
            // Display information to the user.
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display information to the user.
        System.out.printf("Average grade: %.2f%n", averageGrade);
        // Display information to the user.
        System.out.println("Class performance classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}
