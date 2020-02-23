package list;
interface List<E> {
    /** Returns number of elements in the list */
    int size();
    /** Checks whether the list is empty or not */
    boolean isEmpty();
    /** Gets the element at the ith index, throws exception of index out of bounds */
    E get(int i) throws IndexOutOfBoundsException;
    /** Sets element at index i to the new element e */
    E set(int i, E e) throws IndexOutOfBoundsException;
    /** Adds element at the ith index*/
    void add(int i, E e) throws IndexOutOfBoundsException;
    /** Removes element at index i */
    E remove(int i) throws IndexOutOfBoundsException;

}

public class ArrayList<E> implements List<E>{
    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    /** Default constructor */
    public ArrayList() {
        this(CAPACITY);
    }
    /**
     * Constructor with capacity paramater
     * @param capacity
     */
    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }

    /** Utility method
     * checks whether the index is not permitted, the first argument is the index, second argument is the size of the array
     * @param i
     * @param n
     * @throws IndexOutOfBoundsException
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i < 0 || i >= n){
            throw new IndexOutOfBoundsException("Illegal index " + i);
        }
    }
    /**
     * returns the size of the array
     */
    public int size() {
        return size;
    }

    /**
     * checks if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * gets element at index i
     */
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }
    /**
     * sets value at index i to the new value, returns the replaced value
     */
    public E set(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        E temp = data[i];
        this.data[i] = e;
        return temp;
    }

    /**
     * adds element to array at index i, shifting all of the rest elements to the right
     */
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException{
        checkIndex(i, size + 1);
        if(size == data.length){
            throw new IllegalStateException("Array is full");
        }
        for(int j = data.length - 1; j >= i; j--){
            data[j] = data[j - 1];
        }
        data[i] = e;
        size++;
    }

    /**
     * removes and returns element at index i, shifting all element from this index to the left
     */
    public E remove(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        E temp = data[i];
        for(int k = i; k < size - 1; k++){
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }
}


