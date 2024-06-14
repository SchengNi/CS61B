package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comp = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        } else {
            T maxItem = this.get(0);
            for (int i = 0; i < this.size(); i += 1) {
                T getItem = this.get(i);
                if (comp.compare(maxItem,getItem) < 0) {
                    maxItem = getItem;
                }
            }
            return maxItem;
        }
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        } else {
            T maxItem = this.get(0);
            for (int i = 0; i < this.size(); i += 1) {
                T getItem = this.get(i);
                if (c.compare(maxItem,getItem)< 0) {
                    maxItem = getItem;
                }
            }
            return maxItem;
        }
    }
}
