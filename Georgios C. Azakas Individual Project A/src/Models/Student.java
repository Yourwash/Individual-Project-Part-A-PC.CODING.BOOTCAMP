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

/**
 *
 * @author Dante_Fiero
 */
public class Student implements FormattingDate {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double tuitionFees;
    Scanner sc = new Scanner(System.in);
    boolean goNext = false;

    public Student() throws ParseException {
        while (goNext == false) {
            System.out.println("Type the sutdents first Name: ");
            this.firstName = sc.nextLine();

            System.out.println("Type the sutdents last Name: ");
            this.lastName = sc.nextLine();

            while (goNext == false) {
                System.out.println("Type the student's date of birth: (dd-MM-yyyy)");
                String tempDate = sc.next();
                Date date = StringToDate(tempDate);
                dateOfBirth = new SimpleDateFormat("dd-MM-yyyy").format(date);
                goNext = true;
            }

            System.out.println("Type the sutdents tuition fees: ");
            this.tuitionFees = sc.nextDouble();
            System.out.println("If you wish to add another subject, type 'Yes', if not type 'No':");
            String yon = sc.nextLine();
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

    public Student(int i) {
        this.firstName = "Yourwash " + i;
        this.lastName = "Azakas " + i;
        this.dateOfBirth = "19-04-1995";
        this.tuitionFees = 2250;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lastName;
    }

    public void setLasName(String lasName) {
        this.lastName = lasName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ").append(firstName).append(" ");
        sb.append(lastName).append("\n");
        sb.append("Date of Birth: ").append(dateOfBirth).append("\n");
        sb.append("Tuition Fees: ").append(tuitionFees).append(" $");
        sb.append("\n");
        return sb.toString();
    }

}
