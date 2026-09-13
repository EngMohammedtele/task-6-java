import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This class runs the student attendance manager program.
public class StudentAttendanceManager {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Map each student ID to the number of attended days.
        HashMap<Integer, Integer> attendance = new HashMap<>();

        // Read the initial number of students
        System.out.print("Enter the number of student records: ");
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

        // Read initial attendance records
        for (int i = 1; i <= numberOfStudents; i++) {
            // Display information to the user.
            System.out.print("Enter student ID: ");
            // Read the student id from the user.
            int studentId = scanner.nextInt();

            // Display information to the user.
            System.out.print("Enter attended days: ");
            // Read the attended days from the user.
            int attendedDays = scanner.nextInt();

            // Check whether this condition is true.
            if (attendedDays < 0) {
                System.out.println("Attended days cannot be negative. Record not added.");
            } else if (attendance.containsKey(studentId)) {
                // Display information to the user.
                System.out.println("Student ID already exists. Record not added.");
            // Handle the other case.
            } else {
                // Add a key and value to the attendance.
                attendance.put(studentId, attendedDays);
            }
        }

        // Store the choice.
        int choice;

        // Display the menu repeatedly
        do {
            // Display information to the user.
            System.out.println("\n===== STUDENT ATTENDANCE MENU =====");
            // Display information to the user.
            System.out.println("1. Add Student Record");
            // Display information to the user.
            System.out.println("2. Search Student Attendance");
            // Display information to the user.
            System.out.println("3. Update Attendance");
            // Display information to the user.
            System.out.println("4. Remove Student Record");
            // Display information to the user.
            System.out.println("5. Display All Attendance Records");
            // Display information to the user.
            System.out.println("6. Display Attendance Statistics");
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
                    // Add a new attendance record
                    System.out.print("Enter student ID: ");
                    // Read the new student id from the user.
                    int newStudentId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (attendance.containsKey(newStudentId)) {
                        // Display information to the user.
                        System.out.println("Student ID already exists.");
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.print("Enter attended days: ");
                        // Read the new attendance from the user.
                        int newAttendance = scanner.nextInt();

                        if (newAttendance < 0) {
                            System.out.println("Attended days cannot be negative. Record not added.");
                        } else {
                            // Add a key and value to the attendance.
                            attendance.put(newStudentId, newAttendance);
                            // Display information to the user.
                            System.out.println("Student record added successfully.");
                        }
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 2:
                    // Search for student attendance
                    System.out.print("Enter student ID: ");
                    // Read the search id from the user.
                    int searchId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (attendance.containsKey(searchId)) {
                        // Display information to the user.
                        System.out.println(
                                "Attended days: " + attendance.get(searchId)
                        );
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.println("Student not found.");
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 3:
                    // Update attendance
                    System.out.print("Enter student ID: ");
                    // Read the update id from the user.
                    int updateId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (attendance.containsKey(updateId)) {
                        // Display information to the user.
                        System.out.print("Enter the new attendance value: ");
                        // Read the updated attendance from the user.
                        int updatedAttendance = scanner.nextInt();

                        if (updatedAttendance < 0) {
                            System.out.println("Attended days cannot be negative. Attendance not updated.");
                        } else {
                            // Replace a value in the attendance.
                            attendance.replace(updateId, updatedAttendance);
                            // Display information to the user.
                            System.out.println("Attendance updated successfully.");
                        }
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.println("Student not found.");
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 4:
                    // Remove a student record
                    System.out.print("Enter student ID: ");
                    // Read the remove id from the user.
                    int removeId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (attendance.remove(removeId) != null) {
                        // Display information to the user.
                        System.out.println("Student record removed successfully.");
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.println("Student not found.");
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 5:
                    // Display all attendance records
                    System.out.println("\nAll attendance records:");

                    // Check whether this condition is true.
                    if (attendance.isEmpty()) {
                        // Display information to the user.
                        System.out.println("No attendance records found.");
                    // Handle the other case.
                    } else {
                        // Repeat the loop for the required number of times.
                        for (Map.Entry<Integer, Integer> entry
                                : attendance.entrySet()) {
                            // Display information to the user.
                            System.out.println(
                                    "Student ID: " + entry.getKey()
                                            + " | Attended days: " + entry.getValue()
                            );
                        }
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 6:
                    // Calculate attendance statistics
                    if (attendance.isEmpty()) {
                        // Display information to the user.
                        System.out.println(
                                "No attendance records available."
                        );
                        // Leave this menu choice.
                        break;
                    }

                    // Store the total attendance days.
                    int totalAttendanceDays = 0;
                    // Calculate and store the highest attendance.
                    int highestAttendance = Integer.MIN_VALUE;
                    // Calculate and store the lowest attendance.
                    int lowestAttendance = Integer.MAX_VALUE;
                    // Store the highest student id.
                    int highestStudentId = 0;
                    // Store the lowest student id.
                    int lowestStudentId = 0;

                    // Repeat the loop for the required number of times.
                    for (Map.Entry<Integer, Integer> entry
                            : attendance.entrySet()) {
                        // Store the student id.
                        int studentId = entry.getKey();
                        // Store the days.
                        int days = entry.getValue();

                        // Update the total attendance days calculation.
                        totalAttendanceDays += days;

                        // Check whether this condition is true.
                        if (days > highestAttendance) {
                            // Set the highest attendance value.
                            highestAttendance = days;
                            // Set the highest student id value.
                            highestStudentId = studentId;
                        }

                        // Check whether this condition is true.
                        if (days < lowestAttendance) {
                            // Set the lowest attendance value.
                            lowestAttendance = days;
                            // Set the lowest student id value.
                            lowestStudentId = studentId;
                        }
                    }

                    // Store the average attendance.
                    double averageAttendance =
                            (double) totalAttendanceDays / attendance.size();

                    // Display information to the user.
                    System.out.println(
                            "Total number of students: " + attendance.size()
                    );
                    // Display information to the user.
                    System.out.println(
                            "Total attendance days: " + totalAttendanceDays
                    );
                    // Display information to the user.
                    System.out.printf(
                            "Average attendance: %.2f%n",
                            // Run this step.
                            averageAttendance
                    );
                    // Display information to the user.
                    System.out.println(
                            "Student with highest attendance: "
                                    + highestStudentId + " (" + highestAttendance + " days)"
                    );
                    // Display information to the user.
                    System.out.println(
                            "Student with lowest attendance: "
                                    + lowestStudentId + " (" + lowestAttendance + " days)"
                    );
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
