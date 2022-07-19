import flawed.BST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testBST {

  @Test
  public void testInsertSimple() {
    BST tree = new BST();
    tree.insert(1);
    assertTrue(tree.search(1));
  }

  @Test
  public void testInsert() {
    BST tree = new BST();
    tree.insert(1);
    tree.insert(4);
    tree.insert(2);
    tree.insert(5);
    tree.insert(3);
    assertTrue(tree.search(1));
    assertTrue(tree.search(2));
    assertTrue(tree.search(3));
    assertTrue(tree.search(4));
    assertTrue(tree.search(5));
    assertTrue(BST.validateBST(tree));
  }

  @Test
  public void testDelete() {
    BST tree = new BST();
    tree.insert(1);
    tree.insert(4);
    tree.insert(2);
    tree.insert(5);
    tree.insert(3);
    tree.delete(4);
    assertTrue(tree.search(1));
    assertTrue(tree.search(2));
    assertTrue(tree.search(3));
    assertTrue(tree.search(5));
    assertTrue(BST.validateBST(tree));
  }

}
