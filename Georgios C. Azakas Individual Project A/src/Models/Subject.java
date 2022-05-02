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
    Student student;
    Trainer trainer;
    ArrayList<Student> StudentList = new ArrayList();
    ArrayList<Assignment> AssignmentList = new ArrayList();

    boolean goNext = false;
    String yon;
    Scanner sc = new Scanner(System.in);

    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public Subject(ListHolder listHolder) throws ParseException {
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

            this.student = new Student(this.AssignmentList);
            StudentList.add(student);
            listHolder.StudentList.add(this.student);
            AssignmentsPerStudent aps = new AssignmentsPerStudent(this.student,AssignmentList);
            listHolder.AssignmentsPerStudentList.add(aps);
            this.assignment = new Assignment();
            AssignmentList.add(assignment);
            listHolder.AssignmentList.add(this.assignment);
            

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

    public Subject(int i, String courseTitle, String date, ListHolder listHolder) throws ParseException {
        switch (i) {
                case 0:
                    this.subjectTitle = courseTitle + " Java";                   
                    break;
                case 1:
                     this.subjectTitle = courseTitle + " Java Part Time";
                    break;
                case 2:
                     this.subjectTitle = courseTitle +" C#";
                    break;
                case 3:
                     this.subjectTitle = courseTitle +" C# Part Time";
                    break;
                case 4:
                     this.subjectTitle = courseTitle + " Javascript";
                    break;
                case 5:
                     this.subjectTitle = courseTitle + " Javascript Part Time";
                    break;
                case 6:
                     this.subjectTitle = courseTitle + " Python";
                    break;
                case 7:
                     this.subjectTitle = courseTitle + " Python Part Time";
                    break;
            }
        for (int j = 1; j <= 7; j++) {          
            this.assignment = new Assignment(j, subjectTitle, date);
            listHolder.AssignmentList.add(this.assignment);
            this.AssignmentList.add(assignment);
        }
        for (int y = 1; y <= 10; y++) {
            student = new Student(y, AssignmentList,subjectTitle);
            listHolder.StudentList.add(student);
            this.StudentList.add(student);
            AssignmentsPerStudent aps = new AssignmentsPerStudent(this.student,AssignmentList);
            listHolder.AssignmentsPerStudentList.add(aps);
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
