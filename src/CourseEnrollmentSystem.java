import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
// This class runs the course enrollment system program.
public class CourseEnrollmentSystem {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Create a HashSet to store unique student ids.
        HashSet<Integer> studentIds = new HashSet<>();
        // Map each student ID to the student's course.
        HashMap<Integer, String> enrollments = new HashMap<>();

        // Read the number of students
        System.out.print("Enter the number of students: ");
        // Read the number of students from the user.
        int numberOfStudents = scanner.nextInt();
        // Clear the remaining new line from the input.
        scanner.nextLine();

        // Check whether this condition is true.
        if (numberOfStudents <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of students.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read and store enrollment records
        for (int i = 1; i <= numberOfStudents; i++) {
            // Display information to the user.
            System.out.print("Enter student ID: ");
            // Read the student id from the user.
            int studentId = scanner.nextInt();
            // Clear the remaining new line from the input.
            scanner.nextLine();

            // Display information to the user.
            System.out.print("Enter course name: ");
            // Read the course name from the user.
            String courseName = scanner.nextLine();

            // Check whether this condition is true.
            if (studentIds.contains(studentId)) {
                // Display information to the user.
                System.out.println("Student ID already exists. Record not added.");
            // Handle the other case.
            } else {
                // Add an item to the student ids.
                studentIds.add(studentId);
                // Add a key and value to the enrollments.
                enrollments.put(studentId, courseName);
            }
        }

        // Update a student's course
        System.out.print("\nEnter a student ID to update: ");
        // Read the update id from the user.
        int updateId = scanner.nextInt();
        // Clear the remaining new line from the input.
        scanner.nextLine();

        // Check whether this condition is true.
        if (studentIds.contains(updateId)) {
            // Display information to the user.
            System.out.print("Enter the new course name: ");
            // Read the new course from the user.
            String newCourse = scanner.nextLine();

            // Replace a value in the enrollments.
            enrollments.replace(updateId, newCourse);
            // Display information to the user.
            System.out.println("Course updated successfully.");
        // Handle the other case.
        } else {
            // Display information to the user.
            System.out.println("Student ID not found.");
        }

        // Classify the enrollment
        String classification;

        // Check whether this condition is true.
        if (studentIds.size() < 5) {
            // Set the classification value.
            classification = "Small Enrollment";
        // Check the next condition.
        } else if (studentIds.size() <= 15) {
            // Set the classification value.
            classification = "Medium Enrollment";
        // Handle the other case.
        } else {
            // Set the classification value.
            classification = "Large Enrollment";
        }

        // Display results
        System.out.println("\nTotal student records entered: " + numberOfStudents);
        // Display information to the user.
        System.out.println("Total unique students: " + studentIds.size());
        // Display information to the user.
        System.out.println("All student IDs: " + studentIds);
        // Display information to the user.
        System.out.println("All student IDs with enrolled courses:");

        // Go through each item in the collection.
        for (Map.Entry<Integer, String> entry : enrollments.entrySet()) {
            // Display information to the user.
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display information to the user.
        System.out.println("Enrollment classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}