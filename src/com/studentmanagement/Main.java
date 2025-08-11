package com.studentmanagement;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.util.FileOperations;
import com.studentmanagement.util.InputHelper;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        FileOperations.loadData(studentList);
        StudentService service = new StudentService(studentList);

        while(true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            int option = InputHelper.readInt("Enter option: ");
            InputHelper.scanner.nextLine();

            switch(option) {
                case 1 -> {
                    String name = InputHelper.readLine("Enter name: ");
                    int roll = InputHelper.readInt("Enter roll number: ");
                    int phy = InputHelper.readMark("Physics");
                    int chem = InputHelper.readMark("Chemistry");
                    int math = InputHelper.readMark("Mathematics");

                    if(service.addStudent(new Student(name, roll, phy, chem, math))) {
                        System.out.println("Student added.");
                        FileOperations.saveData(studentList);
                    } else {
                        System.out.println("Roll number already exists.");
                    }
                }
                case 2 -> {
                    System.out.printf("%-20s %-12s %-8s %-6s %-8s%n", "Name", "Roll No", "Total", "Grade", "Status");
                    for(Student s : service.getAll()) {
                        System.out.printf("%-20s %-12d %-8d %-6s %-8s%n", 
                            s.getName(), s.getRollNumber(), s.getTotalMark(), s.getTotalGrade(), s.getStatus());
                    }
                }
                case 3 -> {
                    String search = InputHelper.readLine("Enter full name to search: ");
                    Student s = service.findByName(search);
                    if(s != null) {
                        displayStudentDetails(s);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> {
                    int roll = InputHelper.readInt("Enter roll to delete: ");
                    if(service.deleteStudent(roll)) {
                        System.out.println("Deleted.");
                        FileOperations.saveData(studentList);
                    } else {
                        System.out.println("Not found.");
                    }
                }
                case 5 -> {
                    int roll = InputHelper.readInt("Enter roll to update: ");
                    Student s = service.findByRoll(roll);
                    if(s != null) {
                        int phy = InputHelper.readMark("Physics");
                        int chem = InputHelper.readMark("Chemistry");
                        int math = InputHelper.readMark("Mathematics");
                        s.setMarks(phy, chem, math);
                        FileOperations.saveData(studentList);
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Not found.");
                    }
                }
                case 6 -> {
                    FileOperations.saveData(studentList);
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void displayStudentDetails(Student s) {
        System.out.println("Name: " + s.getName());
        System.out.println("Roll: " + s.getRollNumber());
        System.out.println("Physics: " + s.getPhyMark() + " (" + s.getPhyGrade() + ")");
        System.out.println("Chemistry: " + s.getChemMark() + " (" + s.getChemGrade() + ")");
        System.out.println("Mathematics: " + s.getMathMark() + " (" + s.getMathGrade() + ")");
        System.out.println("Total: " + s.getTotalMark() + " (" + s.getTotalGrade() + ")");
        System.out.println("Status: " + s.getStatus());
    }
}
