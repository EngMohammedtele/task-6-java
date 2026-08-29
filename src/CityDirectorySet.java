import java.util.Scanner;
import java.util.TreeSet;

// This class runs the city directory set program.
public class CityDirectorySet {
    // Run the program.
    public static void main(String[] args) {
        // Create a Scanner to read user input.
        Scanner scanner = new Scanner(System.in);
        // Keeps city names unique and sorted alphabetically
        TreeSet<String> cities = new TreeSet<>();

        // Read the number of cities
        System.out.print("Enter the number of cities: ");
        // Read the number of cities from the user.
        int numberOfCities = scanner.nextInt();
        // Clear the remaining new line from the input.
        scanner.nextLine();

        // Check whether this condition is true.
        if (numberOfCities <= 0) {
            // Display information to the user.
            System.out.println("Invalid number of cities.");
            // Close the Scanner.
            scanner.close();
            // Stop the program.
            return;
        }

        // Read and store city names
        for (int i = 1; i <= numberOfCities; i++) {
            // Display information to the user.
            System.out.print("Enter city " + i + ": ");
            // Read the city name from the user.
            String cityName = scanner.nextLine();

            // Check whether this condition is true.
            if (!cities.add(cityName)) {
                // Display information to the user.
                System.out.println(
                        "City already exists. Duplicate entries are not allowed."
                );
            }
        }

        // Search for a city
        System.out.print("\nEnter a city name to search for: ");
        // Read the search city from the user.
        String searchCity = scanner.nextLine();

        // Store the search result.
        String searchResult;

        // Check whether this condition is true.
        if (cities.contains(searchCity)) {
            // Set the search result value.
            searchResult = "City found in the directory.";
        // Handle the other case.
        } else {
            // Set the search result value.
            searchResult = "City not found in the directory.";
        }

        // Classify the directory
        String classification;

        // Check whether this condition is true.
        if (cities.size() < 5) {
            // Set the classification value.
            classification = "Small Directory";
        // Check the next condition.
        } else if (cities.size() <= 10) {
            // Set the classification value.
            classification = "Medium Directory";
        // Handle the other case.
        } else {
            // Set the classification value.
            classification = "Large Directory";
        }

        // Display results
        System.out.println("\nTotal cities entered: " + numberOfCities);
        // Display information to the user.
        System.out.println("Total unique cities: " + cities.size());
        // Display information to the user.
        System.out.println("All cities in alphabetical order: " + cities);
        // Display information to the user.
        System.out.println("Search result: " + searchResult);
        // Display information to the user.
        System.out.println("Directory classification: " + classification);

        // Close the Scanner.
        scanner.close();
    }
}