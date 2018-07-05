package edu.polymath.raval.binaryTree;

import org.junit.Assert;
import org.junit.Test;

public class DiameterOfBinaryTreeTest {

  @Test
  public void diameterOfBinaryTree() {
    BinarySearchTree<Integer> bst = GenerateTree.generateBSTMedium();
    bst.print();
    Assert.assertEquals(14, bst.diameterOfBinaryTree());

    bst.delete(200);
    Assert.assertEquals(14, bst.diameterOfBinaryTree());
    bst.delete(150);
    Assert.assertEquals(14, bst.diameterOfBinaryTree());

    bst.delete(85);
    Assert.assertEquals(13, bst.diameterOfBinaryTree());

    bst.delete(27);
    Assert.assertEquals(13, bst.diameterOfBinaryTree());
    bst.delete(2);
    Assert.assertEquals(12, bst.diameterOfBinaryTree());
  }
}
