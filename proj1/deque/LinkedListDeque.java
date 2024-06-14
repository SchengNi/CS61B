package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        /** inner class Node. */
        private T item;
        private Node pre;
        private Node next;

        /** sentinel Node */
        private Node(Node ppre, Node nnext) {
            pre = ppre;
            next = nnext;
        }
        /** normal Node */
        private Node(T n, Node ppre, Node nnext) {
            item = n;
            pre = ppre;
            next = nnext;
        }
    }

    /** size of Node. */
    private int size;

    /** sentinel Node. */
    private Node firstsentinel;
    private Node lastsentinel;

    public LinkedListDeque() {
        firstsentinel = new Node(null, null);
        lastsentinel = new Node(null, null);
        firstsentinel.next = lastsentinel;
        lastsentinel.pre =  firstsentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node newitem = new Node(item, firstsentinel, firstsentinel.next);
        firstsentinel.next.pre = newitem;
        firstsentinel.next = newitem;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node newitem = new Node(item, lastsentinel.pre, lastsentinel);
        lastsentinel.pre.next = newitem;
        lastsentinel.pre = newitem;
        size += 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node temp = firstsentinel.next;
        if (size != 0) {
            for (int i = 0; i < size; i += 1){
                if (i == 0) {
                    System.out.print(temp.item);
                    temp = temp.next;
                } else {
                    System.out.print(" " + temp.item);
                    temp = temp.next;
                }
            }
            System.out.print('\n');
        }
    }

    @Override
    public T removeFirst() {
        if (firstsentinel.next != lastsentinel) {
            T removefirst = firstsentinel.next.item;
            firstsentinel.next = firstsentinel.next.next;
            firstsentinel.next.pre = firstsentinel;
            size -= 1;
            return removefirst;
        } else {
            return null;
        }
    }

    @Override
    public T removeLast() {
        if (lastsentinel.pre != firstsentinel) {
            T removelast = lastsentinel.pre.item;
            lastsentinel.pre = lastsentinel.pre.pre;
            lastsentinel.pre.next = lastsentinel;
            size -= 1;
            return removelast;
        } else {
            return null;
        }
    }

    @Override
    public T get(int index) {
        Node tem = firstsentinel.next;
        for (int i = index; i != 0; i -= 1) {
            if (tem.next != lastsentinel) {
                tem = tem.next;
                index -= 1;
            } else {
                return null;
            }
        }
        return tem.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, firstsentinel.next);
    }

    /** getRecuisive's Helper method*/
    private T getRecursiveHelper(int index,Node node) {
        if (node == lastsentinel) {
            return null;
        } else if (index == 0) {
            return node.item;
        } else {
            return getRecursiveHelper(index - 1, node.next);
        }
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (! (o instanceof LinkedListDeque)) {
            return false;
        }
        if (this.size() != ((LinkedListDeque<?>) o).size()) {
            return false;
        }
        for (int i =0; i < this.size(); i += 1) {
            T thisItem = this.get(i);
            Object otherItem = ((LinkedListDeque<?>) o).get(i);
            if (thisItem == null && otherItem != null) {
                return false;
            }
            if (thisItem != null && !thisItem.equals(otherItem)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new LinkIterator();
    }

    public class LinkIterator implements Iterator<T> {
        private int IndexSize;
        public LinkIterator() {
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