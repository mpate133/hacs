package hacs;

import java.util.ArrayList;

/**
 * Title: HACS
 * Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002
 * Company: Department of Computer Science and Engineering, Michigan State
 * University
 *
 * @author Ji Zhang, Wei Zhu
 * @author mjfindler
 * @version 2.0
 * Update to Java 8
 *
 * @author Manan Patel
 * @version 3.0
 */

public class Course {
    public ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
    String courseName;
    int numberOfAssignment;
    int courseLevel;

    public boolean isEnteredAccept = false;

    public Course(String stringCourse, int theLevel) {
        this.courseName = stringCourse;

        this.courseLevel = theLevel;
        // this.AssList = NULL;
        this.numberOfAssignment = 0;
    }

    public void addAssignment(Assignment newAss) {
        assignmentList.add(newAss);
    }

    public String toString() {
        return courseName;
    }

    void accept(NodeVisitor visitor) {
        visitor.visitCourse(this);
        isEnteredAccept = true;
    }

    public boolean returnAccept(){
        return isEnteredAccept;
    }

}
