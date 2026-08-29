import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

// This class runs the university course registration system program.
class UniversityCourseRegistrationSystem {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Create a HashSet to store unique student ids.
        HashSet<Integer> studentIds = new HashSet<>();
        // Map each student ID to a set of registered courses.
        HashMap<Integer, HashSet<String>> registrations = new HashMap<>();

        // Read the initial number of students
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

        // Read student records and their courses
        for (int i = 1; i <= numberOfStudents; i++) {
            // Display information to the user.
            System.out.print("\nEnter student ID: ");
            // Read the student id from the user.
            int studentId = scanner.nextInt();

            // Check whether this condition is true.
            if (studentIds.contains(studentId)) {
                // Display information to the user.
                System.out.println("Student ID already exists. Record skipped.");
                // Clear the remaining new line from the input.
                scanner.nextLine();
                // Skip this record and continue the loop.
                continue;
            }

            // Add an item to the student ids.
            studentIds.add(studentId);

            // Display information to the user.
            System.out.print("Enter the number of courses: ");
            // Read the number of courses from the user.
            int numberOfCourses = scanner.nextInt();
            // Clear the remaining new line from the input.
            scanner.nextLine();

            // Create a HashSet to store unique courses.
            HashSet<String> courses = new HashSet<>();

            // Repeat the loop for the required number of times.
            for (int j = 1; j <= numberOfCourses; j++) {
                // Display information to the user.
                System.out.print("Enter course " + j + ": ");
                // Read the course name from the user.
                String courseName = scanner.nextLine();

                // Check whether this condition is true.
                if (!courses.add(courseName)) {
                    // Display information to the user.
                    System.out.println("Duplicate course. Course was not added.");
                }
            }

            // Add a key and value to the registrations.
            registrations.put(studentId, courses);
        }

        // Store the choice.
        int choice;

        // Display the menu repeatedly
        do {
            // Display information to the user.
            System.out.println("\n===== UNIVERSITY REGISTRATION MENU =====");
            // Display information to the user.
            System.out.println("1. Search Student");
            // Display information to the user.
            System.out.println("2. Add Course to Student");
            // Display information to the user.
            System.out.println("3. Remove Course from Student");
            // Display information to the user.
            System.out.println("4. Display All Students");
            // Display information to the user.
            System.out.println("5. Display Registration Statistics");
            // Display information to the user.
            System.out.println("6. Exit");
            // Display information to the user.
            System.out.print("Enter your choice: ");

            // Read the choice from the user.
            choice = scanner.nextInt();
            // Clear the remaining new line from the input.
            scanner.nextLine();

            // Choose an action from the menu choice.
            switch (choice) {
                // Handle this menu choice.
                case 1:
                    // Search for a student
                    System.out.print("Enter student ID: ");
                    // Read the search id from the user.
                    int searchId = scanner.nextInt();

                    // Check whether this condition is true.
                    if (registrations.containsKey(searchId)) {
                        // Display information to the user.
                        System.out.println(
                                "Registered courses: " + registrations.get(searchId)
                        );
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.println("Student not found.");
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 2:
                    // Add a course
                    System.out.print("Enter student ID: ");
                    // Read the add student id from the user.
                    int addStudentId = scanner.nextInt();
                    // Clear the remaining new line from the input.
                    scanner.nextLine();

                    // Check whether this condition is true.
                    if (!registrations.containsKey(addStudentId)) {
                        // Display information to the user.
                        System.out.println("Student not found.");
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.print("Enter course name: ");
                        // Read the course to add from the user.
                        String courseToAdd = scanner.nextLine();

                        // Store the student courses from the collection.
                        HashSet<String> studentCourses =
                                registrations.get(addStudentId);

                        // Check whether this condition is true.
                        if (studentCourses.add(courseToAdd)) {
                            // Replace a value in the registrations.
                            registrations.replace(addStudentId, studentCourses);
                            // Display information to the user.
                            System.out.println("Course added successfully.");
                        // Handle the other case.
                        } else {
                            // Display information to the user.
                            System.out.println(
                                    "Course already registered. Duplicate not allowed."
                            );
                        }
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 3:
                    // Remove a course
                    System.out.print("Enter student ID: ");
                    // Read the remove student id from the user.
                    int removeStudentId = scanner.nextInt();
                    // Clear the remaining new line from the input.
                    scanner.nextLine();

                    // Check whether this condition is true.
                    if (!registrations.containsKey(removeStudentId)) {
                        // Display information to the user.
                        System.out.println("Student not found.");
                    // Handle the other case.
                    } else {
                        // Display information to the user.
                        System.out.print("Enter course name to remove: ");
                        // Read the course to remove from the user.
                        String courseToRemove = scanner.nextLine();

                        // Store the student courses from the collection.
                        HashSet<String> studentCourses =
                                registrations.get(removeStudentId);

                        // Check whether this condition is true.
                        if (studentCourses.remove(courseToRemove)) {
                            // Replace a value in the registrations.
                            registrations.replace(removeStudentId, studentCourses);
                            // Display information to the user.
                            System.out.println("Course removed successfully.");
                        // Handle the other case.
                        } else {
                            // Display information to the user.
                            System.out.println("Course not found.");
                        }
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 4:
                    // Display all students in ascending ID order
                    if (registrations.isEmpty()) {
                        // Display information to the user.
                        System.out.println("No students registered.");
                    // Handle the other case.
                    } else {
                        // Store the sorted ids from the collection.
                        TreeSet<Integer> sortedIds =
                                new TreeSet<>(registrations.keySet());

                        // Go through each item in the collection.
                        for (int studentId : sortedIds) {
                            // Display information to the user.
                            System.out.println(
                                    "Student ID: " + studentId
                                            + " | Courses: " + registrations.get(studentId)
                            );
                        }
                    }
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 5:
                    // Display registration statistics
                    int totalRegistrations = 0;
                    // Store the highest student id.
                    int highestStudentId = 0;
                    // Store the lowest student id.
                    int lowestStudentId = 0;
                    // Calculate and store the highest courses.
                    int highestCourses = -1;
                    // Calculate and store the lowest courses.
                    int lowestCourses = Integer.MAX_VALUE;

                    // Repeat the loop for the required number of times.
                    for (Map.Entry<Integer, HashSet<String>> entry
                            : registrations.entrySet()) {
                        // Calculate and store the course count.
                        int courseCount = entry.getValue().size();
                        // Update the total registrations calculation.
                        totalRegistrations += courseCount;

                        // Check whether this condition is true.
                        if (courseCount > highestCourses) {
                            // Set the highest courses value.
                            highestCourses = courseCount;
                            // Set the highest student id value.
                            highestStudentId = entry.getKey();
                        }

                        // Check whether this condition is true.
                        if (courseCount < lowestCourses) {
                            // Set the lowest courses value.
                            lowestCourses = courseCount;
                            // Set the lowest student id value.
                            lowestStudentId = entry.getKey();
                        }
                    }

                    // Store the average courses.
                    double averageCourses = registrations.isEmpty()
                            ? 0
                            : (double) totalRegistrations / registrations.size();

                    // Display information to the user.
                    System.out.println("\nTotal number of students: "
                            + registrations.size());
                    // Display information to the user.
                    System.out.println("Total course registrations: "
                            + totalRegistrations);

                    // Check whether this condition is true.
                    if (!registrations.isEmpty()) {
                        // Display information to the user.
                        System.out.println("Student with highest courses: "
                                + highestStudentId
                                + " (" + highestCourses + " courses)");

                        // Display information to the user.
                        System.out.println("Student with lowest courses: "
                                + lowestStudentId
                                + " (" + lowestCourses + " courses)");
                    }

                    // Display information to the user.
                    System.out.printf(
                            "Average courses per student: %.2f%n",
                            // Run this step.
                            averageCourses
                    );
                    // Leave this menu choice.
                    break;

                // Handle this menu choice.
                case 6:
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
        } while (choice != 6);

        // Close the Scanner.
        scanner.close();
    }
}