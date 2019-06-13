package priorityqueues;

public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K, V> {

    void remove(Entry<K, V> e) throws IllegalArgumentException;

    void replaceKey(Entry<K, V> e, K key) throws IllegalArgumentException;

    void replaceValue(Entry<K, V> e, V value) throws IllegalArgumentException;

}
