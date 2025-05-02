package MissionManagementSystem;

public class Personnel {
    private String personnelId;
    private String personnelName;
    private String personnelRole;

    public Personnel(String id, String name, String role) {
        this.personnelId = id;
        this.personnelName = name;
        this.personnelRole = role;
    }

    public String getPersonnelRole() {
        return personnelRole;
    }

    public String toString() {
        return personnelName + " (" + personnelRole + ")";
    }
}
