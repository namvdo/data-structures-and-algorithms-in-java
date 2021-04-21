package linkedlist;

/***
 * The first node of this doubly linked list will be the header, then right after is the head, the last node of this node is the trailer, the node right before this node is the tail.
 * Adding or removing internal nodes will be implemented later.
 * @param <E>
 */
public class DoublyLinkedList <E>{
    private static class Node <E> { // nested class for creating new node
        private E element; // reference to the element stored in this node
        private Node<E> next; // reference to the next node
        private Node<E> prev; // reference to the previous node
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() { return element; } 
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    // instance variables for DoublyLinkedList
    private Node<E> header;  // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of nodes
    // constructs a new empty list
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() { // returns but not remove the head
        if(isEmpty()) return null;
        return header.getNext().getElement(); // first element is right after the header
    }
    public E last() { // returns but not remove the tail
        if(isEmpty()) return null;
        return trailer.getPrev().getElement(); // tail is right before the trailer
    }
    public void addFirst(E e){ // adds a node to the head of the list, before the header
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e){ // adds a node between the tail and the trailer
        addBetween(e, trailer.getPrev(), trailer);
    }
    public E removeFirst() {
        if(isEmpty()) return null; // if the list is empty, nothing to remove
        return remove(header.getNext()); // remove the head beyond the header
    }
    public E removeLast() {
        if(isEmpty()) return null;
        return remove(trailer.getPrev()); // remove the tail which is lied before the trailer
    }

    // private update methods
    /** Adds an element e to the linked list between the given nodes */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        // create and link a new node 
        Node<E> newest = new Node(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    /** Removes the given node in the list and returns its element */
    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor); // set the next node to the successor, which is the node after the node we want to remove
        successor.setPrev(predecessor); // set the previous node the the prdecessor, which is the node before the node we want to remove
        size--;
        return node.getElement();
    }
}