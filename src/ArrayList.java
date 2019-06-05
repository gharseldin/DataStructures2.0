public class ArrayList<E> implements List<E> {

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    // constructors
    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length)
            resize();
        for (int j = size - 1; j >= i; j--)
            data[j + 1] = data[j];
        data[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int j = i; j < size - 1; j++)
            data[j] = data[j + 1];
        data[size - 1] = null;
        size--;
        return temp;
    }

    private void checkIndex(int i, int size) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
    }

    protected void resize() {
        E[] temp = (E[]) new Object[2 * data.length];
        for (int i = 0; i < size; i++)
            temp[i] = data[i];
        data = temp;
    }

}
