/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dante_Fiero
 */
public class Subject {

    private String subjectTitle;
    Assignment assignment;
    ArrayList<Student> StudentList = new ArrayList();
    ArrayList<Trainer> TrainerList = new ArrayList();
    ArrayList<Assignment> AssignmentList = new ArrayList();
    
    boolean goNext = false;
    String yon;
    Scanner sc = new Scanner(System.in);

    public Subject() {
        while (goNext == false) {
            while (goNext == false) {
                System.out.println("Type one of the follwing subjects: Java, C#, Javascript, Python");
                this.subjectTitle = sc.nextLine();
                switch (subjectTitle) {
                    case "Java":
                        goNext = true;
                        break;
                    case "C#":
                        goNext = true;
                        break;
                    case "Javascript":
                        goNext = true;
                        break;
                    case "Python":
                        goNext = true;
                        break;
                }
            }
            goNext = false;
            while (goNext == false) {
                System.out.println("If this subject is part time, type 'Yes', if not type 'No':");
                yon = sc.nextLine();
                switch (yon) {
                    case "Yes":
                        this.subjectTitle = subjectTitle + " Part Time";
                        goNext = true;
                        break;
                    case "No":
                        this.subjectTitle = subjectTitle + " Full Time";
                        goNext = true;
                        break;
                }
            }

            System.out.println("If you wish to add another subject, type 'Yes', if not type 'No':");
            yon = sc.nextLine();
            switch (yon) {
                case "Yes":
                    goNext = false;
                    break;
                case "No":
                    goNext = true;
                    break;
            }
        }

    }

    public Subject(int i, String subjectTitle , String date) throws ParseException {
        this.subjectTitle = subjectTitle;
        for (int j = 1; j <= 7; j++) {
                        assignment = new Assignment(j , subjectTitle ,date);                                                             
                    }
    }

    public String getsubjectTitle() {
        return subjectTitle;
    }

    public void setsubjectTitle(String title) {
        this.subjectTitle = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(subjectTitle).append("\n");
        return sb.toString();
    }

}
