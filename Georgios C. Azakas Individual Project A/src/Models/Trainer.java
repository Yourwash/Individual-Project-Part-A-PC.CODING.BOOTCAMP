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
public class Trainer {

    boolean goNext;
    Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private Subject subject;
    ArrayList<Subject> subjectList = new ArrayList();

    public Trainer(ListHolder listHolder) throws ParseException {
        System.out.println("Type the Trainers first Name: ");
        this.firstName = sc.nextLine();
        System.out.println("Type the Trainers last Name: ");
        this.lastName = sc.nextLine();
        System.out.println("From left to right, which course would you like for the trainer to be a part of: Type: 1 for the 1st, 2 for the 2nd etc.. ");
        for (int i = 0; i < listHolder.CourseList.size(); i++) {
            System.out.println(listHolder.CourseList.get(i).getCourseTitle());
        }
        int i = sc.nextInt();
        System.out.println("From left to right, which subject would you like for the trainer to teach; Type: 1 for the 1st, 2 for the 2nd etc.. ");
        System.out.println(listHolder.CourseList.get(i - 1).subjectList);
        int y = sc.nextInt();
        this.subject = listHolder.CourseList.get(i - 1).subjectList.get(y - 1);
        this.subjectList.add(subject);
    }

    /**
     *
     * @param i
     * @param listHolder
     * @throws ParseException
     */
    public Trainer(int i, ListHolder listHolder) throws ParseException {
        this.firstName = "Reniart " + i;
        this.lastName = "Gnidoc " + i;
        if (i < 2) {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(0));
            }
        } else if (i < 4) {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(1));
            }
        } else if (i < 6) {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(2));
            }
        } else if (i < 8) {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(3));
            }
        } else if (i < 10) {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(4));
            }
        } else if (i < 12) {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(5));
            }
        } else if (i < 14) {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(6));
            }
        } else {
            for (int j = 0; j < 5; j++) {
                this.subjectList.add(listHolder.CourseList.get(j).subjectList.get(7));
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lasName) {
        this.lastName = lasName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trainer: ").append(firstName).append(" ").append(lastName);
        sb.append(" Teaching: ").append("\n").append(subjectList);
        return sb.toString();
    }
}
