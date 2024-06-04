package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesExample01() {
        IntList lst =IntList.of(3, 5, 7, 9 ,11);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("9 -> 25 -> 49 -> 9 -> 121", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesExample02() {
        IntList lst =IntList.of(20, 21, 22, 23 ,24);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("20 -> 21 -> 22 -> 529 -> 24", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesExample03() {
        IntList lst =IntList.of(29, 31, 37, 41 ,43);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("841 -> 961 -> 1369 -> 1681 -> 1849", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesExample04() {
        IntList lst =IntList.of(62, 63, 64, 65 ,66);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("62 -> 63 -> 64 -> 65 -> 66", lst.toString());
        assertFalse(changed);
    }
}
