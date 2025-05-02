package NurseryManagementSystem;

class MiddleClass extends NurseryClass {
    public MiddleClass(String classId) {
        super(classId, "Middle Class", 20);
    }

    public void enrollStudent(Student student) throws Exception {
        if (student.age < 3 || student.age > 4) {
            throw new Exception("Middle Class accepts ages 3 to 4 only.");
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
        System.out.println("Conducted in Middle Class: " + activityName);
    }

    public void trackProgress() {
        System.out.println("Tracking language and basic counting development in Middle Class.");
    }

    public void generateClassReport() {
        System.out.println("--- Middle Class Report ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Students Enrolled: " + students.size());
        System.out.println("Activities: " + String.join(", ", activities));
        trackProgress();
    }
}
