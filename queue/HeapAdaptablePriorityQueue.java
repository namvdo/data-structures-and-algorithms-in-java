package queue;

import java.util.Comparator;

public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V>{
    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        private int index;
        public AdaptablePQEntry(K k, V v, int j) {
            super(k, v);
            this.index = j;
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int j) {
            this.index = j;
        }

    }

    public HeapAdaptablePriorityQueue() {
        super();
    }

    public HeapAdaptablePriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    public AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
        if (!(entry instanceof AdaptablePQEntry)) {
            throw new IllegalArgumentException("Invalid entry.");
        }
        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry;
        int idx = locator.getIndex();
        if (idx >= heap.size() || heap.get(idx) != locator) {
            throw new IllegalArgumentException("Invalid entry");
        }
        return locator;
    }

    protected void swap(int i, int j) {
        super.swap(i, j);
        ((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j);
    }

    protected void bubble(int j) {
        if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0) {
            upHeap(j);
        } else {
            downHeap(j);
        }
    }

    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException{
        checkKey(key);
        Entry<K, V> entry = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(entry);
        upHeap(heap.size() - 1);
        return entry;
    }

    public void remove(Entry<K, V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        int idx = locator.getIndex();
        if (idx == heap.size() - 1) {
            heap.remove(idx);
        } else {
            swap(idx, heap.size() - 1);
            heap.remove(heap.size() - 1);
            bubble(idx);
        }
    }

    public void replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        checkKey(key);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    public void replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        locator.setValue(value);
    }


}
