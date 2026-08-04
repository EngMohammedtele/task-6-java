import java.util.HashSet;
import java.util.Scanner;

public class ProductInventorySet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> products = new HashSet<>();

        // Read the number of products
        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine();

        if (numberOfProducts <= 0) {
            System.out.println("Invalid number of products.");
            scanner.close();
            return;
        }

        // Read and store product names
        for (int i = 1; i <= numberOfProducts; i++) {
            System.out.print("Enter product " + i + ": ");
            String productName = scanner.nextLine();

            if (!products.add(productName)) {
                System.out.println(
                        "Product already exists. Duplicate entries are not allowed."
                );
            }
        }

        // Search for a product
        System.out.print("\nEnter a product name to search for: ");
        String searchProduct = scanner.nextLine();

        String searchResult;

        if (products.contains(searchProduct)) {
            searchResult = "Product found in inventory.";
        } else {
            searchResult = "Product not found in inventory.";
        }

        // Classify the inventory
        String classification;

        if (products.size() < 5) {
            classification = "Small Inventory";
        } else if (products.size() <= 10) {
            classification = "Medium Inventory";
        } else {
            classification = "Large Inventory";
        }

        // Display results
        System.out.println("\nTotal products entered: " + numberOfProducts);
        System.out.println("Total unique products: " + products.size());
        System.out.println("All products in inventory: " + products);
        System.out.println("Search result: " + searchResult);
        System.out.println("Inventory classification: " + classification);

        scanner.close();
    }
}