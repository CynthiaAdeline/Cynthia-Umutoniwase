package MissionManagementSystem;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter Mission ID : ");
        String missionId = scanner.nextLine();
        while (!missionId.matches("\\d+")) {
            System.out.print("Invalid! Enter numeric Mission ID: ");
            missionId = scanner.nextLine();
        }

        System.out.print("Enter Mission Name : ");
        String missionName = scanner.nextLine();
        while (!missionName.matches("[a-zA-Z ]+")) {
            System.out.print("Invalid! Enter alphabetic Mission Name: ");
            missionName = scanner.nextLine();
        }

        System.out.print("Enter Start Date (yyyy-MM-dd): ");
        Date startDate = df.parse(scanner.nextLine());

        System.out.print("Enter End Date (yyyy-MM-dd): ");
        Date endDate = df.parse(scanner.nextLine());

        System.out.print("Enter Status (PLANNED/IN_PROGRESS/COMPLETED): ");
        String status = scanner.nextLine();

        // Sample personnel and resources
        Personnel p1 = new Personnel("P1", "Alice", "Medic");
        Personnel p2 = new Personnel("P2", "Bob", "Soldier");
        Resource r1 = new Resource("R1", "Drone", 3, "Equipment");

        Mission mission = new RescueMission(missionId, missionName, startDate, endDate, status);
        mission.addPersonnel(p1);
        mission.addPersonnel(p2);

        List<Resource> resources = new ArrayList<>();
        resources.add(r1);

        if (!mission.validateDates()) {
            System.out.println("Error: Start date must be before end date.");
            return;
        }

        mission.assignTask();
        mission.allocateResources(resources);
        mission.trackMissionProgress();
        mission.generateMissionReport();
    }
}

