package LandManagementSystem;

import java.time.LocalDate;

public class CommercialLand extends Land {
    private boolean inCommercialZone;

    public CommercialLand(String landId, String ownerName, String location,
                          double sizeInAcres, LocalDate registrationDate,
                          boolean inCommercialZone) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, "Commercial");
        this.inCommercialZone = inCommercialZone;
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && ownerName.matches("[A-Za-z ]+");
    }

    @Override
    public boolean checkZoningCompliance() {
        return inCommercialZone;
    }

    @Override
    public double calculateTax() {
        return 0.025 * 10000 * sizeInAcres;
    }

    @Override
    public String generateLandReport() {
        return "Land Report:\n" +
                "ID: " + landId + "\n" +
                "Owner: " + ownerName + "\n" +
                "Location: " + location + "\n" +
                "Size (acres): " + sizeInAcres + "\n" +
                "Land Type: Commercial\n" +
                "Land Use Status: " + landUseStatus + "\n" +
                "Commercial Zone: " + (inCommercialZone ? "Yes" : "No") + "\n" +
                "Ownership Valid: " + (validateOwnership()? "Yes" : "No") + "\n" +
                "Zoning Compliance: " + (checkZoningCompliance()? "Yes" : "No") + "\n" +
                "Calculated Tax: $" + calculateTax() + "\n";
    }
}
