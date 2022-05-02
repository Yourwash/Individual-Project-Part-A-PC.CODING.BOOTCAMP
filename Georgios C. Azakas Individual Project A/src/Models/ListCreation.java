/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static java.lang.reflect.Array.set;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Dante_Fiero
 */
public class ListCreation {

    boolean goNext = false;
    String yon;
    Scanner sc = new Scanner(System.in);
    private ListHolder listHolder;
    Set<Student> setStudent = new HashSet<>();
    String tempDate;

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
                                listHolder.CourseList.get(j - 1).subjectList.get(k - 1).StudentList.add(listHolder.CourseList.get(i - 1).subjectList.get(y - 1).StudentList.get(z - 1));
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
                    }
                    break;

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

                    for (Student student : listHolder.StudentList) {
                        if (setStudent.add(student) == false) {
                            listHolder.MigasStudentList.add(student);
                        }
                    }
                    goNext = true;
                    break;
            }
        }
    }

    public ListCreation(String tempDate, ListHolder listHolder) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(tempDate));
        int d = cal.get(Calendar.DAY_OF_WEEK);
        String td1;
        String td2;
        String td3;
        String td4;
        String td5;
        if (d == 7) {
            cal.add(Calendar.DAY_OF_MONTH, -6);
            td1 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -5);
            td2 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -4);
            td3 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -3);
            td4 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -2);
            td5 = sdf.format(cal.getTime());
        } else if (d == 1) {
            cal.add(Calendar.DAY_OF_MONTH, 0);
            td1 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
            td2 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 2);
            td3 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 3);
            td4 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 4);
            td5 = sdf.format(cal.getTime());
        } else if (d == 2) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
            td1 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 0);
            td2 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
            td3 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 2);
            td4 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 3);
            td5 = sdf.format(cal.getTime());
        } else if (d == 3) {
            cal.add(Calendar.DAY_OF_MONTH, -2);
            td1 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -1);
            td2 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 0);
            td3 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
            td4 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 2);
            td5 = sdf.format(cal.getTime());
        } else if (d ==4) {
            cal.add(Calendar.DAY_OF_MONTH, -3);
            td1 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -2);
            td2 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -1);
            td3 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 0);
            td4 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
            td5 = sdf.format(cal.getTime());
        } else if (d == 5) {
            cal.add(Calendar.DAY_OF_MONTH, -4);
            td1 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -3);
            td2 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -2);
            td3 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -1);
            td4 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 0);
            td5 = sdf.format(cal.getTime());
        } else {
            cal.add(Calendar.DAY_OF_MONTH, -5);
            td1 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -4);
            td2 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -3);
            td3 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -2);
            td4 = sdf.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -1);
            td5 = sdf.format(cal.getTime());
        }

        for (Student student : listHolder.StudentList) {
            for (int i = 0; i < student.AssignmentList.size(); i++) {
                if (student.AssignmentList.get(i).getSubDateTime().equals(td1) || student.AssignmentList.get(i).getSubDateTime().equals(td2) || student.AssignmentList.get(i).getSubDateTime().equals(td3) || student.AssignmentList.get(i).getSubDateTime().equals(td4) || student.AssignmentList.get(i).getSubDateTime().equals(td5)) {
                    System.out.println(student);
                }
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
