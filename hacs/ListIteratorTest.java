package hacs;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {

    ArrayList<Object> arrList = new ArrayList<>();
    hacs.ListIterator iter = new hacs.ListIterator(arrList);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void remove() {
        arrList.add("first addition");
        arrList.add("second addition");
        iter.next();
        iter.remove();
        Assertions.assertEquals(1, iter.theList.size());
        iter.next();
        iter.remove();
        Assertions.assertEquals(0, iter.theList.size());

    }

    @Test
    void hasNext() {
        arrList.add("first");
        Assertions.assertEquals(true, iter.hasNext());
        iter.next();
        iter.remove();
        Assertions.assertEquals(false, iter.hasNext());
    }

    @Test
    void next() {
        Assertions.assertEquals(null, iter.next());
        arrList.add("first");
        Assertions.assertEquals("first", iter.next());
    }
}