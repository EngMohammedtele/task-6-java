import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

// This class runs the library book tracker program.
public class LibraryBookTracker {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Create a HashSet to store unique book ids.
        HashSet<Integer> bookIds = new HashSet<>();
        // Create a HashMap to store books as key and value pairs.
        HashMap<Integer, String> books = new HashMap<>();

        // Read the number of books
        System.out.print("Enter the number of books: ");
        // Read the number of books from the user.
        int numberOfBooks = scanner.nextInt();
        // Clear the remaining new line from the input.
        scanner.nextLine();

        // Check whether this condition is true.
        if (numberOfBooks <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of books.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read and store book records
        for (int i = 1; i <= numberOfBooks; i++) {
            // Display information to the user.
            System.out.print("Enter book ID: ");
            // Read the book id from the user.
            int bookId = scanner.nextInt();
            // Clear the remaining new line from the input.
            scanner.nextLine();

            // Display information to the user.
            System.out.print("Enter book title: ");
            // Read the book title from the user.
            String bookTitle = scanner.nextLine();

            // Check whether this condition is true.
            if (bookIds.contains(bookId)) {
                // Display information to the user.
                System.out.println("Duplicate Book ID. Record not added.");
            // Handle the other case.
            } else {
                // Add an item to the book ids.
                bookIds.add(bookId);
                // Add a key and value to the books.
                books.put(bookId, bookTitle);
            }
        }

        // Search for a book
        System.out.print("\nEnter a book ID to search for: ");
        // Read the search id from the user.
        int searchId = scanner.nextInt();

        // Check whether this condition is true.
        if (books.containsKey(searchId)) {
            // Display information to the user.
            System.out.println("Book ID: " + searchId);
            // Display information to the user.
            System.out.println("Book title: " + books.get(searchId));
        // Handle the other case.
        } else {
            // Display information to the user.
            System.out.println("Book not found.");
        }

        // Classify the library
        String classification;

        // Check whether this condition is true.
        if (bookIds.size() < 5) {
            // Set the classification value.
            classification = "Small Library";
        // Check the next condition.
        } else if (bookIds.size() <= 10) {
            // Set the classification value.
            classification = "Medium Library";
        // Handle the other case.
        } else {
            // Set the classification value.
            classification = "Large Library";
        }

        // Display results
        System.out.println("\nTotal book records entered: " + numberOfBooks);
        // Display information to the user.
        System.out.println("Total unique books: " + bookIds.size());
        // Display information to the user.
        System.out.println("All book IDs: " + bookIds);
        // Display information to the user.
        System.out.println("All book IDs with titles:");

        // Go through each item in the collection.
        for (Map.Entry<Integer, String> entry : books.entrySet()) {
            // Display information to the user.
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display information to the user.
        System.out.println("Library classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}