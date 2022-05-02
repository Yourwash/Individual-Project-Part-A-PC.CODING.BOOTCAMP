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
class StudentPerCourse {

    Course course;
    ArrayList<Student> StudentList = new ArrayList();

    public StudentPerCourse(ListHolder listHolder) {
        for (int i = 0; i < listHolder.CourseList.size(); i++) {
            this.course = listHolder.CourseList.get(i);
            for (int j = 0; j < listHolder.CourseList.get(i).subjectList.size(); j++) {
                for (int y = 0; y < listHolder.CourseList.get(i).subjectList.get(j).StudentList.size(); y++) {
                    this.StudentList.add(listHolder.CourseList.get(i).subjectList.get(j).StudentList.get(y));
                }
            }
        }    
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(course);
        sb.append(StudentList);
        return sb.toString();
    }

}
