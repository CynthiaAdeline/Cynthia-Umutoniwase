package MissionManagementSystem;

public class Resource {
    private String resourceId;
    private String resourceName;
    private int quantity;
    private String resourceType;

    public Resource(String id, String name, int qty, String type) {
        this.resourceId = id;
        this.resourceName = name;
        this.quantity = qty;
        this.resourceType = type;
    }

    public String getResourceName() {
        return resourceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void reduceQuantity(int used) {
        this.quantity -= used;
    }

    public String toString() {
        return resourceName + " (" + resourceType + ") - " + quantity + " available";
    }
}