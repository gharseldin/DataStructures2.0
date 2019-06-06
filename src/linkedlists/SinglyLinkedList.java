package linkedlists;

public class SinglyLinkedList<E> implements LinkedList<E> {

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

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

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
        return head.getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty())
            tail = head;
        size++;
    }

    public void addLast(E e) {

        if (isEmpty()) {
            tail = new Node<>(e, null);
            head = tail;
        } else {
            tail.next = new Node<>(e, null);
            tail = tail.next;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty())
            return null;
        E temp = first();
        head = head.next;
        if (isEmpty())
            tail = null;
        size--;
        return temp;
    }
}
