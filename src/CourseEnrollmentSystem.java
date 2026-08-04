import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
public class CourseEnrollmentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> studentIds = new HashSet<>();
        HashMap<Integer, String> enrollments = new HashMap<>();

        // Read the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
            scanner.close();
            return;
        }

        // Read and store enrollment records
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Enter student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();

            if (studentIds.contains(studentId)) {
                System.out.println("Student ID already exists. Record not added.");
            } else {
                studentIds.add(studentId);
                enrollments.put(studentId, courseName);
            }
        }

        // Update a student's course
        System.out.print("\nEnter a student ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();

        if (studentIds.contains(updateId)) {
            System.out.print("Enter the new course name: ");
            String newCourse = scanner.nextLine();

            enrollments.replace(updateId, newCourse);
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }

        // Classify the enrollment
        String classification;

        if (studentIds.size() < 5) {
            classification = "Small Enrollment";
        } else if (studentIds.size() <= 15) {
            classification = "Medium Enrollment";
        } else {
            classification = "Large Enrollment";
        }

        // Display results
        System.out.println("\nTotal student records entered: " + numberOfStudents);
        System.out.println("Total unique students: " + studentIds.size());
        System.out.println("All student IDs: " + studentIds);
        System.out.println("All student IDs with enrolled courses:");

        for (Map.Entry<Integer, String> entry : enrollments.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Enrollment classification: " + classification);

        scanner.close();
    }
}