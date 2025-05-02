package NurseryManagementSystem;

public class BabyClass extends NurseryClass {
    public BabyClass(String classId) {
        super(classId, "Baby Class", 15);
    }

    public void enrollStudent(Student student) throws Exception {
        if (student.age < 2 || student.age > 3) {
            throw new Exception("Baby Class accepts ages 2 to 3 only.");
        }
        if (students.size() >= maxCapacity) {
            throw new Exception("Class is full.");
        }
        if (student.registeredClass != null) {
            throw new Exception("Student already registered in a class.");
        }
        students.add(student);
        student.registeredClass = this;
    }

    public void conductActivity(String activityName) {
        activities.add(activityName);
        System.out.println("Conducted in Baby Class: " + activityName);
    }

    public void trackProgress() {
        System.out.println("Tracking motor skills and play-based learning for Baby Class.");
    }

    public void generateClassReport() {
        System.out.println("--- Baby Class Report ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Students Enrolled: " + students.size());
        System.out.println("Activities: " + String.join(", ", activities));
        trackProgress();
    }
}
