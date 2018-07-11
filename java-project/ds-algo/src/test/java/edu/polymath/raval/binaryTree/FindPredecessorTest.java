package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.TraversalUtility.TraversalType;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class FindPredecessorTest {

  @Test
  public void findPredecessor() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    List<Integer> inOrderTraversalResults = tree.traverse(TraversalType.DEPTH_FIRST_INORDER);
    Assert.assertNull(tree.findPredecessor(inOrderTraversalResults.get(0)));
    for (int i = 1; i < inOrderTraversalResults.size(); i++) {
      Assert.assertEquals(inOrderTraversalResults.get(i - 1),
          tree.findPredecessor(inOrderTraversalResults.get(i)));
    }
  }

  @Test
  public void findPredecessorHardCodedTest() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    Assert.assertNull(tree.findPredecessor(25));
    Assert.assertEquals(25, tree.findPredecessor(50).intValue());
    Assert.assertEquals(60, tree.findPredecessor(75).intValue());
    Assert.assertEquals(50, tree.findPredecessor(60).intValue());
    Assert.assertEquals(75, tree.findPredecessor(80).intValue());
    Assert.assertEquals(80, tree.findPredecessor(100).intValue());
    Assert.assertEquals(150, tree.findPredecessor(200).intValue());
    Assert.assertEquals(100, tree.findPredecessor(150).intValue());
    Assert.assertEquals(200, tree.findPredecessor(250).intValue());
    Assert.assertEquals(250, tree.findPredecessor(300).intValue());

  }
}
