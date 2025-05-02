package NurseryManagementSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize classes
        BabyClass babyClass = new BabyClass("B01");
        MiddleClass middleClass = new MiddleClass("M01");
        TopClass topClass = new TopClass("T01");

        System.out.println("===== Nursery School Management System =====");

        try {
            // Input Teacher
            String teacherId;
            do {
                System.out.print("Enter Teacher ID : ");
                teacherId = scanner.nextLine();
            } while (!teacherId.matches("[A-Za-z0-9]+"));

            String teacherName;
            do {
                System.out.print("Enter Teacher Name : ");
                teacherName = scanner.nextLine();
            } while (!teacherName.matches("[A-Za-z ]+"));

            String teacherRole;
            do {
                System.out.print("Enter Teacher Role : ");
                teacherRole = scanner.nextLine();
            } while (!teacherRole.matches("[A-Za-z ]+"));

            Teacher teacher = new Teacher(teacherId, teacherName, teacherRole);

            // Assign Teacher to Class
            System.out.println("Assign teacher to class: (1) Baby (2) Middle (3) Top");
            String classChoice = scanner.nextLine();

            switch (classChoice) {
                case "1":
                    babyClass.assignTeacher(teacher);
                    break;
                case "2":
                    middleClass.assignTeacher(teacher);
                    break;
                case "3":
                    topClass.assignTeacher(teacher);
                    break;
                default:
                    System.out.println("Invalid class choice.");
                    return;
            }

            System.out.println("Teacher assigned successfully!");

            // Input Student
            String studentId;
            do {
                System.out.print("Enter Student ID : ");
                studentId = scanner.nextLine();
            } while (!studentId.matches("[A-Za-z0-9]+"));

            String studentName;
            do {
                System.out.print("Enter Student Name : ");
                studentName = scanner.nextLine();
            } while (!studentName.matches("[A-Za-z ]+"));

            int age;
            while (true) {
                System.out.print("Enter Student Age (2 to 5: ");
                String ageInput = scanner.nextLine();
                if (ageInput.matches("[0-9]+")) {
                    age = Integer.parseInt(ageInput);
                    if (age >= 2 && age <= 5) break;
                }
                System.out.println("Invalid age. Must be a number between 2 and 5.");
            }

            String guardianName;
            do {
                System.out.print("Enter Guardian Name : ");
                guardianName = scanner.nextLine();
            } while (!guardianName.matches("[A-Za-z ]+"));

            Student student = new Student(studentId, studentName, age, guardianName);

            // Enroll Student in Correct Class Based on Age
            if (age >= 2 && age <= 3) {
                babyClass.enrollStudent(student);
                System.out.println("Student enrolled in Baby Class.");
            } else if (age == 4) {
                middleClass.enrollStudent(student);
                System.out.println("Student enrolled in Middle Class.");
            } else {
                topClass.enrollStudent(student);
                System.out.println("Student enrolled in Top Class.");
            }

            // Conduct an Activity
            System.out.print("Enter an activity to conduct: ");
            String activity = scanner.nextLine();

            if (student.registeredClass instanceof BabyClass) {
                babyClass.conductActivity(activity);
                babyClass.generateClassReport();
            } else if (student.registeredClass instanceof MiddleClass) {
                middleClass.conductActivity(activity);
                middleClass.generateClassReport();
            } else if (student.registeredClass instanceof TopClass) {
                topClass.conductActivity(activity);
                topClass.generateClassReport();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



