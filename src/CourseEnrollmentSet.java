import java.util.HashSet;
import java.util.Scanner;

// This class runs the course enrollment set program.
public class CourseEnrollmentSet {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Create a HashSet to store unique courses.
        HashSet<String> courses = new HashSet<>();

        // Read the number of courses
        System.out.print("Enter the number of courses: ");
        // Read the number of courses from the user.
        int numberOfCourses = scanner.nextInt();
        // Clear the remaining new line from the input.
        scanner.nextLine();

        // Check whether this condition is true.
        if (numberOfCourses <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of courses.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read and store course names
        for (int i = 1; i <= numberOfCourses; i++) {
            // Display information to the user.
            System.out.print("Enter course " + i + ": ");
            // Read the course name from the user.
            String courseName = scanner.nextLine();

            // Check whether this condition is true.
            if (!courses.add(courseName)) {
                // Display information to the user.
                System.out.println(
                        "Course already exists. Duplicate entries are not allowed."
                );
            }
        }

        // Remove a course
        System.out.print("\nEnter a course name to remove: ");
        // Read the course to remove from the user.
        String courseToRemove = scanner.nextLine();

        // Store the removal result.
        String removalResult;

        // Check whether this condition is true.
        if (courses.remove(courseToRemove)) {
            // Set the removal result value.
            removalResult = "Course removed successfully.";
        // Handle the other case.
        } else {
            // Set the removal result value.
            removalResult = "Course not found.";
        }

        // Classify the remaining courses
        String classification;

        // Check whether this condition is true.
        if (courses.size() < 4) {
            // Set the classification value.
            classification = "Small Course Catalog";
        // Check the next condition.
        } else if (courses.size() <= 8) {
            // Set the classification value.
            classification = "Medium Course Catalog";
        // Handle the other case.
        } else {
            // Set the classification value.
            classification = "Large Course Catalog";
        }

        // Display results
        System.out.println("\nTotal courses entered: " + numberOfCourses);
        // Display information to the user.
        System.out.println("Total unique courses remaining: " + courses.size());
        // Display information to the user.
        System.out.println("All remaining course names: " + courses);
        // Display information to the user.
        System.out.println("Removal result: " + removalResult);
        // Display information to the user.
        System.out.println("Course catalog classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}