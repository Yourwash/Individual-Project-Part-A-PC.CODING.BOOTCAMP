/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package georgios.c.azakas.individual.project.a;

import Models.ListCreation;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Dante_Fiero
 */
public class GeorgiosCAzakasIndividualProjectA {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        ListCreation newProject = new ListCreation();
        Scanner sc = new Scanner(System.in);
        boolean goNext = false;
        while (goNext == false) {
            goNext = false;
            while (goNext == false) {
                System.out.println("Which list would you like to print? Type the names as follows: Student List, Trainer List, Assignment List, Course List, Students per Course List, Trainers per Course List, Assignments per Course List, Assignment per Student List, Migas Student List");
                String temp = sc.nextLine();
                switch (temp) {
                    case "Student List":
                        System.out.println(newProject.getListHolder().getStudentList());
                        goNext = true;
                        break;
                    case "Trainer List":
                        System.out.println(newProject.getListHolder().getTrainerList());
                        goNext = true;
                        break;
                    case "Assignment List":
                        System.out.println(newProject.getListHolder().getAssignmentList());
                        goNext = true;
                        break;
                    case "Course List":
                        System.out.println(newProject.getListHolder().getCourseList());
                        goNext = true;
                        break;
                    case "Students per Course List":
                        System.out.println(newProject.getListHolder().getStudentPerCourseList());
                        goNext = true;
                        break;
                    case "Trainers per Course List":
                        System.out.println(newProject.getListHolder().getTrainerPerCourseList());
                        goNext = true;
                        break;
                    case "Assignments per Course List":
                        System.out.println(newProject.getListHolder().getAssignmentPerCourseList());
                        goNext = true;
                        break;
                    case "Assignment per Student List":
                        boolean toString2 = true;
                        System.out.println(newProject.getListHolder().getAssignmentsPerStudentList());
                        goNext = true;
                        break;
                    case "Migas Student List":
                        System.out.println(newProject.getListHolder().getCourseList());
                        goNext = true;
                        break;
                }
            }
            goNext = false;
            System.out.println("Would like to check another list? Type 'Yes', if not type 'No':");
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
}
