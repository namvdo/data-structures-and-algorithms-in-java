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

    public boolean isEmpty() {
        return nodeCount == 0;
    }

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

    public void add(T value) {
        root = insert(root, value);
        nodeCount++;
    }

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

    /** goes with one direction to the left to the smallest value. */
    public T smallest(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }

    /** goes to the right most to find the largest one. */
    public T largest(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.element;
    }

    public static void main(String[] args) {
        BST binarySearhTree = new BST();
        binarySearhTree.add(12);
        binarySearhTree.add(4);
        binarySearhTree.add(13);
        binarySearhTree.add(7);
        binarySearhTree.add(28);
        binarySearhTree.add(72);
        binarySearhTree.add(1);
        System.out.println("Is 12 in the tree? " + binarySearhTree.containValue(12));
        System.out.println("Is 47 in the tree? " + binarySearhTree.containValue(47));
        binarySearhTree.display(binarySearhTree.root);
        System.out.println("The smallest value in the tree is: " + binarySearhTree.smallest(binarySearhTree.root));
        System.out.println("The largest value in the tree is: " + binarySearhTree.largest(binarySearhTree.root));

    }
}
