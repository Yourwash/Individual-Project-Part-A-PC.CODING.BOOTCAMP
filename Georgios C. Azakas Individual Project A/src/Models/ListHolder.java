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
public class ListHolder {

    ArrayList<Student> StudentList = new ArrayList();
    ArrayList<Trainer> TrainerList = new ArrayList();
    ArrayList<Assignment> AssignmentList = new ArrayList();
    ArrayList<Course> CourseList = new ArrayList();
    ArrayList<StudentPerCourse> StudentPerCourseList = new ArrayList();
    ArrayList<TrainerPerCourse> TrainerPerCourseList = new ArrayList();
    ArrayList<AssignmentPerCourse> AssignmentPerCourseList = new ArrayList();
    ArrayList<AssignmentsPerStudent> AssignmentsPerStudentList = new ArrayList();

    public ListHolder() {}

    public ArrayList<AssignmentsPerStudent> getAssignmentsPerStudentList() {
        return AssignmentsPerStudentList;
    }

    public void setAssignmentsPerStudentList(ArrayList<AssignmentsPerStudent> AssignmentsPerStudentList) {
        this.AssignmentsPerStudentList = AssignmentsPerStudentList;
    }
    public ArrayList<Student> getStudentList() {
        return StudentList;
    }

    public ArrayList<StudentPerCourse> getStudentPerCourseList() {
        return StudentPerCourseList;
    }

    public void setStudentPerCourseList(ArrayList<StudentPerCourse> StudentPerCourseList) {
        this.StudentPerCourseList = StudentPerCourseList;
    }

    public ArrayList<TrainerPerCourse> getTrainerPerCourseList() {
        return TrainerPerCourseList;
    }

    public void setTrainerPerCourseList(ArrayList<TrainerPerCourse> TrainerPerCourseList) {
        this.TrainerPerCourseList = TrainerPerCourseList;
    }

    public ArrayList<AssignmentPerCourse> getAssignmentPerCourseList() {
        return AssignmentPerCourseList;
    }

    public void setAssignmentPerCourseList(ArrayList<AssignmentPerCourse> AssignmentPerCourseList) {
        this.AssignmentPerCourseList = AssignmentPerCourseList;
    }

    public void setStudentList(ArrayList<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public ArrayList<Trainer> getTrainerList() {
        return TrainerList;
    }

    public void setTrainerList(ArrayList<Trainer> TrainerList) {
        this.TrainerList = TrainerList;
    }

    public ArrayList<Assignment> getAssignmentList() {
        return AssignmentList;
    }

    public void setAssignmentList(ArrayList<Assignment> AssignmentList) {
        this.AssignmentList = AssignmentList;
    }

    public ArrayList<Course> getCourseList() {
        return CourseList;
    }

    public void setCourseList(ArrayList<Course> CourseList) {
        this.CourseList = CourseList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListHolder{StudentList=").append(StudentList);
        sb.append(", TrainerList=").append(TrainerList);
        sb.append(", AssignmentList=").append(AssignmentList);
        sb.append(", CourseList=").append(CourseList);
        sb.append('}');
        return sb.toString();
    }

   
    }

    
    

