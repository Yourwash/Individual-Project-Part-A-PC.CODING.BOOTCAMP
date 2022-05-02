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
                    while (goNext == false) {
                        Course course = new Course(listHolder);
                        listHolder.CourseList.add(course);
                        System.out.println("If you wish to add another Course, type 'Yes', if not type 'No':");                      
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
                    goNext = false;
                    while (goNext == false) {
                        Trainer trainer = new Trainer(listHolder);
                        listHolder.TrainerList.add(trainer);
                        System.out.println("If you wish to add another Trainer, type 'Yes', if not type 'No':");
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
                    StudentPerCourse spc = new StudentPerCourse(listHolder);
                    listHolder.StudentPerCourseList.add(spc);
                    AssignmentPerCourse apc = new AssignmentPerCourse(listHolder);
                    listHolder.AssignmentPerCourseList.add(apc);
                    for (int y = 0; y < listHolder.CourseList.size(); y++) {
                        TrainerPerCourse tpc = new TrainerPerCourse(y, listHolder);
                        listHolder.TrainerPerCourseList.add(tpc);
                    }
                    goNext = false;
                    while (goNext == false) {
                        System.out.println("Do any of the students you added, wish to participate in antother course as well? Type 'Yes', if not type 'No':");
                        yon = sc.nextLine();
                        switch (yon) {
                            case "Yes":
                                System.out.println("From left to right, in which course is the student enrolled? Type: 1 for the 1st, 2 for the 2nd etc.. ");
                                for (int i = 0; i < listHolder.CourseList.size(); i++) {
                                    System.out.println(listHolder.CourseList.get(i).getCourseTitle());
                                }
                                int i = sc.nextInt();
                                System.out.println("From left to right, witch subject is the student attending? Type: 1 for the 1st, 2 for the 2nd etc.. ");
                                System.out.println(listHolder.CourseList.get(i - 1).subjectList);
                                int y = sc.nextInt();
                                System.out.println("From left to right, witch is the student of your choice? Type: 1 for the 1st, 2 for the 2nd etc.. ");
                                System.out.println(listHolder.CourseList.get(i - 1).subjectList.get(y - 1).StudentList);
                                int z = sc.nextInt();
                                System.out.println("From left to right, choose the new course. Type: 1 for the 1st, 2 for the 2nd etc.. ");
                                for (int j = 0; j < listHolder.CourseList.size(); j++) {
                                    System.out.println(listHolder.CourseList.get(j).getCourseTitle());
                                }
                                int j = sc.nextInt();
                                System.out.println("From left to right, choose the new subject. Type: 1 for the 1st, 2 for the 2nd etc.. ");
                                System.out.println(listHolder.CourseList.get(j - 1).subjectList);
                                int k = sc.nextInt();
                                int r = listHolder.CourseList.get(j - 1).subjectList.get(k - 1).StudentList.size();
                                listHolder.CourseList.get(j - 1).subjectList.get(k - 1).StudentList.add(listHolder.CourseList.get(i - 1).subjectList.get(y - 1).StudentList.get(z-1));
                                for (int m = 0; m < listHolder.CourseList.get(j - 1).subjectList.get(k - 1).AssignmentList.size(); m++) {
                                    listHolder.CourseList.get(j - 1).subjectList.get(k - 1).StudentList.get(r).AssignmentList.add(listHolder.CourseList.get(j - 1).subjectList.get(k - 1).AssignmentList.get(m));
                                }
                                goNext = false;
                                break;
                            case "No":
                                goNext = true;
                                break;
                        }
                        goNext = true;
                        break;
                    }

                case "No":
                    for (int y = 1; y <= 5; y++) {
                        Course course = new Course(y, listHolder);
                        listHolder.CourseList.add(course);
                        spc = new StudentPerCourse(listHolder);
                        listHolder.StudentPerCourseList.add(spc);
                        apc = new AssignmentPerCourse(listHolder);
                        listHolder.AssignmentPerCourseList.add(apc);

                    }
                    for (int y = 1; y <= 16; y++) {
                        Trainer trainer = new Trainer(y, listHolder);
                        listHolder.TrainerList.add(trainer);
                    }
                    for (int y = 0; y < listHolder.CourseList.size(); y++) {
                        TrainerPerCourse tpc = new TrainerPerCourse(y, listHolder);
                        listHolder.TrainerPerCourseList.add(tpc);
                    }

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
