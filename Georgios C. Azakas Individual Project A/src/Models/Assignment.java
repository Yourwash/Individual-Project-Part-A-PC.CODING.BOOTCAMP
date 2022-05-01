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
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author Dante_Fiero
 */
public class Assignment implements FormattingDate {

    private String title;
    private String description;
    private String subDateTime;
    private int oralMark;
    private int totalMark;
    boolean goNext = false;
    String yon;
    Scanner sc = new Scanner(System.in);

    public Assignment() throws ParseException {
        while (goNext == false) {
            System.out.println("Type the title of the Assignment: (Example: Assignment 1)");
            this.title = sc.nextLine();
            System.out.println("Describe the assignment:");
            this.description = sc.nextLine();

            while (goNext == false) {
                System.out.println("Type the submission date of the Assignment: (dd-MM-yyyy)");
                String tempDate = sc.next();
                Date date = StringToDate(tempDate);
                this.subDateTime = new SimpleDateFormat("dd-MM-yyyy").format(date);
                goNext = true;
            }
            System.out.println("If you wish to add another Assignment, type 'Yes', if not type 'No':");
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

    public Assignment(int i, String subjectTitle, String date) throws ParseException {
        this.title = subjectTitle + " Assignment " + i;
        this.description = "Random Assignment";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(date));
        cal.add(Calendar.DAY_OF_MONTH, i * 12);
        this.subDateTime = sdf.format(cal.getTime());      
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

}
