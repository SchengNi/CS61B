package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addTest() {
        ArrayDeque<Integer> testArray01 = new ArrayDeque<>();
        ArrayDeque<Double> testArray02 = new ArrayDeque<Double>();
        int N = 500;
        int item01;
        double item02;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 1000);
            testArray01.addFirst(operationNumber);
            assertEquals(i + 1, testArray01.size());
            item01 = testArray01.get(0);
            assertEquals(operationNumber, item01);
        }

        for (int i = 0; i < N; i += 1) {
            double operationNumber = StdRandom.uniform(0, 500);
            testArray02.addLast(operationNumber);
            assertEquals(i + 1, testArray02.size());
            item02 = testArray02.get(i);
            assertEquals(operationNumber,item02,0.0000000000);
        }
    }

    @Test
    public void removeTest() {
        ArrayDeque<Integer> testArray01 = new ArrayDeque<>();
        ArrayDeque<Double> testArray02 = new ArrayDeque<Double>();
        int N = 50;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 1000);
            testArray01.addFirst(operationNumber);
        }
        for (int i = 0; i < N; i += 1) {
            int testSize = testArray01.size();
            testArray01.removeFirst();
            assertEquals(testSize - 1, testArray01.size());
        }
        assertTrue(testArray01.removeFirst() == null);

        for (int i = 0; i < N; i += 1) {
            double operationNumber = StdRandom.uniform(0, 1000);
            testArray02.addLast(operationNumber);
        }
        for (int i = 0; i < N; i += 1) {
            int testSize = testArray02.size();
            testArray02.removeLast();
            assertEquals(testSize - 1, testArray02.size());
        }
        assertTrue(testArray02.removeLast() == null);
    }

    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> testArray = new ArrayDeque<>();
        assertTrue(testArray.isEmpty());

        testArray.addFirst(5);
        assertFalse(testArray.isEmpty());

        testArray.removeFirst();
        assertTrue(testArray.isEmpty());

        testArray.addLast(10);
        assertFalse(testArray.isEmpty());

        testArray.removeLast();
        assertTrue(testArray.isEmpty());
    }

    @Test
    public void printDequeText() {
        ArrayDeque<String> testArray = new ArrayDeque<>();
        testArray.addFirst("I");
        testArray.addLast("am");
        testArray.addLast("a");
        testArray.addLast("student");

        testArray.printDeque();
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> testArrat = new ArrayDeque<>();
        int N = 10;
        for (int i = 0; i < N; i += 1) {
            testArrat.addLast(i);
        }
        for (int j =0; j < N; j += 1) {
            int getNumber = testArrat.get(j);
            assertEquals(j,getNumber);
        }
    }

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> testArray01 = new ArrayDeque<>();
        ArrayDeque<Integer> testArray02 = new ArrayDeque<>();
        ArrayDeque<Integer> testArray03= new ArrayDeque<>();
        int testSample01 = 0;
        ArrayDeque<Integer> testSample02 = new ArrayDeque<>();
        ArrayDeque<Integer> testSample03 = new ArrayDeque<>();
        int N = 100;

        //testSample01 isn't Deque
        testArray01.addLast(5);
        assertFalse(testArray01.equals(testSample01));

        //testSample02 is Deque but not equals
        testArray02.addLast(10);
        testArray02.addFirst(5);
        testSample02.addFirst(10);
        testSample02.addLast(5);

        assertFalse(testArray02.equals(testSample02));

        testSample02 = null;

        assertFalse(testArray02.equals(testSample02));

        //testSample03 is equals to the testLink03
        for (int i =0; i < N; i += 1) {
            int oprerationNumber = StdRandom.uniform(0,100);
            testArray03.addLast(oprerationNumber);
            testSample03.addLast(oprerationNumber);
        }
        assertTrue(testArray03.equals(testSample03));

        testArray03.removeFirst();

        assertFalse(testArray03.equals(testSample03));

        testSample03.removeFirst();
        assertTrue(testArray03.equals(testSample03));

    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> testArray01 = new ArrayDeque<>();
        Iterator<Integer> iterator01 = testArray01.iterator();
        int N = 10;
        for (int i =0; i < N; i += 1) {
            testArray01.addLast(i);
        }

        for (int j = 0; j < N; j += 1) {
            int item = testArray01.get(j);
            int iteratorNumber = iterator01.next();
            if (j < N-1) {
                assertTrue(iterator01.hasNext());
            }
            assertEquals(item,iteratorNumber);
        }
    }
}
