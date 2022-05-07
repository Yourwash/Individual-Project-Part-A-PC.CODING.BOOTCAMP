/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utilities.Input;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Dante_Fiero
 */
public class Course {

    private String courseTitle;
    private Subject subject;
    private boolean type;
    private String start_date;
    private String end_date;
    boolean goNext = false;
    String yon;
    StudentPerCourse spc;
    ArrayList<Subject> subjectList = new ArrayList();

    public Course(ListHolder listHolder) throws ParseException {

        System.out.println("Type the title of the Course: (Example: CB1)");
        this.courseTitle = Input.inputText();
        while (goNext == false) {
            System.out.println("Type the starting date of the Course: (dd-MM-yyyy)");
            start_date = Input.inputDate();
            System.out.println("Type the ending date of the Course: (dd-MM-yyyy)");
            end_date = Input.inputDate();
            goNext = true;
        }

        this.subject = new Subject(listHolder);
        subjectList.add(this.subject);
    }

    public Course(int i, ListHolder listHolder) throws ParseException {
        
        this.courseTitle = "CB" + i;
        String date = "03-01-2022 (Mon)";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy (EEE)");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(date));
        cal.add(Calendar.DAY_OF_MONTH, (i - 1) * 90);
        this.start_date = sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH, 90);
        this.end_date = sdf.format(cal.getTime());

//        int k = i * 3;
//        int y = 0;
//        int l = 0;
//        while ((1 + k) / 12 >= 1 && goNext == false) {
//            y = (1 + k) / 12;
//            goNext = true;
//        }
//        this.start_date = "01-" + (1 + k) % 12 + "-20" + (22 + y);
//        goNext = false;
//        while ((4 + k) / 12 >= 1 && goNext == false) {
//            l = (4 + k) / 12;
//            goNext = true;
//        }
//        this.end_date = "01-" + (4 + k) % 12 + "-20" + (22 + l);
        for (int z = 0; z < 8; z++) {
            
            subject = new Subject(z, courseTitle, start_date, listHolder);
            subjectList.add(subject);
        }
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(courseTitle).append("     Start Date: ").append(start_date);
        sb.append("     End Date: ").append(end_date).append("\n");
        sb.append("Stream: ").append("\n");
        sb.append(subjectList);
        return sb.toString();
    }

}
