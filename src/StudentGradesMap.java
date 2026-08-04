import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradesMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Double> grades = new HashMap<>();

        // Read the number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
            scanner.close();
            return;
        }

        // Read and store student grades
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Enter student ID: ");
            int studentId = scanner.nextInt();

            System.out.print("Enter student grade: ");
            double grade = scanner.nextDouble();

            if (grades.containsKey(studentId)) {
                System.out.println("Student ID already exists. Record not added.");
            } else {
                grades.put(studentId, grade);
            }
        }

        // Update a student's grade
        System.out.print("\nEnter a student ID to update: ");
        int updateId = scanner.nextInt();

        if (grades.containsKey(updateId)) {
            System.out.print("Enter the new grade: ");
            double newGrade = scanner.nextDouble();

            grades.replace(updateId, newGrade);
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }

        // Calculate the average grade
        double totalGrades = 0;

        for (double grade : grades.values()) {
            totalGrades += grade;
        }

        double averageGrade = grades.isEmpty()
                ? 0
                : totalGrades / grades.size();

        // Classify class performance
        String classification;

        if (averageGrade < 60) {
            classification = "Needs Improvement";
        } else if (averageGrade <= 84) {
            classification = "Good Performance";
        } else {
            classification = "Excellent Performance";
        }

        // Display results
        System.out.println("\nTotal student records: " + grades.size());
        System.out.println("All student IDs and grades:");

        for (Map.Entry<Integer, Double> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.printf("Average grade: %.2f%n", averageGrade);
        System.out.println("Class performance classification: " + classification);

        scanner.close();
    }
}