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
class TrainerPerCourse {

    Course course;
    ArrayList<Trainer> TrainerList = new ArrayList();

    public TrainerPerCourse(int i, ListHolder listHolder) {
        this.course = listHolder.CourseList.get(i);
        for (int j = 0; j < listHolder.TrainerList.size(); j++) {
            this.TrainerList.add(listHolder.TrainerList.get(j));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(course);
        sb.append(TrainerList);
        return sb.toString();
    }

}
