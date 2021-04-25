package queue;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface Entry<K, V> {
    K getKey();
    V getValue();
}

interface PriorityQueue<K, V> {
    int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;
    Entry<K, V> min();
    Entry<K, V> removeMin();
}

class DefaultComparator<E> implements Comparator<E> {

    @Override
    @SuppressWarnings("unchecked")
    public int compare(E o1, E o2) {
        return ((Comparable<E>) o1).compareTo(o2);
    }
}

abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    public static class PQEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;

        public PQEntry(K key, V val) {
            this.k = key;
            this.v = val;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        protected void setKey(K key) {
            this.k = key;
        }

        protected void setValue(V val) {
            this.v = val;
        }
    }

    private final Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> c) {
        this.comp = c;
    }

    protected AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return comp.compare(key, key) == 0;
        } catch (ClassCastException e) {
            throw e;
        }
    }
}

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected final List<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upHeap(int j) {
        while (j > 0) {
            int parent = parent(j);
            if (compare(heap.get(j), heap.get(parent)) >= 0) break;
            swap(parent, j);
            j = parent;
        }
    }

    protected void downHeap(int j) {
        while(hasLeft(j)) {
            int leftIdx = left(j);
            int smallerChildIdx = leftIdx;
            int rightIdx = right(j);
            if (compare(heap.get(leftIdx), heap.get(rightIdx)) > 0) {
                smallerChildIdx = rightIdx;
            }
            if (compare(heap.get(smallerChildIdx), heap.get(j)) > 0) {
                break;
            }
            swap(smallerChildIdx, j);
            j = smallerChildIdx;
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newEntry = new PQEntry<>(key, value);
        heap.add(newEntry);
        upHeap(heap.size() - 1);
        return newEntry;
    }

    @Override
    public Entry<K, V> min() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) return null;
        Entry<K, V> min = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(min);
        downHeap(0);
        return min;
    }

}
