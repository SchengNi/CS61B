package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void simpleTest() {
        AListNoResizing<Integer> alist01 = new AListNoResizing<>();
        BuggyAList<Integer> blist01 = new BuggyAList<>();
        alist01.addLast(5);
        alist01.addLast(10);
        alist01.addLast(15);
        blist01.addLast(5);
        blist01.addLast(10);
        blist01.addLast(15);

        assertEquals(alist01.size(),blist01.size());

        assertEquals(alist01.removeLast(), blist01.removeLast());
        assertEquals(alist01.removeLast(), blist01.removeLast());
        assertEquals(alist01.removeLast(), blist01.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L1 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L1.addLast(randVal);
            } else if (L.size() != 0) {
                if (operationNumber == 1) {
                    // getLast
                    int Llast = L.getLast();
                    int L1last = L1.getLast();
                    assertEquals(Llast,L1last);
                } else if (operationNumber == 2) {
                    // removeLast
                    int Llast = L.removeLast();
                    int L1last = L1.removeLast();
                    assertEquals(Llast,L1last);
                }

            }
        }
    }
}
