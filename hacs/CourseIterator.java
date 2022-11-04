package hacs;

import java.util.Iterator;

/**
 * Title: HACS
 * Description:
 * Copyright: Copyright (c) 2002
 * Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 *
 * @author Manan Patel
 * @version 2.0
 */

public class CourseIterator implements Iterator {
    ClassCourseList theCourseList;
    int currentCourseNumber = -1;

    public CourseIterator() {
    }

    public CourseIterator(ClassCourseList courseList) {
        theCourseList = courseList;
    }

    public boolean hasNext() {
        if (currentCourseNumber >= theCourseList.size() - 1) {
            return false;
        } else {
            return true;
        }
    }

    public Object next() {
        if (hasNext() == true) {
            currentCourseNumber++;
            return theCourseList.get(currentCourseNumber);
        } else {
            return null;
        }
    }

    public void remove() {
        theCourseList.remove(currentCourseNumber);
    }

    public Object next(String courseName) {
        Course theCourse = (Course) next();
        while (theCourse != null) {
            if (courseName.compareTo(theCourse.toString()) == 0) {
                return theCourse;
            }
            theCourse = (Course) next();
        }
        return null;
    }

}
