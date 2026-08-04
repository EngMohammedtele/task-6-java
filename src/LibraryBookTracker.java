import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class LibraryBookTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> bookIds = new HashSet<>();
        HashMap<Integer, String> books = new HashMap<>();

        // Read the number of books
        System.out.print("Enter the number of books: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine();

        if (numberOfBooks <= 0) {
            System.out.println("Invalid number of books.");
            scanner.close();
            return;
        }

        // Read and store book records
        for (int i = 1; i <= numberOfBooks; i++) {
            System.out.print("Enter book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter book title: ");
            String bookTitle = scanner.nextLine();

            if (bookIds.contains(bookId)) {
                System.out.println("Duplicate Book ID. Record not added.");
            } else {
                bookIds.add(bookId);
                books.put(bookId, bookTitle);
            }
        }

        // Search for a book
        System.out.print("\nEnter a book ID to search for: ");
        int searchId = scanner.nextInt();

        if (books.containsKey(searchId)) {
            System.out.println("Book ID: " + searchId);
            System.out.println("Book title: " + books.get(searchId));
        } else {
            System.out.println("Book not found.");
        }

        // Classify the library
        String classification;

        if (bookIds.size() < 5) {
            classification = "Small Library";
        } else if (bookIds.size() <= 10) {
            classification = "Medium Library";
        } else {
            classification = "Large Library";
        }

        // Display results
        System.out.println("\nTotal book records entered: " + numberOfBooks);
        System.out.println("Total unique books: " + bookIds.size());
        System.out.println("All book IDs: " + bookIds);
        System.out.println("All book IDs with titles:");

        for (Map.Entry<Integer, String> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Library classification: " + classification);

        scanner.close();
    }
}