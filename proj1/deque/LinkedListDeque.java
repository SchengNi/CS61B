package deque;

public class LinkedListDeque<T> {
    public class Node {
        /** inner class Node. */
        private T item;
        private Node pre;
        private Node next;

        /** sentinel Node */
        public Node(Node ppre, Node nnext) {
            pre = ppre;
            next = nnext;
        }
        /** normal Node */
        public Node(T n, Node ppre, Node nnext) {
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

    public void addFirst(T item) {
        Node newitem = new Node(item, firstsentinel, firstsentinel.next);
        firstsentinel.next.pre = newitem;
        firstsentinel.next = newitem;
        size += 1;
    }

    public void addLast(T item) {
        Node newitem = new Node(item, lastsentinel.pre, lastsentinel);
        lastsentinel.pre.next = newitem;
        lastsentinel.pre = newitem;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node temp = firstsentinel.next;
        if (temp != lastsentinel) {
            System.out.print(temp.item + " ");
        } else {
            System.out.print('\n');
        }
    }

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
}