package listiterators;

public interface PositionalList<E> {

    Position<E> first();

    Position<E> last();

    Position<E> before(Position p) throws IllegalArgumentException;

    Position<E> after(Position p) throws IllegalArgumentException;

    boolean isEmpty();

    int size();

    Position<E> addFirst(E e);

    Position<E> addLast(E e);

    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    E set(Position<E> p, E e) throws IllegalArgumentException;

    E remove(Position<E> p) throws IllegalArgumentException;

    Iterable<Position<E>> positions();
}
