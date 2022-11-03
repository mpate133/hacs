package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

    public ClassCourseList() {
    }

    void initializeFromFile(String theFileName) {
        try {
            BufferedReader file;
            String stringCourseName = null;
            file = new BufferedReader(new FileReader("./TextFiles/CourseInfo.txt"));
            while ((stringCourseName = file.readLine()) != null) {
                Course theCourse = new Course(stringCourseName, 0);
                // theCourse.CourseName= strCourseName;
                add(theCourse);
            }
        } catch (Exception ee) {
            
        }
    }

    Course findCourseByCourseName(String courseName) {
        int nCourseCount = size();
        for (int i = 0; i < nCourseCount; i++) {
            Course theCourse = (Course) get(i);
            if (theCourse.courseName.compareTo(courseName) == 0) {
                return theCourse;
            }
        }
        return null;
    }

}
