package flawed;

/**
 * a class that implements a binary search tree.
 */
public class BST {
  // the root Node of the BST
  private Node root;

  /**
   * Constructs an empty BST.
   */
  public BST() {
    root = null;
  }

  /**
   * a class that implements a node in a binary search tree.
   */
  public static class Node {
    // the data in the Node
    public int key;
    // the left child of the Node
    public Node left;
    // the right child of the Node
    public Node right;

    /**
     * Constructs a Node with the given key.
     *
     * @param key the key of the Node
     */
    public Node(int key) {
      this.key = key;
      left = null;
      right = null;
    }
  }

  /**
   * Inserts a new key into the BST.
   *
   * @param key the key to insert
   */
  public void insert(int key) {
    root = insertHelper(root, key);
  }

  /**
   * Helper method for insert().
   *
   * @param node the current node
   * @param key  the key to insert
   * @return the new root of the BST
   */
  private Node insertHelper(Node node, int key) {
    if (key < node.key) {
      node.left = insertHelper(node.left, key);
    } else if (key > node.key) {
      node.right = insertHelper(node.right, key);
    }
    return node;
  }

  /**
   * a method the deletes a key from the BST.
   *
   * @param key the key to delete
   */
  public void delete(int key) {
    root = deleteHelper(root, key);
  }

  /**
   * a helper method for delete() which returns the minimum key in a Node.
   *
   * @param node the node to find the minimum key in
   * @return the minimum key in the Node
   */
  private int minValue(Node node) {
    Node current = node;
    while (current.left != null) {
      current = current.left;
    }
    return current.key;
  }

  /**
   * a helper method for delete() which deletes a key from the BST.
   *
   * @param node the node to delete the key from
   * @param key  the key to delete
   * @return the node with the key deleted
   */
  private Node deleteHelper(Node node, int key) {
    if (node == null) {
      return null;
    }
    if (key < node.key) {
      node.left = deleteHelper(node.left, key);
    } else if (key > node.key) {
      node.right = deleteHelper(node.right, key);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      } else {
        node.key = minValue(node.left);
        node.right = deleteHelper(node.right, node.key);
      }
    }
    return node;
  }

  /**
   * a method that validates a BST.
   *
   * @param tree the BST to validate
   * @return true if the BST is valid, false otherwise
   */
  public static boolean validateBST(BST tree) {
    return validateBSTHelper(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   * a helper method for validateBST() which validates a BST.
   *
   * @param node the current node
   * @param min  the minimum value
   * @param max  the maximum value
   * @return true if the BST is valid, false otherwise
   */
  private static boolean validateBSTHelper(Node node, int min, int max) {
    if (node == null) {
      return true;
    }
    if (node.key < min || node.key > max) {
      return false;
    }
    return validateBSTHelper(node.left, min, node.key)
        && validateBSTHelper(node.right, node.key, max);
  }

  /**
   * a method that searches for a key in the BST.
   *
   * @param key  the key to search for
   * @return true if the key is in the BST, false otherwise
   */
  public boolean search(int key) {
    return searchHelper(this.root, key);
  }

  /**
   * a helper method for search() which searches for a key in the BST.
   *
   * @param node the current node
   * @param key  the key to search for
   * @return true if the key is in the BST, false otherwise
   */
  private boolean searchHelper(Node node, int key) {
    if (node == null) {
      return false;
    }
    if (node.key == key) {
      return true;
    }
    if (key < node.key) {
      return searchHelper(node.left, key);
    } else {
      return searchHelper(node.right, key);
    }
  }

}
