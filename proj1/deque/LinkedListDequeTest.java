package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;
import net.sf.saxon.functions.ConstantFunction;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double> lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void addTest() {
        LinkedListDeque<Integer> testLink01 = new LinkedListDeque<>();
        LinkedListDeque<Double> testLink02 = new LinkedListDeque<>();
        int N = 500;
        int item01;
        double item02;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 1000);
            testLink01.addFirst(operationNumber);
            assertEquals(i + 1, testLink01.size());
            item01 = testLink01.get(0);
            assertEquals(operationNumber, item01);
        }

        for (int i = 0; i < N; i += 1) {
            double operationNumber = StdRandom.uniform(0, 500);
            testLink02.addLast(operationNumber);
            assertEquals(i + 1, testLink02.size());
            item02 = testLink02.get(i);
            assertEquals(operationNumber,item02,0.0000000000);
        }
    }

    @Test public void removeTest() {
        LinkedListDeque<Integer> testLink01 = new LinkedListDeque<>();
        LinkedListDeque<Double> testLink02 = new LinkedListDeque<>();
        int N = 50;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 1000);
            testLink01.addFirst(operationNumber);

            int gitItem = testLink01.get(0);
            assertEquals(operationNumber,gitItem);
        }
        for (int i = 0; i < N; i += 1) {
            int testSize = testLink01.size();
            testLink01.removeFirst();

            assertEquals(testSize - 1, testLink01.size());
        }
        assertTrue(testLink01.removeFirst() == null);

        for (int i = 0; i < N; i += 1) {
            double operationNumber = StdRandom.uniform(0, 1000);
            testLink02.addLast(operationNumber);

        }
        for (int i = 0; i < N; i += 1) {
            int testSize = testLink02.size();
            testLink02.removeLast();
            assertEquals(testSize - 1, testLink02.size());
        }
        assertTrue(testLink02.removeLast() == null);
    }

    @Test
    public void isEmptyTest() {
        LinkedListDeque<Integer> testLink = new LinkedListDeque<>();
        assertTrue(testLink.isEmpty());
        int N =100;
        int itemCount = 0;

        for (int i =0; i < N; i += 1) {
            int operatironNumber = StdRandom.uniform(0, 1000);
            int selectNumber = StdRandom.uniform(0, 2);
            if (selectNumber == 0) {
                testLink.addFirst(operatironNumber);
                itemCount += 1;
                int getItem = testLink.get(0);

                assertEquals(itemCount, testLink.size());
                assertEquals(operatironNumber, getItem);
            } else if (selectNumber == 1 && itemCount > 0) {
                int getItem = testLink.get(0);
                int lostItem = testLink.removeFirst();
                itemCount -= 1;

                 assertEquals(getItem, lostItem);
                 assertEquals(itemCount, testLink.size());
            }
        }
    }

    @Test
    public void printDequeText() {
        LinkedListDeque<String> testLink = new LinkedListDeque<>();
        testLink.addFirst("I");
        testLink.addLast("am");
        testLink.addLast("a");
        testLink.addLast("student");

        testLink.printDeque();
    }

    @Test
    public void getTest() {
        LinkedListDeque<Integer> testLink = new LinkedListDeque<>();
        int N = 10;
        for (int i = 0; i < N; i += 1) {
            testLink.addLast(i);
        }
        for (int j =0; j < N; j += 1) {
            int getNumber = testLink.get(j);
            assertEquals(j,getNumber);
        }
    }

    @Test
    public  void equalsTest() {
        LinkedListDeque<Integer> testLink01 = new LinkedListDeque<>();
        LinkedListDeque<Integer> testLink02 = new LinkedListDeque<>();
        LinkedListDeque<Integer> testLink03 = new LinkedListDeque<>();
        int testSample01 = 0;
        LinkedListDeque<Integer> testSample02 = new LinkedListDeque<>();
        LinkedListDeque<Integer> testSample03 = new LinkedListDeque<>();
        int N = 100;

        //testSample01 isn't Deque
        testLink01.addLast(5);
        assertFalse(testLink01.equals(testSample01));

        //testSample02 is Deque but not equals
        testLink02.addLast(10);
        testLink02.addFirst(5);
        testSample02.addFirst(10);
        testSample02.addLast(5);

        assertFalse(testLink02.equals(testSample02));

        testSample02 = null;

        assertFalse(testLink02.equals(testSample02));

        //testSample03 is equals to the testLink03
        for (int i =0; i < N; i += 1) {
            int oprerationNumber = StdRandom.uniform(0,100);
            testLink03.addLast(oprerationNumber);
            testSample03.addLast(oprerationNumber);
        }
        assertTrue(testLink03.equals(testSample03));

        testLink03.removeFirst();

        assertFalse(testLink03.equals(testSample03));

        testSample03.removeFirst();
        assertTrue(testLink03.equals(testSample03));



    }
}
