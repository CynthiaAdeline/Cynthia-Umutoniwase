package LandManagementSystem;

import java.time.LocalDate;

public abstract class Land {
    protected String landId;
    protected String ownerName;
    protected String location;
    protected double sizeInAcres;
    protected LocalDate registrationDate;
    protected String landUseStatus;

    public Land(String landId, String ownerName, String location,
                double sizeInAcres, LocalDate registrationDate, String landUseStatus) {
        this.landId = landId;
        this.ownerName = ownerName;
        this.location = location;
        this.sizeInAcres = sizeInAcres;
        this.registrationDate = registrationDate;
        this.landUseStatus = landUseStatus;
    }

    public abstract boolean validateOwnership();
    public abstract boolean checkZoningCompliance();
    public abstract double calculateTax();
    public abstract String generateLandReport();
}
