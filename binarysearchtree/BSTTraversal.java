package binarysearchtree;

class BSTTraversal<T extends Comparable<T>> {
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

    /** Utility method for adding element to the BST. */
    private Node insert(Node node, T value) {
        if (node == null) {
            node = new Node(null, null, value);
        } else if (value.compareTo(node.element) < 0) {
            node.left = insert(node.left, value);

        } else if (value.compareTo(node.element) > 0) {
            node.right = insert(node.right, value);
        } else if (value.compareTo(node.element) == 0) {
            return null;
        }
        return node;

    }

    public void add(T value) {
        root = insert(root, value);
        nodeCount++;
    }

    /**
     * In-order traversal 
     * 
     * recursively explores the left subtree 
     * visits the node
     * recursive explores the right subtree
     * 
     * @param node - starting node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.element + " ");
            inOrder(node.right);
        }

    }

    /** A method with no parameter for testing inOrder method */
    public void inOrderTraversal() {
        inOrder(root);
    }

    /**
     * Pre-order traversal 
     * 
     * visits the node
     * recursively explores the left subtree 
     * recursive explores the right subtree
     * 
     * @param node - starting node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.element + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    /** A method with no parameter for testing preOrder method */
    public void preOrderTraversal() {
        preOrder(root);
    }

    /**
     * Post-order traversal 
     * 
     * recursively explores the left subtree 
     * recursive explores the right subtree
     * visits the node
     * 
     * @param node - starting node
     */
    private void postOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.print(node.element + " ");
        }

    }

    /** A method with no parameter for testing postOrder method */
    public void postOrderTraversal() {
        postOrder(root);
    }


}
