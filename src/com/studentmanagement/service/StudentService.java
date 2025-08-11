package com.studentmanagement.service;

import com.studentmanagement.model.Student;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students;

    public StudentService(ArrayList<Student> students) {
        this.students = students;
    }

    public boolean addStudent(Student s) {
        if(findByRoll(s.getRollNumber()) != null) return false;
        students.add(s);
        return true;
    }

    public Student findByRoll(int roll) {
        for(Student s : students) {
            if(s.getRollNumber() == roll) return s;
        }
        return null;
    }

    public Student findByName(String name) {
        for(Student s : students) {
            if(s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public boolean deleteStudent(int roll) {
        Student s = findByRoll(roll);
        if(s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }

    public ArrayList<Student> getAll() {
        return students;
    }
}
