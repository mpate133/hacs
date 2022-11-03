package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student studentForTest = new Student();
    CourseMenu courseMenuTest = studentForTest.createCourseMenu(new Course("SER501", 0), 0);

    @Test
    void createCourseMenu() {
        Assertions.assertEquals(true, courseMenuTest instanceof HighLevelCourseMenu);
        Assertions.assertEquals(false, courseMenuTest instanceof LowLevelCourseMenu);
        courseMenuTest = studentForTest.createCourseMenu(new Course("SER501", 1), 1);
        Assertions.assertEquals(true, courseMenuTest instanceof LowLevelCourseMenu);
    }
}