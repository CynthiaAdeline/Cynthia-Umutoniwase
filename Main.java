package LandManagementSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Validate Land ID (digits only)
        String landId;
        while (true) {
            System.out.print("Enter Land ID : ");
            landId = scanner.nextLine();
            if (landId.matches("\\d+")) break;
            System.out.println("Invalid Land ID. It must contain only digits.");
        }

        // Validate Owner Name (letters only)
        String ownerName;
        while (true) {
            System.out.print("Enter Owner Name : ");
            ownerName = scanner.nextLine();
            if (ownerName.matches("[A-Za-z ]+")) break;
            System.out.println("Invalid Owner Name. It must contain only letters.");
        }

        // Validate Location (no digits)
        String location;
        while (true) {
            System.out.print("Enter Location : ");
            location = scanner.nextLine();
            if (!location.matches(".*\\d.*")) break;
            System.out.println("Invalid Location. It must not contain digits.");
        }

        // Validate Size in Acres (positive number)
        double sizeInAcres;
        while (true) {
            System.out.print("Enter Size in Acres : ");
            String input = scanner.nextLine();
            try {
                sizeInAcres = Double.parseDouble(input);
                if (sizeInAcres <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive number for size.");
            }
        }

        // Validate Land Type (must match one of the subclasses)
        String landType;
        while (true) {
            System.out.print("Enter Land Type (Agricultural, Residential, Commercial, Industrial): ");
            landType = scanner.nextLine();
            if (landType.matches("(?i)Agricultural|Residential|Commercial|Industrial")) break;
            System.out.println("Invalid land type. Please enter one of the specified types.");
        }

        // Determine which subclass to instantiate
        Land land = null;
        LocalDate today = LocalDate.now();
        String typeLower = landType.toLowerCase();

        switch (typeLower) {
            case "agricultural":
                land = new AgriculturalLand(landId, ownerName, location, sizeInAcres, today);
                break;
            case "residential":
                // For residential, ask number of units
                int units = 0;
                while (true) {
                    System.out.print("Enter number of units on the land (up to 2 per acre): ");
                    String in = scanner.nextLine();
                    try {
                        units = Integer.parseInt(in);
                        if (units < 0) throw new NumberFormatException();
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number of units. It must be a non-negative integer.");
                    }
                }
                land = new ResidentialLand(landId, ownerName, location, sizeInAcres, today, units);
                break;
            case "commercial":
                // For commercial, ask if in commercial zone
                boolean inZone = false;
                while (true) {
                    System.out.print("Is the land in a commercial zone? (yes/no): ");
                    String in = scanner.nextLine();
                    if (in.equalsIgnoreCase("yes")) {
                        inZone = true;
                        break;
                    }
                    if (in.equalsIgnoreCase("no")) {
                        inZone = false;
                        break;
                    }
                    System.out.println("Invalid input. Please enter yes or no.");
                }
                land = new CommercialLand(landId, ownerName, location, sizeInAcres, today, inZone);
                break;
            case "industrial":
                // For industrial, ask for environmental clearance
                boolean clearance = false;
                while (true) {
                    System.out.print("Has environmental clearance been obtained? (yes/no): ");
                    String in = scanner.nextLine();
                    if (in.equalsIgnoreCase("yes")) {
                        clearance = true;
                        break;
                    }
                    if (in.equalsIgnoreCase("no")) {
                        clearance = false;
                        break;
                    }
                    System.out.println("Invalid input. Please enter yes or no.");
                }
                land = new IndustrialLand(landId, ownerName, location, sizeInAcres, today, clearance);
                break;
        }
    }
}
