package MissionManagementSystem;

import java.util.*;

public abstract class Mission {
    protected String missionId;
    protected String missionName;
    protected Date missionStartDate;
    protected Date missionEndDate;
    protected String status;
    protected List<Personnel> assignedPersonnel;
    protected List<Resource> allocatedResources;

    public Mission(String missionId, String missionName, Date startDate, Date endDate, String status) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionStartDate = startDate;
        this.missionEndDate = endDate;
        this.status = status;
        this.assignedPersonnel = new ArrayList<>();
        this.allocatedResources = new ArrayList<>();
    }

    public abstract void assignTask();

    public abstract void allocateResources(List<Resource> availableResources);

    public abstract void trackMissionProgress();

    public abstract void generateMissionReport();

    public void addPersonnel(Personnel p) {
        if (!assignedPersonnel.contains(p)) {
            assignedPersonnel.add(p);
        }
    }

    public void addResource(Resource r) {
        allocatedResources.add(r);
    }

    public boolean validateDates() {
        return missionStartDate.before(missionEndDate);
    }
}
