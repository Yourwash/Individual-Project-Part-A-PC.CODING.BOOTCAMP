/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package georgios.c.azakas.individual.project.a;

import Models.ListCreation;
import Utilities.Input;
import java.text.ParseException;

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

        ListCreation newProject = new ListCreation();
        
//        Class ListCreation is the first is where everything begins being created.
//        In here we see only see the main menu of the project.
//        I have used <while> with boollean <goNext>, throughout all of my classes. This is firstly in order to loop through parts of the code
//        and protect the program for incorect typing.Secondly to give the opertunity to the user, to serially input and check a lot of diffrent things.
//        Go to ListCreation.
        
        boolean goNext = false;
        while (goNext == false) {
            goNext = false;
            while (goNext == false) {
                System.out.println("Which list would you like to print? Type the names as follows: Student List, Trainer List, Assignment List, Course List, Students per Course List, Trainers per Course List, Assignments per Course List, Assignment per Student List, Migas Student List");
                String temp = Input.inputText();
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
                        System.out.println(newProject.getListHolder().getAssignmentsPerStudentList());
                        goNext = true;
                        break;
                    case "Migas Student List":
                        System.out.println(newProject.getListHolder().getMigasStudentList());
                        goNext = true;
                        break;
                }
            }
            goNext = false;
            System.out.println("Would like to check another list? Type 'Yes', if not type 'No':");
            String yon = Input.inputText();
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
            System.out.println("Type a date (22-02-2022) to see witch student's are due that week.");
            String tempDate = Input.inputDate();
            ListCreation newProject1 = new ListCreation(tempDate, newProject.getListHolder());
            if (!newProject1.getListHolder().getStudentDueList().isEmpty()) {
                System.out.println(newProject1.getListHolder().getStudentDueList());
                goNext = true;
            } else {
                System.out.println("There are no assignments that week. Type another date.");
                goNext = false;
            }
        }
    }
}
