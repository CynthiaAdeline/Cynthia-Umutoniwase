package MissionManagementSystem;

import java.util.*;

public class ReconMission extends Mission {

    public ReconMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        System.out.println("Recon tasks assigned: Surveillance, Intel gathering.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        for (Resource r : availableResources) {
            if (r.getResourceName().equalsIgnoreCase("Drone") && r.getQuantity() >= 1) {
                addResource(r);
                r.reduceQuantity(1);
                break;
            }
        }
    }

    @Override
    public void trackMissionProgress() {
        this.status = "IN_PROGRESS";
    }

    @Override
    public void generateMissionReport() {
        System.out.println("=== Recon Mission Report ===");
        System.out.println("Mission: " + missionName + " [" + status + "]");
        System.out.println("Personnel: " + assignedPersonnel);
        System.out.println("Resources: " + allocatedResources);
    }
}
