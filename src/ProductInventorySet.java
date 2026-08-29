import java.util.HashSet;
import java.util.Scanner;

// This class runs the product inventory set program.
public class ProductInventorySet {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Store each product once in a HashSet.
        HashSet<String> products = new HashSet<>();

        // Read the number of products
        System.out.print("Enter the number of products: ");
        // Read the number of products from the user.
        int numberOfProducts = scanner.nextInt();
        // Clear the remaining new line from the input.
        scanner.nextLine();

        // Check whether this condition is true.
        if (numberOfProducts <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of products.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read and store product names
        for (int i = 1; i <= numberOfProducts; i++) {
            // Display information to the user.
            System.out.print("Enter product " + i + ": ");
            // Read the product name from the user.
            String productName = scanner.nextLine();

            // Check whether this condition is true.
            if (!products.add(productName)) {
                // Display information to the user.
                System.out.println(
                        "Product already exists. Duplicate entries are not allowed."
                );
            }
        }

        // Search for a product
        System.out.print("\nEnter a product name to search for: ");
        // Read the search product from the user.
        String searchProduct = scanner.nextLine();

        // Store the search result.
        String searchResult;

        // Check whether this condition is true.
        if (products.contains(searchProduct)) {
            // Set the search result value.
            searchResult = "Product found in inventory.";
        // Handle the other case.
        } else {
            // Set the search result value.
            searchResult = "Product not found in inventory.";
        }

        // Classify the inventory
        String classification;

        // Check whether this condition is true.
        if (products.size() < 5) {
            // Set the classification value.
            classification = "Small Inventory";
        // Check the next condition.
        } else if (products.size() <= 10) {
            // Set the classification value.
            classification = "Medium Inventory";
        // Handle the other case.
        } else {
            // Set the classification value.
            classification = "Large Inventory";
        }

        // Display results
        System.out.println("\nTotal products entered: " + numberOfProducts);
        // Display information to the user.
        System.out.println("Total unique products: " + products.size());
        // Display information to the user.
        System.out.println("All products in inventory: " + products);
        // Display information to the user.
        System.out.println("Search result: " + searchResult);
        // Display information to the user.
        System.out.println("Inventory classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}