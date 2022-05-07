/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utilities.Input;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Dante_Fiero
 */
public class Assignment {

    private String title;
    private String description;
    private String subDateTime;
    private int oralMark;
    private int totalMark;
    boolean goNext = false;
    String yon;
  

    public Assignment() throws ParseException {
        while (goNext == false) {
            System.out.println("Type the title of the Assignment: (Example: Assignment 1)");
            this.title = Input.inputText();
            System.out.println("Describe the assignment:");
            this.description = Input.inputText();

            while (goNext == false) {
                System.out.println("Type the submission date of the Assignment: (dd-MM-yyyy)");                          
                this.subDateTime = Input.inputDate();
                goNext = true;
            }
            System.out.println("If you wish to add another Assignment, type 'Yes', if not type 'No':");         
            yon = Input.inputText();
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
        if (i <= 5) {
            this.title = subjectTitle + " Assignment " + i;
            this.description = "Random Assignment";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy (EEE)");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DAY_OF_MONTH, i * 12);
            int d = cal.get(Calendar.DAY_OF_WEEK);
            switch (d) {
                case 7:
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    break;
                case 1:
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    break;
            }
            this.subDateTime = sdf.format(cal.getTime());
        } else if (i == 6) {
            this.title = subjectTitle + " Individual Project ";
            this.description = "Random assignment but not an assignment, but an assignment.";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy (EEE)");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DAY_OF_MONTH, i * 12);
            int d = cal.get(Calendar.DAY_OF_WEEK);
            switch (d) {
                case 7:
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    break;
                case 1:
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    break;
            }
            this.subDateTime = sdf.format(cal.getTime());
        } else {
            this.title = subjectTitle + " Group Project ";
            this.description = "Random assignment but not an assignment, but an assignment.";
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy (EEE)");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DAY_OF_MONTH, i * 12);
            int d = cal.get(Calendar.DAY_OF_WEEK);
            switch (d) {
                case 7:
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    break;
                case 1:
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    break;
            }
            this.subDateTime = sdf.format(cal.getTime());
        }

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

    public String getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(String subDateTime) {
        this.subDateTime = subDateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        sb.append(" Submision Date: ").append(subDateTime);
        sb.append(" Oral Mark: ").append(oralMark);
        sb.append(" Total Mark: ").append(totalMark).append("\n");
        sb.append("Description: ").append(description).append("\n");
        return sb.toString();
    }

}
