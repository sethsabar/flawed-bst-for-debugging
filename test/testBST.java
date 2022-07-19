import flawed.BST;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testBST {

  @Test
  public void testInsertSimple() {
    BST tree = new BST();
    tree.insert(1);
    assertTrue(tree.search(1));
  }

}
