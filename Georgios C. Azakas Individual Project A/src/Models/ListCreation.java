/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Dante_Fiero
 */
public class ListCreation {
 
    boolean goNext = false;
    String yon;
    Scanner sc = new Scanner(System.in);
    private ListHolder listHolder;

    /**
     *
     * @throws ParseException
     */
    public ListCreation() throws ParseException {
        this.listHolder = new ListHolder();
        while (goNext == false) {
            System.out.println("If you want to input your own data, type 'Yes', if now type 'No': ");
            yon = sc.nextLine();
            switch (yon) {
                case "Yes":
                    Course course = new Course();
                    listHolder.CourseList.add(course);;
                    System.out.println(course);
                    System.out.println(listHolder.getCourseList());
                    Student student = new Student();
                    listHolder.StudentList.add(student);
                    System.out.println(student);
                    Trainer trainer = new Trainer(listHolder);
                    listHolder.TrainerList.add(trainer);
                    System.out.println(trainer);
                    goNext = true;
                    break;
                case "No":
//                    System.out.println("How many courses do you wish generate?");
//                    int i = sc.nextInt();
                    int i = 5;
                    for (int y = 1; y <= i; y++) {
                        course = new Course(y);
                        listHolder.CourseList.add(course);
                        System.out.println(course);                       
                    }                       
//                    System.out.println("How many students do you wish generate?");
//                    i = sc.nextInt();
                    int j = i*40;
                    for (int y = 1; y <= j; y++) {
                        student = new Student(y);
                        listHolder.StudentList.add(student);
                        System.out.println(student);
                    }
//                    System.out.println("How many Trainers do you wish generate?");
//                    i = sc.nextInt();
//                    int k = i*16;
                    for (int y = 1; y <= 16; y++) {
                        trainer = new Trainer(y , listHolder);
                        listHolder.TrainerList.add(trainer);
                        System.out.println(trainer);
                    }
                    System.out.println(listHolder.getCourseList());
                    goNext = true;
                    break;
            }                
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
       
        return sb.toString();
    }

    public ListHolder getListHolder() {
        return listHolder;
    }

    public void setListHolder(ListHolder listHolder) {
        this.listHolder = listHolder;
    }

    
}
