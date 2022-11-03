package hacs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {

    ClassCourseList classCourseList = new ClassCourseList();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initializeFromFile() {
        classCourseList.initializeFromFile("./TextFiles/CourseInfo.txt");
        Assertions.assertEquals(3,classCourseList.size());
    }

    @Test
    void findCourseByCourseName() {
        String course = "SER501";
        classCourseList.initializeFromFile("./TextFiles/CourseInfo.txt");
        assertEquals(course, classCourseList.findCourseByCourseName((course)).toString());
    }
}