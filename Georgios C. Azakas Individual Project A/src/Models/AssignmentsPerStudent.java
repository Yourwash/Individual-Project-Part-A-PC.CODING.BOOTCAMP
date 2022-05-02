/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Dante_Fiero
 */
public class AssignmentsPerStudent {
    Student student;
    ArrayList<Assignment> AssignmentList = new ArrayList();

    public AssignmentsPerStudent(Student student, ArrayList<Assignment> AssignmentList) {
        this.student = student;
        this.AssignmentList = AssignmentList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(student).append("\n");
        sb.append(AssignmentList).append("\n");
        return sb.toString();
    }
    
    
    
    
}
