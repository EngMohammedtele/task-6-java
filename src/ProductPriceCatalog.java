import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This class runs the product price catalog program.
public class ProductPriceCatalog {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Map each product name to its price.
        HashMap<String, Double> products = new HashMap<>();

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

        // Read and store products
        for (int i = 1; i <= numberOfProducts; i++) {
            // Display information to the user.
            System.out.print("Enter product name: ");
            // Read the product name from the user.
            String productName = scanner.nextLine();

            // Display information to the user.
            System.out.print("Enter product price: ");
            // Read the price from the user.
            double price = scanner.nextDouble();
            // Clear the remaining new line from the input.
            scanner.nextLine();

            // Check whether this condition is true.
            if (price < 0) {
                System.out.println("Price cannot be negative. Record not added.");
            } else if (products.containsKey(productName)) {
                // Display information to the user.
                System.out.println("Product already exists. Record not added.");
            // Handle the other case.
            } else {
                // Add a key and value to the products.
                products.put(productName, price);
            }
        }

        // Search and update a product
        System.out.print("\nEnter a product name to search for: ");
        // Read the search product from the user.
        String searchProduct = scanner.nextLine();

        // Check whether this condition is true.
        if (products.containsKey(searchProduct)) {
            // Display information to the user.
            System.out.println("Current price: " + products.get(searchProduct));

            // Display information to the user.
            System.out.print("Do you want to update the price? (Y/N): ");
            // Read the answer from the user.
            String answer = scanner.nextLine();

            // Check whether this condition is true.
            if (answer.equalsIgnoreCase("Y")) {
                // Display information to the user.
                System.out.print("Enter the new price: ");
                // Read the new price from the user.
                double newPrice = scanner.nextDouble();

                if (newPrice < 0) {
                    System.out.println("Price cannot be negative. Price not updated.");
                } else {
                    // Replace a value in the products.
                    products.replace(searchProduct, newPrice);
                    // Display information to the user.
                    System.out.println("Price updated successfully.");
                }
            }
        // Handle the other case.
        } else {
            // Display information to the user.
            System.out.println("Product not found.");
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
        System.out.println("All product names and prices:");

        // Go through each item in the collection.
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            // Display information to the user.
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display information to the user.
        System.out.println("Inventory classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}
