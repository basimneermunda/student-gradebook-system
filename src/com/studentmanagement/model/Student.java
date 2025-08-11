package com.studentmanagement.model;

public class Student {
    private String name;
    private int rollNumber;
    private int phyMark, chemMark, mathMark;
    private int totalMark;
    private String phyGrade, chemGrade, mathGrade, totalGrade, status;

    public Student(String name, int rollNumber, int phyMark, int chemMark, int mathMark) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.phyMark = phyMark;
        this.chemMark = chemMark;
        this.mathMark = mathMark;
        calculateGrade();
    }

    public void calculateGrade() {
        phyGrade = gradeFromMark(phyMark);
        chemGrade = gradeFromMark(chemMark);
        mathGrade = gradeFromMark(mathMark);

        totalMark = phyMark + chemMark + mathMark;
        totalGrade = gradeFromTotal(totalMark);
        status = totalGrade.equals("F") ? "Failed" : "Passed";
    }

    private String gradeFromMark(int mark) {
        if(mark >= 90) return "A+";
        if(mark >= 80) return "A";
        if(mark >= 70) return "B+";
        if(mark >= 60) return "B";
        if(mark >= 50) return "C+";
        if(mark >= 40) return "C";
        if(mark >= 30) return "D+";
        if(mark >= 20) return "P";
        return "F";
    }

    private String gradeFromTotal(int mark) {
        if(mark >= 270) return "A+";
        if(mark >= 240) return "A";
        if(mark >= 210) return "B+";
        if(mark >= 180) return "B";
        if(mark >= 150) return "C+";
        if(mark >= 120) return "C";
        if(mark >= 90)  return "D+";
        if(mark >= 60)  return "P";
        return "F";
    }

    // Getters
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public int getTotalMark() { return totalMark; }
    public String getTotalGrade() { return totalGrade; }
    public String getStatus() { return status; }
    public int getPhyMark() { return phyMark; }
    public int getChemMark() { return chemMark; }
    public int getMathMark() { return mathMark; }
    public String getPhyGrade() { return phyGrade; }
    public String getChemGrade() { return chemGrade; }
    public String getMathGrade() { return mathGrade; }

    // Setters
    public void setMarks(int phyMark, int chemMark, int mathMark) {
        this.phyMark = phyMark;
        this.chemMark = chemMark;
        this.mathMark = mathMark;
        calculateGrade();
    }
}
