import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAttendanceManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> attendance = new HashMap<>();

        // Read the initial number of students
        System.out.print("Enter the number of student records: ");
        int numberOfStudents = scanner.nextInt();

        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
            scanner.close();
            return;
        }

        // Read initial attendance records
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Enter student ID: ");
            int studentId = scanner.nextInt();

            System.out.print("Enter attended days: ");
            int attendedDays = scanner.nextInt();

            if (attendance.containsKey(studentId)) {
                System.out.println("Student ID already exists. Record not added.");
            } else {
                attendance.put(studentId, attendedDays);
            }
        }

        int choice;

        // Display the menu repeatedly
        do {
            System.out.println("\n===== STUDENT ATTENDANCE MENU =====");
            System.out.println("1. Add Student Record");
            System.out.println("2. Search Student Attendance");
            System.out.println("3. Update Attendance");
            System.out.println("4. Remove Student Record");
            System.out.println("5. Display All Attendance Records");
            System.out.println("6. Display Attendance Statistics");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new attendance record
                    System.out.print("Enter student ID: ");
                    int newStudentId = scanner.nextInt();

                    if (attendance.containsKey(newStudentId)) {
                        System.out.println("Student ID already exists.");
                    } else {
                        System.out.print("Enter attended days: ");
                        int newAttendance = scanner.nextInt();

                        attendance.put(newStudentId, newAttendance);
                        System.out.println("Student record added successfully.");
                    }
                    break;

                case 2:
                    // Search for student attendance
                    System.out.print("Enter student ID: ");
                    int searchId = scanner.nextInt();

                    if (attendance.containsKey(searchId)) {
                        System.out.println(
                                "Attended days: " + attendance.get(searchId)
                        );
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    // Update attendance
                    System.out.print("Enter student ID: ");
                    int updateId = scanner.nextInt();

                    if (attendance.containsKey(updateId)) {
                        System.out.print("Enter the new attendance value: ");
                        int updatedAttendance = scanner.nextInt();

                        attendance.replace(updateId, updatedAttendance);
                        System.out.println("Attendance updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Remove a student record
                    System.out.print("Enter student ID: ");
                    int removeId = scanner.nextInt();

                    if (attendance.remove(removeId) != null) {
                        System.out.println("Student record removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    // Display all attendance records
                    System.out.println("\nAll attendance records:");

                    if (attendance.isEmpty()) {
                        System.out.println("No attendance records found.");
                    } else {
                        for (Map.Entry<Integer, Integer> entry
                                : attendance.entrySet()) {
                            System.out.println(
                                    "Student ID: " + entry.getKey()
                                            + " | Attended days: " + entry.getValue()
                            );
                        }
                    }
                    break;

                case 6:
                    // Calculate attendance statistics
                    if (attendance.isEmpty()) {
                        System.out.println(
                                "No attendance records available."
                        );
                        break;
                    }

                    int totalAttendanceDays = 0;
                    int highestAttendance = Integer.MIN_VALUE;
                    int lowestAttendance = Integer.MAX_VALUE;
                    int highestStudentId = 0;
                    int lowestStudentId = 0;

                    for (Map.Entry<Integer, Integer> entry
                            : attendance.entrySet()) {
                        int studentId = entry.getKey();
                        int days = entry.getValue();

                        totalAttendanceDays += days;

                        if (days > highestAttendance) {
                            highestAttendance = days;
                            highestStudentId = studentId;
                        }

                        if (days < lowestAttendance) {
                            lowestAttendance = days;
                            lowestStudentId = studentId;
                        }
                    }

                    double averageAttendance =
                            (double) totalAttendanceDays / attendance.size();

                    System.out.println(
                            "Total number of students: " + attendance.size()
                    );
                    System.out.println(
                            "Total attendance days: " + totalAttendanceDays
                    );
                    System.out.printf(
                            "Average attendance: %.2f%n",
                            averageAttendance
                    );
                    System.out.println(
                            "Student with highest attendance: "
                                    + highestStudentId + " (" + highestAttendance + " days)"
                    );
                    System.out.println(
                            "Student with lowest attendance: "
                                    + lowestStudentId + " (" + lowestAttendance + " days)"
                    );
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