package com.studentmanagement.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        while(true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static int readMark(String subject) {
        while(true) {
            int mark = readInt(subject + ": ");
            if(mark >= 0 && mark <= 100) {
                return mark;
            }
            System.out.println("Enter valid mark (0–100)");
        }
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
