package queue;
import java.util.List;
interface Queue<E> {
    int size(); // size of the queue
    boolean isEmpty(); // checks whether the queue is empty
    void enqueue(E e); // adds element to the back of the queue
    E dequeue(); // removes and returns the first element of the queue
    E first(); // returns but not remove the first element`
}

public class LinkedQueue<E> implements Queue<E> {
    private List<E> list = new LinkedList<>(); // empty list
    public LinkedQueue() {}
    public int size() {  return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public void enqueue(E e) {
        list.add(e); // adds element to the end of the queue
    }
    public E dequeue() {
        return list.remove(0); // removes and returns the first element of the queue
    }
    public E first() {
        return list.get(0); // gets the first element of the queue but do not remove
    }
}
