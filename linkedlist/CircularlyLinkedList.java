package linkedlist;

public class CircularlyLinkedList <E> {
    private static class Node <E> { // nested Node class 
        private E element; // reference to the element stored in this node
        private Node<E> next; // referece to the subsequent node in this list
        public Node (E e, Node <E> n){ 
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }
    // instance variables of the CircularlyLinkedList
    private Node <E> tail = null; // in circularly linked list, we store tail reference, not head
    private int size = 0; // number of nodes in the list
    public CircularlyLinkedList () {} // empty constructor, contructs an initially empty list
    // access methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() { // returns but not remove the first element
        if(isEmpty()) return null;
        return tail.getNext().getElement(); // because head is after the tail, then return the next tail element
    }
    public E last() { // returns but not remove the last element
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void rotate(){ // rotate the first element to the back of the list
        if(tail != null){
            tail = tail.getNext(); 
        }
    }
    public void addFirst(E e) {
        if(size == 0){ // if list is empty, then set tail to itself
            tail = new Node(e, null);
            tail.setNext(tail);
        }else{ // if list is not empty
            Node<E> newest = new Node(e, tail.getNext());
            tail.setNext(newest);
        }
        size++; // increses the size;
    }
    public void addMany(E [] e){ // adds many elements to the list
        for(int i = 0; i < e.length; i++){
            addFirst(e[i]);
        }
    }
    public void addLast(E e){ // adds element e to the end of the list
        addFirst(e); // insert element to the front of the list
        tail = tail.getNext(); // now element become the tail
    }
    public E removeFirst() { // removes and returns the first element
        if(isEmpty()) return null; // nothing to remove
        Node<E> head = tail.getNext(); // gets the head element
        if(head == tail) tail = null; // only one node left
        else tail.setNext(head.getNext()); // removes head from the list 
        size--;
        return head.getElement(); // returns the element just has been removed
    }
}

class Main{
     public static void main(String []args){
        CircularlyLinkedList circularList = new CircularlyLinkedList<>(); // tested object
        System.out.println(circularList.size());
        Object[] numbers = { 1, 2, 3, 4, 5, 6 };
        circularList.addMany(numbers);
        System.out.println(circularList.first());
        System.out.println(circularList.last());
        System.out.println(circularList.size());
        circularList.rotate();
        System.out.println(circularList.removeFirst());
    }
}
