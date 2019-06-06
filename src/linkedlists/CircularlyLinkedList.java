package linkedlists;

public class CircularlyLinkedList<E> implements LinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.next = tail;
        } else {
            tail.next = new Node<>(e, tail.getNext());
        }
        size++;
    }

    public void addLast(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.next = tail;
        } else {
            tail.next = new Node<>(e, tail.getNext());
            tail = tail.next;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        E temp = tail.getNext().getElement();
        size--;
        if (isEmpty())
            tail = null;
        else {
            tail.next = tail.getNext().getNext();
        }
        return temp;
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }
}
