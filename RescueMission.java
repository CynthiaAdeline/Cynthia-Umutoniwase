package MissionManagementSystem;

import java.util.*;

public class RescueMission extends Mission {

    public RescueMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        System.out.println("Rescue tasks assigned: Medical aid, Logistics, Evacuation.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        for (Resource r : availableResources) {
            if (r.getResourceName().equalsIgnoreCase("Ambulance") && r.getQuantity() >= 1) {
                addResource(r);
                r.reduceQuantity(1);
            }
        }
    }

    @Override
    public void trackMissionProgress() {
        this.status = "COMPLETED";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("=== Rescue Mission Report ===");
        System.out.println("Mission: " + missionName + " [" + status + "]");
        System.out.println("Personnel: " + assignedPersonnel);
        System.out.println("Resources: " + allocatedResources);
    }
}
