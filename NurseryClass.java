package NurseryManagementSystem;

import java.util.*;

abstract class NurseryClass {
    protected String classId;
    protected String className;
    protected int maxCapacity;
    protected Teacher assignedTeacher;
    protected List<Student> students = new ArrayList<>();
    protected List<String> activities = new ArrayList<>();

    public NurseryClass(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public abstract void enrollStudent(Student student) throws Exception;
    public abstract void conductActivity(String activityName);
    public abstract void trackProgress();
    public abstract void generateClassReport();

    public void assignTeacher(Teacher teacher) throws Exception {
        if (this instanceof BabyClass && !"Early Childhood Educator".equals(teacher.teacherRole)) {
            throw new Exception("Only Early Childhood Educators can be assigned to Baby Class.");
        }
        this.assignedTeacher = teacher;
        teacher.assignedClass = this;
    }
}
