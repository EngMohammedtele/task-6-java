import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

class UniversityCourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> studentIds = new HashSet<>();
        HashMap<Integer, HashSet<String>> registrations = new HashMap<>();

        // Read the initial number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
            scanner.close();
            return;
        }

        // Read student records and their courses
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("\nEnter student ID: ");
            int studentId = scanner.nextInt();

            if (studentIds.contains(studentId)) {
                System.out.println("Student ID already exists. Record skipped.");
                scanner.nextLine();
                continue;
            }

            studentIds.add(studentId);

            System.out.print("Enter the number of courses: ");
            int numberOfCourses = scanner.nextInt();
            scanner.nextLine();

            HashSet<String> courses = new HashSet<>();

            for (int j = 1; j <= numberOfCourses; j++) {
                System.out.print("Enter course " + j + ": ");
                String courseName = scanner.nextLine();

                if (!courses.add(courseName)) {
                    System.out.println("Duplicate course. Course was not added.");
                }
            }

            registrations.put(studentId, courses);
        }

        int choice;

        // Display the menu repeatedly
        do {
            System.out.println("\n===== UNIVERSITY REGISTRATION MENU =====");
            System.out.println("1. Search Student");
            System.out.println("2. Add Course to Student");
            System.out.println("3. Remove Course from Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Display Registration Statistics");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Search for a student
                    System.out.print("Enter student ID: ");
                    int searchId = scanner.nextInt();

                    if (registrations.containsKey(searchId)) {
                        System.out.println(
                                "Registered courses: " + registrations.get(searchId)
                        );
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 2:
                    // Add a course
                    System.out.print("Enter student ID: ");
                    int addStudentId = scanner.nextInt();
                    scanner.nextLine();

                    if (!registrations.containsKey(addStudentId)) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.print("Enter course name: ");
                        String courseToAdd = scanner.nextLine();

                        HashSet<String> studentCourses =
                                registrations.get(addStudentId);

                        if (studentCourses.add(courseToAdd)) {
                            registrations.replace(addStudentId, studentCourses);
                            System.out.println("Course added successfully.");
                        } else {
                            System.out.println(
                                    "Course already registered. Duplicate not allowed."
                            );
                        }
                    }
                    break;

                case 3:
                    // Remove a course
                    System.out.print("Enter student ID: ");
                    int removeStudentId = scanner.nextInt();
                    scanner.nextLine();

                    if (!registrations.containsKey(removeStudentId)) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.print("Enter course name to remove: ");
                        String courseToRemove = scanner.nextLine();

                        HashSet<String> studentCourses =
                                registrations.get(removeStudentId);

                        if (studentCourses.remove(courseToRemove)) {
                            registrations.replace(removeStudentId, studentCourses);
                            System.out.println("Course removed successfully.");
                        } else {
                            System.out.println("Course not found.");
                        }
                    }
                    break;

                case 4:
                    // Display all students in ascending ID order
                    if (registrations.isEmpty()) {
                        System.out.println("No students registered.");
                    } else {
                        TreeSet<Integer> sortedIds =
                                new TreeSet<>(registrations.keySet());

                        for (int studentId : sortedIds) {
                            System.out.println(
                                    "Student ID: " + studentId
                                            + " | Courses: " + registrations.get(studentId)
                            );
                        }
                    }
                    break;

                case 5:
                    // Display registration statistics
                    int totalRegistrations = 0;
                    int highestStudentId = 0;
                    int lowestStudentId = 0;
                    int highestCourses = -1;
                    int lowestCourses = Integer.MAX_VALUE;

                    for (Map.Entry<Integer, HashSet<String>> entry
                            : registrations.entrySet()) {
                        int courseCount = entry.getValue().size();
                        totalRegistrations += courseCount;

                        if (courseCount > highestCourses) {
                            highestCourses = courseCount;
                            highestStudentId = entry.getKey();
                        }

                        if (courseCount < lowestCourses) {
                            lowestCourses = courseCount;
                            lowestStudentId = entry.getKey();
                        }
                    }

                    double averageCourses = registrations.isEmpty()
                            ? 0
                            : (double) totalRegistrations / registrations.size();

                    System.out.println("\nTotal number of students: "
                            + registrations.size());
                    System.out.println("Total course registrations: "
                            + totalRegistrations);

                    if (!registrations.isEmpty()) {
                        System.out.println("Student with highest courses: "
                                + highestStudentId
                                + " (" + highestCourses + " courses)");

                        System.out.println("Student with lowest courses: "
                                + lowestStudentId
                                + " (" + lowestCourses + " courses)");
                    }

                    System.out.printf(
                            "Average courses per student: %.2f%n",
                            averageCourses
                    );
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}