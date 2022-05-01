/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Interfaces.FormattingDate;
import static Interfaces.FormattingDate.StringToDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dante_Fiero
 */
public class Course implements FormattingDate {

    private String courseTitle;
    private Subject subject;
    private boolean type;
    private String start_date;
    private String end_date;
    boolean goNext = false;
    String yon;
    Scanner sc = new Scanner(System.in);
    ArrayList<Subject> subjectList = new ArrayList();

    public Course() throws ParseException {

        while (goNext == false) {
            System.out.println("Type the title of the Course: (Example: CB1)");
            this.courseTitle = sc.nextLine();
            while (goNext == false) {
                System.out.println("Type the starting date of the Course: (dd-MM-yyyy)");
                String tempDate = sc.next();
                Date date = StringToDate(tempDate);
                start_date = new SimpleDateFormat("dd-MM-yyyy").format(date);
                System.out.println("Type the ending date of the Course: (dd-MM-yyyy)");
                tempDate = sc.next();
                date = StringToDate(tempDate);
                end_date = new SimpleDateFormat("dd-MM-yyyy").format(date);
                goNext = true;
            }

            this.subject = new Subject();
            subjectList.add(this.subject);
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
    }

    public Course(int i) throws ParseException {
        this.courseTitle = "CB" + i;
        int k = i * 3;
        int y = 0;
        int l = 0;
        while ((1 + k) / 12 >= 1 && goNext == false) {
            y = (1 + k) / 12;
            goNext = true;
        }
        this.start_date = "01-" + (1 + k) % 12 + "-20" + (22 + y);
        goNext = false;
        while ((4 + k) / 12 >= 1 && goNext == false) {
            l = (4 + k) / 12;
            goNext = true;
        }
        this.end_date = "01-" + (4 + k) % 12 + "-20" + (22 + l);

        for (int z = 0; z < 8; z++) {
            subject = new Subject(z ,courseTitle, start_date);
            switch (z) {
                case 0:
                    subject.setsubjectTitle(courseTitle + " Java");
                    subjectList.add(subject);                   
                    break;
                case 1:
                    subject.setsubjectTitle(courseTitle + " Java Part Time");
                    subjectList.add(subject);
                    break;
                case 2:
                    subject.setsubjectTitle(courseTitle + " C#");
                    subjectList.add(subject);
                    break;
                case 3:
                    subject.setsubjectTitle(courseTitle + " C# Part Time");
                    subjectList.add(subject);
                    break;
                case 4:
                    subject.setsubjectTitle(courseTitle + " Javascript");
                    subjectList.add(subject);
                    break;
                case 5:
                    subject.setsubjectTitle(courseTitle + " Javascript Part Time");
                    subjectList.add(subject);
                    break;
                case 6:
                    subject.setsubjectTitle(courseTitle + " Python");
                    subjectList.add(subject);
                    break;
                case 7:
                    subject.setsubjectTitle(courseTitle + " Python Part Time");
                    subjectList.add(subject);
                    break;
            }

        }

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

}
