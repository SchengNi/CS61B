package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
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

    @Override
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

    @Override
    public int size() {
        return size;
    }

    public void resize(int n) {
        T[] tem = (T[]) new Object[n];
        if (first > last) {
            System.arraycopy(items, first, tem, 0, itLen - first);
            System.arraycopy(items, 0, tem, last, last + 1);
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
                first = first + 1;
            }
            arrayUsage();
        }
        size -= 1;
        return arrayElement;
    }

    @Override
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
                last = last - 1;
            }
            arrayUsage();
        }
        size -= 1;
        return arratElement;
    }

    /**
     * Check the array usage.
     */
    private void arrayUsage() {
        if (itLen != 8) {
            double abs = Math.abs(first - last);
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
        T getItem;
        if (size == 0 || index > size - 1) {
            return null;
        } else {
            int relIndex = (first + index) % itLen;
            getItem = items[relIndex];
        }
        return getItem;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        } else {
            if (o instanceof ArrayDeque) {
                if (((ArrayDeque<?>) o).size() == size) {
                    for (int i = 0; i < size; i += 1) {
                        if (((ArrayDeque<?>) o).get(i) != get(i)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
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