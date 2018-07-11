package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.TraversalUtility.TraversalType;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class HeightOfBinaryTreeTest {

  @Test
  public void heightOfBinaryTree() {
    BinarySearchTree bst = GenerateTree.generateBSTShort();
    List<Integer> deleteSequence = bst.traverse(TraversalType.DEPTH_FIRST_INORDER);
    Assert.assertEquals(4, bst.heightOfBinaryTree());
    bst.print();

    bst.delete(100);
    bst.print();
    Assert.assertEquals(4, bst.heightOfBinaryTree());

    bst.delete(50);
    bst.print();
    Assert.assertEquals(4, bst.heightOfBinaryTree());

    bst.delete(200);
    bst.print();
    Assert.assertEquals(4, bst.heightOfBinaryTree());

    bst.delete(25);
    bst.print();
    Assert.assertEquals(4, bst.heightOfBinaryTree());

    bst.delete(75);
    bst.print();
    Assert.assertEquals(3, bst.heightOfBinaryTree());

    bst.delete(150);
    bst.print();
    Assert.assertEquals(3, bst.heightOfBinaryTree());

    bst.delete(250);
    bst.print();
    Assert.assertEquals(3, bst.heightOfBinaryTree());

    bst.delete(60);
    bst.print();
    Assert.assertEquals(2, bst.heightOfBinaryTree());

    bst.delete(80);
    bst.print();
    Assert.assertEquals(1, bst.heightOfBinaryTree());

    bst.delete(300);
    bst.print();
    Assert.assertEquals(0, bst.heightOfBinaryTree());

  }
}
