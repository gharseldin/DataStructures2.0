package linkedlists;

public class DoublyLinkedList<E> implements LinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> n, Node<E> p) {
            element = e;
            next = n;
            prev = p;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }
    }

    private int size = 0;
    private Node<E> header;
    private Node<E> trailer;

    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, null, header);
        header.next = trailer;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if(!isEmpty())
            return header.next.getElement();
        return null;
    }

    @Override
    public E last() {
        if(!isEmpty())
            return trailer.prev.getElement();
        return null;
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    @Override
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public E removeFirst() {
        if(isEmpty())
            return null;
        E temp = header.getNext().getElement();
        header.next = header.getNext().getNext();
        header.getNext().prev = header;
        size--;
        return temp;
    }

    public E removeLast() {
        if(isEmpty())
            return null;
        E temp = trailer.getPrev().getElement();
        trailer.prev = trailer.getPrev().getPrev();
        trailer.getPrev().next = trailer;
        size--;
        return temp;
    }

    private void addBetween(E e, Node<E> prev, Node<E> next){
        Node<E> newest = new Node<>(e, prev, next);
        prev.next = newest;
        next.prev = newest;
        size++;
    }
}
