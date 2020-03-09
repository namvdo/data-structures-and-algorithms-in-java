import java.net.Socket;

class BST<T extends Comparable<T>> {
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
      }
      else if (value.compareTo(node.element) < 0) {
          node.left = insert(node.left, value);

      }
      else if (value.compareTo(node.element) > 0) {
          node.right = insert(node.right, value);
      }
      else if (value.compareTo(node.element) == 0) {
          return null;
      }
      return node;

  }

  public void add(T value) {
      root = insert(root, value);
      nodeCount++;
  }

  /** Our work is here, the in-order traversal method in BST. */
  private void inOrder(Node node) {
      if (node != null) {
          inOrder(node.left);
          System.out.println(node.element);
          inOrder(node.right);
      }

  }
  /** method with no parameter */
  public void inOrderTraversal() {
      inOrder(root);
  }
  /** Test in-order traversal */
  public static void main(String[] args){
    BST tree = new BST();
    tree.add(24);
    tree.add(14);
    tree.add(12);
    tree.add(8);
    tree.add(17);
    tree.add(26);
    tree.add(25);
    tree.add(32);
    tree.inOrderTraversal();
    /** Output: 8, 12, 14, 17, 24, 25, 26, 32 */
  }


}