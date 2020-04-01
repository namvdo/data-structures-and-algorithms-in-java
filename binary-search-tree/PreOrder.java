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
  private void preOrder(Node node) {
      if(node == null){
          return;
      }
      System.out.println("Currently visit the node: " + node.element);
      preOrder(node.left);
      preOrder(node.right);

  }
  /** method with no parameter */
  public void preOrderTraversal() {
      preOrder(root);
  }
  /** Test pre-order traversal */
  public static void main(String[] args){
    BST tree = new BST();
    tree.add(7);
    tree.add(2);
    tree.add(6);
    tree.add(3);
    tree.add(9);
    tree.add(14);
    tree.preOrderTraversal();
  }


}
