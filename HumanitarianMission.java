package MissionManagementSystem;

import java.util.*;

public class HumanitarianMission extends Mission {

    public HumanitarianMission(String id, String name, Date start, Date end, String status) {
        super(id, name, start, end, status);
    }

    @Override
    public void assignTask() {
        System.out.println("Humanitarian tasks: Aid distribution, Logistics.");
    }

    @Override
    public void allocateResources(List<Resource> availableResources) {
        for (Resource r : availableResources) {
            if (r.getResourceType().equalsIgnoreCase("Medical Supplies") && r.getQuantity() >= 3) {
                addResource(r);
                r.reduceQuantity(3);
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
        System.out.println("=== Humanitarian Mission Report ===");
        System.out.println("Mission: " + missionName + " [" + status + "]");
        System.out.println("Personnel: " + assignedPersonnel);
        System.out.println("Resources: " + allocatedResources);
    }
}

