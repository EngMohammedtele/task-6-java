import java.util.Scanner;
import java.util.TreeSet;

public class CityDirectorySet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> cities = new TreeSet<>();

        // Read the number of cities
        System.out.print("Enter the number of cities: ");
        int numberOfCities = scanner.nextInt();
        scanner.nextLine();

        if (numberOfCities <= 0) {
            System.out.println("Invalid number of cities.");
            scanner.close();
            return;
        }

        // Read and store city names
        for (int i = 1; i <= numberOfCities; i++) {
            System.out.print("Enter city " + i + ": ");
            String cityName = scanner.nextLine();

            if (!cities.add(cityName)) {
                System.out.println(
                        "City already exists. Duplicate entries are not allowed."
                );
            }
        }

        // Search for a city
        System.out.print("\nEnter a city name to search for: ");
        String searchCity = scanner.nextLine();

        String searchResult;

        if (cities.contains(searchCity)) {
            searchResult = "City found in the directory.";
        } else {
            searchResult = "City not found in the directory.";
        }

        // Classify the directory
        String classification;

        if (cities.size() < 5) {
            classification = "Small Directory";
        } else if (cities.size() <= 10) {
            classification = "Medium Directory";
        } else {
            classification = "Large Directory";
        }

        // Display results
        System.out.println("\nTotal cities entered: " + numberOfCities);
        System.out.println("Total unique cities: " + cities.size());
        System.out.println("All cities in alphabetical order: " + cities);
        System.out.println("Search result: " + searchResult);
        System.out.println("Directory classification: " + classification);

        scanner.close();
    }
}