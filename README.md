# Student Gradebook System

A simple Java console-based application to manage student records, calculate grades, and store data.

## Features
- Add new students
- View all students
- Calculate grades based on marks
- Save and load data from `student_data.txt`

## Project Structure
student-gradebook-system/
│
├── src/
│ └── com/
│ └── studentmanagement/
│ ├── Main.java
│ │
│ ├── model/
│ │ └── Student.java
│ │
│ ├── service/
│ │ └── StudentService.java
│ │
│ └── util/
│ ├── FileOperations.java
│ └── InputHelper.java
│
├── student_data.txt
├── .gitignore
└── README.md


## How to Run
1. Navigate to the `src` folder and compile the Java files:
   ```bash
   javac com/studentmanagement/**/*.java
2. Run the application:
   ```bash
   java com.studentmanagement.Main

## Requirements
- Java 8 or higher

## License
This project is open-source. You may use and modify it freely.
