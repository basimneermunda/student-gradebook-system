package com.studentmanagement.util;

import com.studentmanagement.model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {
    private static final String FILE_NAME = "student_data.txt";

    public static void loadData(ArrayList<Student> list) {
        File file = new File(FILE_NAME);
        if(!file.exists()) return;

        try(Scanner reader = new Scanner(file)) {
            while(reader.hasNextLine()) {
                String name = reader.nextLine();
                int roll = Integer.parseInt(reader.nextLine());
                int phy = Integer.parseInt(reader.nextLine());
                int chem = Integer.parseInt(reader.nextLine());
                int math = Integer.parseInt(reader.nextLine());
                list.add(new Student(name, roll, phy, chem, math));
            }
        } catch(IOException e) {
            System.out.println("Error loading file.");
        }
    }

    public static void saveData(ArrayList<Student> list) {
        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            for(Student s : list) {
                writer.write(s.getName()+"\n");
                writer.write(s.getRollNumber()+"\n");
                writer.write(s.getPhyMark()+"\n");
                writer.write(s.getChemMark()+"\n");
                writer.write(s.getMathMark()+"\n");
            }
        } catch(IOException e) {
            System.out.println("Error saving file.");
        }
    }
}
