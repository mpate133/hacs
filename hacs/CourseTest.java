/**
 * @author Manan Patel
 * @version 1.0
 */

package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseTest {

    Course courseForTest = new Course("SER501", 1);
    Assignment assignmentForTest = new Assignment();

    @Test
    void addAssignment() {
        courseForTest.addAssignment(assignmentForTest);
        courseForTest.addAssignment(assignmentForTest);
        Assertions.assertEquals(2, courseForTest.assignmentList.size());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("SER501", courseForTest.toString());
    }

    @Test
    void accept() {
        Assertions.assertEquals(false, courseForTest.returnAccept());
        courseForTest.accept(new ReminderVisitor());
        Assertions.assertEquals(true, courseForTest.returnAccept());
    }
}