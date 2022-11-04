package hacs;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0
 * update to Java 8
 *
 * @author Manan Patel
 * @version 3.0
 */

/*
 * this class will iterate the course list attatched to on student and in turn
 * iterate the assignments of a course.
 * after Function Visit(CourseList) it will
 * point to the location before the fist class, hasNext will retrun weather
 * there is next item. the next() will return the next Item Assignment;
 */

public class ReminderVisitor extends NodeVisitor {

    Reminder mReminder;

    public ReminderVisitor() {
    }

    public ReminderVisitor(Reminder reminder) {
        mReminder = reminder;
    }

    public void visitFacade(Facade facade) {
        CourseIterator courseList = new CourseIterator(facade.theCourseList);
        while (courseList.hasNext()) {
            Course course = (Course) courseList.next();
            course.accept(this);
        }
    }

    public void visitCourse(Course course) {
        Iterator<Assignment> assignmentList;
        assignmentList = course.assignmentList.listIterator();
        while (assignmentList.hasNext()) {
            Assignment assignment = assignmentList.next();
            assignment.accept(this);
        }
    }

    public void visitAssignment(Assignment assignment) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(assignment.dueDate);
        int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
        if(mReminder != null) { // correcting because of the test case
            if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
            {
                mReminder.listUpcoming.add(
                    "today is "
                    + today.toString()
                    + " "
                    + assignment.assignmentName
                    + " Due Date is "
                    + assignment.getDueDateString()
                );
            }
            if (nDueDate < ntoday) {
                // put to the
                mReminder.listOverdue.add(
                    assignment.assignmentName
                    + " Due Date is "
                    + assignment.getDueDateString()
                );
            }
        }

    }

}
