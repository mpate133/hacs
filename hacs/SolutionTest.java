package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solutionForTest = new Solution();

    @Test
    void testToString() {
        solutionForTest.theAuthor = "Manan Patel";
        solutionForTest.solutionFileName = "First solution";
        Assertions.assertEquals("Manan Patel  First solution Grade=0  not reported", solutionForTest.toString());
    }

    @Test
    void getGradeString() {
        Assertions.assertEquals("-1", solutionForTest.getGradeString());
    }

    @Test
    void getGradeInt() {
        Assertions.assertEquals(0, solutionForTest.getGradeInt());
    }

    @Test
    void isReported() {
        solutionForTest.setReported(true);
        Assertions.assertEquals(true, solutionForTest.isReported());
        solutionForTest.setReported(false);
        Assertions.assertEquals(false, solutionForTest.isReported());
    }

    @Test
    void setReported() {
        Assertions.assertEquals(false, solutionForTest.isReported());
        solutionForTest.setReported(true);
        Assertions.assertEquals(true, solutionForTest.isReported());
    }
}