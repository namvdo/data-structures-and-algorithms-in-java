public class BST<T extends Comparable<T>> {
    private Node root = null;
    private int nodeCount = 0;

    private class Node {
        T element;
        Node left, right;

        public Node(Node left, Node right, T element) {
            this.left = left;
            this.right = right;
            this.element = element;
        }
    }
    /**
     * 
     * @return true if the tree is empty
     */
    public boolean isEmpty() {
        return nodeCount == 0;
    }

    /**
     * inserts element to the BST
     * @param node - starting node, the root
     * @param value - value to be inserted
     * @return the tree after insertion
     */
    private Node insert(Node node, T value) {
        /** We found the leaf node here, then insert the value to this position. */
        if (node == null) {
            node = new Node(null, null, value);
        }
        /**
         * If the value we pass in is less than the current node's value, then we go to
         * the left.
         */
        else if (value.compareTo(node.element) < 0) {
            node.left = insert(node.left, value);

        }
        /**
         * If the value we pass in is greater than the current node's value, then we go
         * to the right.
         */
        else if (value.compareTo(node.element) > 0) {
            node.right = insert(node.right, value);
        }
        /** If the value we pass in already exists in the tree, we return null. */
        else if (value.compareTo(node.element) == 0) {
            return null;
        }
        /** Finally return the node after finishing insertion */
        return node;

    }

    /**
     * public method to add new node to the tree
     * @param value - the value to be added to the tree
     */
    public void add(T value) {
        root = insert(root, value);
        nodeCount++;
    }
    /**
     * prints the tree in the in-order order.
     * @param node - starting node
     */
    public void display(Node node) {
        if (node != null) {
            /** recursively calls display method on the left sub-tree */
            display(node.left);
            /** prints the value at the current node */
            System.out.println("The current node value is " + node.element);
            /** recursively calls display method for the right subtree. */
            display(node.right);
        }

    }

    /**
     * checks whether the tree contains a specific value
     * @param node - starting node to search
     * @param value - a value that to be looked for 
     * @return true if this value exists in the tree, false otherwise.
     */
    private boolean contains(Node node, T value) {
        /** returns false if we cannot find the value in the tree. */
        if (node == null)
            return false;
        /** if two values are equal, found it! And returns true. */
        if (value.compareTo(node.element) == 0) {
            return true;
        }
        /** Otherwise, recursively go back or right to search for the value. */
        return value.compareTo(node.element) < 0 ? contains(node.left, value) : contains(node.right, value);

    }
    public boolean containValue(T value) {
        return contains(root, value);
    }
    /**
     * finds the smallest node of the tree
     * @param node
     * @return the node type T has the smallest value
     */
    /** goes with one direction to the left to the smallest value. */
    public T smallest(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }

    /**
     * finds the largest node of the tree
     * @param node
     * @return the node type T has the largest value
     */
    /** goes to the right most to find the largest one. */
    public T largest(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.element;
    }

}