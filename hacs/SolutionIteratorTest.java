/**
 * @author Manan Patel
 * @version 1.0
 */

package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionIteratorTest {

    Solution solutionForTest = new Solution();
    SolutionList solList = new SolutionList();
    SolutionIterator iter = new SolutionIterator(solList);

    @Test
    void remove() {
        Assertions.assertEquals(0, solList.size());
        solList.add(solutionForTest);
        Assertions.assertEquals(1, solList.size());
        iter.next();
        iter.remove();
        Assertions.assertEquals(0, solList.size());
    }

    @Test
    void moveToHead() {
        Assertions.assertEquals(-1, iter.currentSolutionNumber);
        solList.add(solutionForTest);
        iter.next();
        Assertions.assertEquals(0, iter.currentSolutionNumber);
        iter.next();
        iter.moveToHead();
        Assertions.assertEquals(-1, iter.currentSolutionNumber);
    }

    @Test
    void hasNext() {
        Assertions.assertEquals(false, iter.hasNext());
        solList.add(solutionForTest);
        Assertions.assertEquals(true, iter.hasNext());
    }

    @Test
    void next() {
        Assertions.assertEquals(null,iter.next());
        solList.add(solutionForTest);
        Assertions.assertNotEquals(null,iter.next());
    }

    @Test
    void testNext() {
        Assertions.assertEquals(null,iter.next());
        solutionForTest.theAuthor = "Manan Patel";
        solList.add(solutionForTest);
        Assertions.assertNotEquals(null,iter.next("Manan Patel"));
    }
}
