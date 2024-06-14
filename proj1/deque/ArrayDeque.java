package deque;

import java.util.Iterator;


public class ArrayDeque<T> implements Deque<T>, Iterable<T>{
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

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        if (size == 0) {
            items[first] = item;
            size += 1;
        } else {
            first = (first - 1 + items.length) % items.length;
            items[first] = item;
            size += 1;
        }
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        if (size == 0) {
            items[last] = item;
            size += 1;
        } else {
            last = (last + 1 + items.length) % items.length;
            items[last] = item;
            size += 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int n) {
        T[] tem = (T[]) new Object[n];
        if (first > last) {
            System.arraycopy(items, first, tem, 0, items.length - first);
            System.arraycopy(items, 0, tem, items.length - first, last + 1);
        } else {
            System.arraycopy(items, first, tem, 0, size);
        }
        first = 0;
        last = size - 1;
        items = tem;
        itLen = n;
    }

    @Override
    public void printDeque() {
        int index = first;
        if (size != 0) {
            for (int i = 0; i < size; i += 1) {
                if (i == 0) {
                    index = index % itLen;
                    System.out.print(items[index]);
                    index += 1;
                } else {
                    index = index % itLen;
                    System.out.print(" " + items[index]);
                    index += 1;
                }
            }
            System.out.print("\n");
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T arrayElement = items[first];
        if (size == 1) {
            items[first] = null;
        } else {
            items[first] = null;
            first = (first + 1) % items.length;
        }
        size -= 1;
        arrayUsage();
        return arrayElement;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T arratElement = items[last];
        if (size == 1) {
            items[last] = null;
        } else {
            items[last] = null;
            last = (last - 1 +items.length) % items.length;
        }
        size -= 1;
        arrayUsage();
        return arratElement;
    }

    /**
     * Check the array usage.
     */
    private void arrayUsage() {
        if (itLen != 8) {
            double abs = Math.abs(size);
            double usage = abs / itLen;
            double usageNeed = 0.25;
            if (usage < usageNeed) {
                resize(itLen / 2);
                arrayUsage();
            }
        }
    }

    @Override
    public T get(int index) {
        int getIndex = 0;
        if (index > size - 1 ) {
            return null;
        }
        getIndex = (first + index) % items.length;
        return items[getIndex];
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> oa = (Deque<T>) o;
        if (this.size() != oa.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i += 1) {
            if (!(oa.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int IndexSize;

        public ArrayIterator() {
            IndexSize = 0;
        }

        public boolean hasNext() {
            return IndexSize < size;
        }

        public T next() {
            T returnItem = get(IndexSize);
            IndexSize += 1;
            return returnItem;
        }
    }
}