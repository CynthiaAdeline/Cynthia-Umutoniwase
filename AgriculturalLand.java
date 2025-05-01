package LandManagementSystem;

import java.time.LocalDate;

public class AgriculturalLand extends Land {
    public AgriculturalLand(String landId, String ownerName, String location,
                            double sizeInAcres, LocalDate registrationDate) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, "Farming");
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && ownerName.matches("[A-Za-z ]+");
    }

    @Override
    public boolean checkZoningCompliance() {
        return (sizeInAcres >= 1) &&
                (landUseStatus.equalsIgnoreCase("Farming") || landUseStatus.equalsIgnoreCase("Agriculture"));
    }

    @Override
    public double calculateTax() {
        return 0.01 * 5000 * sizeInAcres;
    }

    @Override
    public String generateLandReport() {
        return "Land Report:\n" +
                "ID: " + landId + "\n" +
                "Owner: " + ownerName + "\n" +
                "Location: " + location + "\n" +
                "Size (acres): " + sizeInAcres + "\n" +
                "Land Type: Agricultural\n" +
                "Land Use Status: " + landUseStatus + "\n" +
                "Ownership Valid: " + (validateOwnership()? "Yes" : "No") + "\n" +
                "Zoning Compliance: " + (checkZoningCompliance()? "Yes" : "No") + "\n" +
                "Calculated Tax: $" + calculateTax() + "\n";
    }
}
