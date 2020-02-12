package stack;
interface Stack<E> {
    // number of elements in the stack.
    int size();

    // tests whether stack is empty
    boolean isEmpty();

    // pushes element to the top of the stack
    void push(E e);

    // returns the top element of the stack, but don't remove it
    E top();

    // removes the top element of the stack, and return this element.
    E pop();
}

public class LinkedStack<E> implements Stack<E> {
    public class SinglyLinkedList<E> {
        private class Node<E> { // private Node class for SinglyLinkedList
            private E element;
            private Node<E> next;

            public Node(E e, Node<E> n) {
                element = e;
                next = n;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> n) {
                next = n;
            }
        }

        private Node<E> head = null; // initially sets head, tail and size to null
        private Node<E> tail = null;
        private int size = 0;

        public SinglyLinkedList() {
        } // empty constructor
        // access methods

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E first() { // gets the first node, but not remove it
            if (isEmpty())
                return null;
            return head.getElement();
        }

        public E last() {
            if (isEmpty())
                return null;
            return tail.getElement();
        }

        public void addFirst(E e) { // adds a node to the head
            head = new Node<>(e, head); // adds element to the front of the list, reference to the old head
            if (size == 0)
                tail = head; // head becomes tail if size equals 0
            size++; // increases the size after adding
        }

        public void addLast(E e) {
            Node<E> newest = new Node<>(e, null);
            if (isEmpty())
                head = newest; // if the list is empty
            else {
                tail.setNext(newest); // set the next element of the old tail to the newest node
                tail = newest; // now tail is the newest node
            }
            size++; // increases the size
        }

        public E removeFirst() { // removes the first node and returns it
            if (isEmpty())
                return null;
            E answer = head.getElement();
            head = head.getNext(); // sets the head to the next current head node
            size--; // decreases the size
            if (size == 0) { // special case after decreasing the size, if size equals 0 then set tail to
                             // null
                tail = null;
            }
            return answer;
        }
    }

    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    public LinkedStack() {
    } // new stack relies on the intial empty list

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E top() {
        return list.first();
    }

    public E pop() {
        return list.removeFirst();
    }

}