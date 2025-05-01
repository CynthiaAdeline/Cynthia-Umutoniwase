package LandManagementSystem;

import java.time.LocalDate;

public class ResidentialLand extends Land {
    private int numberOfUnits;

    public ResidentialLand(String landId, String ownerName, String location,
                           double sizeInAcres, LocalDate registrationDate,
                           int numberOfUnits) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, "Residential");
        this.numberOfUnits = numberOfUnits;
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && ownerName.matches("[A-Za-z ]+");
    }

    @Override
    public boolean checkZoningCompliance() {
        return numberOfUnits <= (2 * sizeInAcres);
    }

    @Override
    public double calculateTax() {
        return 0.015 * 8000 * sizeInAcres;
    }

    @Override
    public String generateLandReport() {
        return "Land Report:\n" +
                "ID: " + landId + "\n" +
                "Owner: " + ownerName + "\n" +
                "Location: " + location + "\n" +
                "Size (acres): " + sizeInAcres + "\n" +
                "Land Type: Residential\n" +
                "Land Use Status: " + landUseStatus + "\n" +
                "Units: " + numberOfUnits + "\n" +
                "Ownership Valid: " + (validateOwnership()? "Yes" : "No") + "\n" +
                "Zoning Compliance: " + (checkZoningCompliance()? "Yes" : "No") + "\n" +
                "Calculated Tax: $" + calculateTax() + "\n";
    }
}
