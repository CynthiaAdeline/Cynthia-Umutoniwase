package LandManagementSystem;

import java.time.LocalDate;

public class IndustrialLand extends Land {
    private boolean environmentalClearance;

    public IndustrialLand(String landId, String ownerName, String location,
                          double sizeInAcres, LocalDate registrationDate,
                          boolean environmentalClearance) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, "Industrial");
        this.environmentalClearance = environmentalClearance;
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && ownerName.matches("[A-Za-z ]+");
    }

    @Override
    public boolean checkZoningCompliance() {
        return environmentalClearance;
    }

    @Override
    public double calculateTax() {
        return 0.03 * 12000 * sizeInAcres;
    }

    @Override
    public String generateLandReport() {
        return "Land Report:\n" +
                "ID: " + landId + "\n" +
                "Owner: " + ownerName + "\n" +
                "Location: " + location + "\n" +
                "Size (acres): " + sizeInAcres + "\n" +
                "Land Type: Industrial\n" +
                "Land Use Status: " + landUseStatus + "\n" +
                "Environmental Clearance: " + (environmentalClearance ? "Yes" : "No") + "\n" +
                "Ownership Valid: " + (validateOwnership()? "Yes" : "No") + "\n" +
                "Zoning Compliance: " + (checkZoningCompliance()? "Yes" : "No") + "\n" +
                "Calculated Tax: $" + calculateTax() + "\n";
    }
}
