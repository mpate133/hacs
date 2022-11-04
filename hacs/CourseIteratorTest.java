/**
 * @author Manan Patel
 * @version 1.0
 */

package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseIteratorTest {

    Course course = new Course("SER501", 1);
    ClassCourseList classCourseList = new ClassCourseList();
    CourseIterator iter = new CourseIterator(classCourseList);


    @Test
    void remove() {
        classCourseList.add(course);
        iter.next();
        iter.remove();
        Assertions.assertEquals(0, iter.theCourseList.size());
    }

    @Test
    void hasNext() {
        classCourseList.add(course);
        Assertions.assertEquals(true, iter.hasNext());
    }

    @Test
    void next() {
        classCourseList.add(course);
        Assertions.assertNotEquals(null, iter.next());
    }

    @Test
    void testNext() {
        classCourseList.add(course);
        Assertions.assertNotEquals(null, iter.next("SER501"));
    }
}
