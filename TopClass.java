package NurseryManagementSystem;

class TopClass extends NurseryClass {
    public TopClass(String classId) {
        super(classId, "Top Class", 25);
    }

    public void enrollStudent(Student student) throws Exception {
        if (student.age < 4 || student.age > 5) {
            throw new Exception("Top Class accepts ages 4 to 5 only.");
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
        System.out.println("Conducted in Top Class: " + activityName);
    }

    public void trackProgress() {
        System.out.println("Tracking reading, writing, arithmetic and term assessments in Top Class.");
    }

    public void generateClassReport() {
        System.out.println("--- Top Class Report ---");
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Students Enrolled: " + students.size());
        System.out.println("Activities: " + String.join(", ", activities));
        trackProgress();
    }
}
