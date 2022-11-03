package hacs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    Course courseForTest = new Course("SER501", 1);
    Instructor instructorForTest = new Instructor();
    CourseMenu courseMenuForTest = instructorForTest.createCourseMenu(courseForTest, 1);


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createCourseMenu() {
        Assertions.assertEquals(true, courseMenuForTest instanceof LowLevelCourseMenu);
        courseMenuForTest = instructorForTest.createCourseMenu(new Course("SER515", 0), 0);
        Assertions.assertEquals(true, courseMenuForTest instanceof HighLevelCourseMenu);
    }

    @Test
    void showMenu() {
        Assertions.assertEquals(instructorForTest.type, 1);
    }
}