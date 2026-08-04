import java.util.HashSet;
import java.util.Scanner;

public class CourseEnrollmentSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> courses = new HashSet<>();

        // Read the number of courses
        System.out.print("Enter the number of courses: ");
        int numberOfCourses = scanner.nextInt();
        scanner.nextLine();

        if (numberOfCourses <= 0) {
            System.out.println("Invalid number of courses.");
            scanner.close();
            return;
        }

        // Read and store course names
        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.print("Enter course " + i + ": ");
            String courseName = scanner.nextLine();

            if (!courses.add(courseName)) {
                System.out.println(
                        "Course already exists. Duplicate entries are not allowed."
                );
            }
        }

        // Remove a course
        System.out.print("\nEnter a course name to remove: ");
        String courseToRemove = scanner.nextLine();

        String removalResult;

        if (courses.remove(courseToRemove)) {
            removalResult = "Course removed successfully.";
        } else {
            removalResult = "Course not found.";
        }

        // Classify the remaining courses
        String classification;

        if (courses.size() < 4) {
            classification = "Small Course Catalog";
        } else if (courses.size() <= 8) {
            classification = "Medium Course Catalog";
        } else {
            classification = "Large Course Catalog";
        }

        // Display results
        System.out.println("\nTotal courses entered: " + numberOfCourses);
        System.out.println("Total unique courses remaining: " + courses.size());
        System.out.println("All remaining course names: " + courses);
        System.out.println("Removal result: " + removalResult);
        System.out.println("Course catalog classification: " + classification);

        scanner.close();
    }
}