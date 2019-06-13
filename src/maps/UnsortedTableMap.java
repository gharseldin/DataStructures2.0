package maps;


import priorityqueues.Entry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {
    }

    private int findIndex(K key) {
        int n = table.size();
        for (int i = 0; i < n; i++)
            if (table.get(i).getKey().equals(key))
                return i;
        return -1;
    }

    public int size() {
        return table.size();
    }

    public boolean isEmpty(){
        return table.isEmpty();
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index == -1)
            return null;
        return table.get(index).getValue();
    }

    public V put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            V old = table.get(index).getValue();
            table.set(index, new MapEntry<>(key, value));
            return old;
        } else {
            table.add(new MapEntry<>(key, value));
            return null;
        }
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        if (index == -1)
            return null;
        V old = table.get(index).getValue();
        MapEntry<K, V> last = table.get(table.size() - 1);
        table.set(index, last);
        table.set(table.size() - 1, null);
        return old;
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int j = 0;

        public boolean hasNext() {
            return j < table.size();
        }

        public Entry<K, V> next() {
            if (j == table.size())
                throw new NoSuchElementException();
            else
                return table.get(j++);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class EntryIterable implements Iterable<Entry<K, V>> {
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
