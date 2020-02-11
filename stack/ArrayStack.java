public interface Stack<E> {
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

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000; // default capacity
    private E[] data; // generic array used for storage
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY); // constructs stack with default capacity
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity]; // cast to E[] for safe, the compiler may give warning
    }

    public int size() {
        return t + 1; // returns the size of the stack
    }

    public boolean isEmpty() {
        return (t == -1);
    } // checks if stack is empty

    public void push(E e) throws IllegalStateException {
        if (size() == data.length)
            throw new IllegalStateException("Stack is full");
        data[++t] = e; // increases t before storing new item
    }

    public E top() { // gets the top element without removing
        if (isEmpty())
            return null;
        return data[t];
    }

    public E pop() { // removes and return the top element
        if (isEmpty())
            return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>(); // contents: ()
        S.push(5); // contents: (5)
        S.push(3); // contents: (5, 3)
        System.out.println(S.size()); // contents: (5, 3) outputs 2
        System.out.println(S.pop()); // contents: (5) outputs 3
        System.out.println(S.isEmpty()); // contents: (5) outputs false
        System.out.println(S.pop()); // contents: () outputs 5
        System.out.println(S.isEmpty()); // contents: () outputs true
        System.out.println(S.pop()); // contents: () outputs null
        S.push(7); // contents: (7)
        S.push(9); // contents: (7, 9)
        System.out.println(S.top()); // contents: (7, 9) outputs 9
        S.push(4); // contents: (7, 9, 4)
        System.out.println(S.size()); // contents: (7, 9, 4) outputs 3
        System.out.println(S.pop()); // contents: (7, 9) outputs 4
        S.push(6); // contents: (7, 9, 6)
        S.push(8); // contents: (7, 9, 6, 8)
        System.out.println(S.pop()); // contents: (7, 9, 6) outputs 8
    }
}