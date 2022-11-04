/**
 * @author Manan Patel
 * @version 1.0
 */

package hacs;

import org.junit.jupiter.api.Assertions;
import java.text.DateFormat;
import java.util.Date;


class AssignmentTest {

    Assignment assignmentForTest = new Assignment();
    Solution solutionForTest = new Solution();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void setDueDate() {
        Date due = new Date();
        assignmentForTest.setDueDate(due);
        DateFormat dF = DateFormat.getDateInstance(DateFormat.SHORT);
        Assertions.assertEquals(
            dF.format(due),
            assignmentForTest.getDueDateString()
        );
    }

    @org.junit.jupiter.api.Test
    void setAssignmentSpecification() {
        String specification = "Assignment Specification";
        assignmentForTest.setAssignmentSpecification(specification);
        Assertions.assertEquals(
            specification,
            assignmentForTest.assignmentSpecification
        );
    }

    @org.junit.jupiter.api.Test
    void isOverDue() {
        assignmentForTest.setDueDate(
            new Date(System.currentTimeMillis()-24*60*60*1000)
        );
        Assertions.assertEquals(true, assignmentForTest.isOverDue());
        assignmentForTest.setDueDate(
            new Date(System.currentTimeMillis()+24*60*60*1000)
        );
        Assertions.assertEquals(false, assignmentForTest.isOverDue());
    }

    @org.junit.jupiter.api.Test
    void addSolution() {
        assignmentForTest.addSolution(solutionForTest);
        assignmentForTest.addSolution(solutionForTest);
        Assertions.assertEquals(
            2,
            assignmentForTest.getSolutionList().size()
        );
    }

    @org.junit.jupiter.api.Test
    void submitSolution() {
        assignmentForTest.submitSolution();
    }

    @org.junit.jupiter.api.Test
    void getSolutionList() {
        Assertions.assertEquals(
            0,
            assignmentForTest.getSolutionList().size()
        );
    }

    @org.junit.jupiter.api.Test
    void getSolution() {
        solutionForTest.theAuthor = "Manan Patel";
        assignmentForTest.addSolution(solutionForTest);
        Assertions.assertEquals(
            "Manan Patel",
            assignmentForTest.getSolution("Manan Patel").theAuthor
        );
    }

    @org.junit.jupiter.api.Test
    void getSuggestSolution() {
        Assertions.assertEquals(
            assignmentForTest.getSuggestSolution().getClass(),
            new Solution().getClass()
        );
    }

    @org.junit.jupiter.api.Test
    void getSolutionIterator() {
        SolutionIterator iter = assignmentForTest.getSolutionIterator();
        Assertions.assertEquals(true, iter.solutionlist.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String testString = "String for unit test";
        assignmentForTest.assignmentName = testString;
        Assertions.assertEquals(testString, assignmentForTest.toString());
    }

    @org.junit.jupiter.api.Test
    void getDueDateString() {
        Date due = new Date();
        assignmentForTest.setDueDate(due);
        DateFormat dF = DateFormat.getDateInstance(DateFormat.SHORT);
        Assertions.assertEquals(
            dF.format(due),
            assignmentForTest.getDueDateString()
        );
    }

    @org.junit.jupiter.api.Test
    void accept() {
        Assertions.assertEquals(false, assignmentForTest.returnAccept());
        assignmentForTest.accept(new ReminderVisitor());
        Assertions.assertEquals(true, assignmentForTest.returnAccept());
    }
}
