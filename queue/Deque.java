package queue;
interface Deque <E> {
    int size(); // size of the queue
    boolean isEmpty(); // checks whether the queue is empty
    void addFirst(E e); // adds element to the front of the queue
    void addLast(E e); // adds element to the end of the queue
    E removeFirst(); // returns and removes the first element 
    E removeLast(); // returns and removes the last element
    E first(); // returns but not remove the first element
    E last(); // returns but not remove the last element
}
