import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductPriceCatalog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> products = new HashMap<>();

        // Read the number of products
        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine();

        if (numberOfProducts <= 0) {
            System.out.println("Invalid number of products.");
            scanner.close();
            return;
        }

        // Read and store products
        for (int i = 1; i <= numberOfProducts; i++) {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            if (products.containsKey(productName)) {
                System.out.println("Product already exists. Record not added.");
            } else {
                products.put(productName, price);
            }
        }

        // Search and update a product
        System.out.print("\nEnter a product name to search for: ");
        String searchProduct = scanner.nextLine();

        if (products.containsKey(searchProduct)) {
            System.out.println("Current price: " + products.get(searchProduct));

            System.out.print("Do you want to update the price? (Y/N): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.print("Enter the new price: ");
                double newPrice = scanner.nextDouble();

                products.replace(searchProduct, newPrice);
                System.out.println("Price updated successfully.");
            }
        } else {
            System.out.println("Product not found.");
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
        System.out.println("All product names and prices:");

        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Inventory classification: " + classification);

        scanner.close();
    }
}
