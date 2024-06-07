package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int itLen;
    private int first;
    private int last;

    /**
     * inner array.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        itLen = items.length;
        size = 0;
        first = 0;
        last = 0;
    }

    public void addFirst(T item) {
        if (size == 0) {
            items[first] = item;
            size += 1;
        } else {
            if (size < itLen) {
                if (first == 0) {
                    items[itLen - 1] = item;
                    first = itLen - 1;
                } else {
                    items[first - 1] = item;
                    first = first - 1;
                }
                size += 1;
            } else {
                resize(2 * itLen);
                addFirst(item);
            }
        }
    }

    public void addLast(T item) {
        if (size == 0) {
            items[last] = item;
            size += 1;
        } else {
            if (size < itLen) {
                if (last == itLen - 1) {
                    items[0] = item;
                    last = 0;
                } else {
                    items[last + 1] = item;
                    last = last + 1;
                }
                size += 1;
            } else {
                resize(2 * itLen);
                addLast(item);
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int n) {
        T[] tem = (T[]) new Object[n];
        System.arraycopy(items, 0 ,tem, 0, size);
        items = tem;
    }

    public void printDeque() {
        for (int i = Math.max(first, last); i <= Math.min(first, last); i += 1) {
            System.out.print(items[i] + " ");
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        T arrayElement = items[first];
        if (size == 0) {
            return null;
        } else if (size == 1) {
            items[first] = null;
        } else {
            if (first == itLen - 1) {
                items[itLen - 1] = null;
                first = 0;
            } else {
                items[first] = null;
                first = first - 1;
            }
            arrayUsage();
        }
        size -= 1;
        return arrayElement;
    }

    public T removeLast() {
        T arratElement = items[last];
        if (size == 0) {
            return null;
        } else if (size == 1) {
            items[last] = null;
        } else {
            if (last == 0) {
                items[0] = null;
                last = itLen - 1;
            } else {
                items[last] = null;
                last = last + 1;
            }
            arrayUsage();
        }
        size -= 1;
        return arratElement;
    }

    /** Check the array usage. */
    public void arrayUsage() {
        if (itLen != 8){
            double abs = Math.abs(first - last);
            double usage = abs / itLen;
            double usageNeed = 0.25;
            if (usage < usageNeed) {
                resize(itLen / 2);
                arrayUsage();
            }
        }
    }

    public T get(int index) {
        T getItem;
        int abs = Math.abs(first - last);
        if (size == 0 || index > size - 1) {
            return  null;
        } else {
            int relIndex = (first + index) % itLen;
            getItem = items[relIndex];
        }
        return getItem;
    }
}