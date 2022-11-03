package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReminderVisitorTest {

    Assignment assignmentForTest = new Assignment();
    ReminderVisitor reminderVisitorForTest = new ReminderVisitor(new Reminder());

    @Test
    void visitFacade() {
    }

    @Test
    void visitCourse() {
    }

    @Test
    void visitAssignment() {
        assignmentForTest.assignmentName = "SER501";
        assignmentForTest.setDueDate(new Date(System.currentTimeMillis()+24*60*60*1000));
        reminderVisitorForTest.visitAssignment(assignmentForTest);
        Assertions.assertNotEquals(null, reminderVisitorForTest.mReminder);
    }
}