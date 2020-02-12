package queue;
interface Queue<E> {
    int size(); // size of the queue
    boolean isEmpty(); // checks whether the queue is empty
    void enqueue(E e); // adds element to the back of the queue
    E dequeue(); // removes and returns the first element of the queue
    E first(); // returns but not remove the first element`
}
/** implements the queue ADT with fixed array length */
public class ArrayQueue<E> implements Queue<E> {
    public final static int CAPACITY = 1000;
    private E[] data; // array that holds the queue
    private int f; // the index of the front element
    private int size; // current number of elements

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    /** adds element to the back of the queue */
    public void enqueue(E e) throws IllegalStateException {
        if(size == data.length) throw new IllegalStateException("Queue is full");
        int avail = (size + f) % data.length;  // uses modular arthmetic
        data[avail] = e;
        size++;
    }
    /** returns the element in the front of the queue but do not remove*/
    public E first() {
        if(isEmpty()) return null;
        return data[f];
    }
    /** returns and removes the front element of the queue */
    public E dequeue(){
        if(isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return answer;
    }
}