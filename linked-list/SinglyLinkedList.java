public class SinglyLinkedList<E> {
    private static class Node <E> { // private Node class for SinglyLinkedList
        private E element; 
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }
    private Node<E> head = null; // initially sets head, tail and size to null
    private Node<E> tail = null; 
    private int size = 0;
    public SinglyLinkedList() {} // empty constructor
    // access methods
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() { // gets the first node, but not remove it
        if(isEmpty()) return null;
        return head.getElement();
    }
    public E last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E e){ // adds a node to the head
        head = new Node<>(e, head); // adds element to the front of the list, reference to the old head
        if(size == 0) tail = head; // head becomes tail if size equals 0
        size++; // increases the size after adding
    }
    public void addLast(E e){
        Node <E> newest = new Node<>(e, null); 
        if(isEmpty()) head = newest; // if the list is empty
        else{
            tail.setNext(newest); // set the next element of the old tail to the newest node
            tail = newest; // now tail is the newest node
        }
        size++; // increases the size
    }
    public E removeFirst() { // removes the first node and returns it
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext(); // sets the head to the next current head node
        size--; // decreases the size
        if(size == 0){ // special case after decreasing the size, if size equals 0 then set tail to null
            tail = null;
        }
        return answer;
    }
    public static void main(String[] args){
        SinglyLinkedList singlyList = new SinglyLinkedList(); // tested object
        singlyList.addFirst(2);
        singlyList.addFirst(3);
        singlyList.addFirst(4);
        singlyList.addFirst(5);
        singlyList.addFirst(6);
        System.out.println("The first node of this lis is " + singlyList.first());
        System.out.println("The last node of this list is " + singlyList.last());
        System.out.println("This list is empty? " + singlyList.isEmpty());
        System.out.println("The size of this list is " + singlyList.size());
        System.out.println("Remove the first element of the list " + singlyList.removeFirst());
    }
}