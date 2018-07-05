package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.BinarySearchTree.TraversalType;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FindSuccessorTest {

  @Test
  public void findSuccessor() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    List<Integer> inOrderTraversalResults = tree.traverse(TraversalType.DEPTH_FIRST_INORDER);
    for (int i = 0; i < inOrderTraversalResults.size() - 1; i++) {
      Assert.assertEquals(inOrderTraversalResults.get(i + 1),
          tree.findSuccessor(inOrderTraversalResults.get(i)));
    }
    Assert.assertNull(
        tree.findSuccessor(inOrderTraversalResults.get(inOrderTraversalResults.size() - 1)));

  }

  @Test
  public void findSuccessorHardCodedTest() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    Assert.assertEquals(50, tree.findSuccessor(25).intValue());
    Assert.assertEquals(60, tree.findSuccessor(50).intValue());
    Assert.assertEquals(80, tree.findSuccessor(75).intValue());
    Assert.assertEquals(75, tree.findSuccessor(60).intValue());
    Assert.assertEquals(100, tree.findSuccessor(80).intValue());
    Assert.assertEquals(150, tree.findSuccessor(100).intValue());
    Assert.assertEquals(250, tree.findSuccessor(200).intValue());
    Assert.assertEquals(200, tree.findSuccessor(150).intValue());
    Assert.assertEquals(300, tree.findSuccessor(250).intValue());
    Assert.assertNull(tree.findSuccessor(300));

  }
}
