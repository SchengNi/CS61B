package deque;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {

    @Test
    public void isEmptyTest() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        MaxArrayDeque<Integer> test01 = new MaxArrayDeque<>(cmp);
        int N = 15;
        int getItem;

        assertEquals(null,test01.max());

        for (int i = 0; i < N; i += 1) {
            test01.addLast(i);
            test01.removeLast();
        }

        assertEquals(null,test01.max());
    }

    @Test
    public void integerTest() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        MaxArrayDeque<Integer> test01 = new MaxArrayDeque<>(cmp);
        int N = 15;
        int getItem;

        for (int i = 0; i < N; i += 1) {
            test01.addLast(i);
        }
        getItem = test01.max();
        assertEquals(14,getItem);
    }

    @Test
    public void stringTest() {
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Comparator<String> cmp1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        MaxArrayDeque<String> test01 = new MaxArrayDeque<>(cmp);
        String getItem;

        test01.addLast("I");
        test01.addLast("am");
        test01.addLast("a");
        test01.addLast("student");
        test01.addLast("(NUMBER: 110120119)");

        getItem = test01.max();
        assertEquals("(NUMBER: 110120119)", getItem);

        getItem = test01.max(cmp1);
        assertEquals("student", getItem);
    }
}
