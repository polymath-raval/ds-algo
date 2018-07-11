package edu.polymath.raval.binaryTree;

import org.junit.Assert;
import org.junit.Test;

public class AVLTreeInsertTest {

  @Test
  public void insertUnbalanced() {
    AVLTree<Integer> avlTree = GenerateTree
        .generateAVLMedium1((integerAVLTree, integer) -> integerAVLTree.insertUnbalanced(integer));
    Assert.assertTrue(avlTree.isValidBinaryTree());
    avlTree.computeBalanceFactor();
    avlTree.print();
    avlTree.balance();
    Assert.assertTrue(avlTree.isValidBinaryTree());
    avlTree.print();
    Assert.assertTrue(avlTree.isValidBinaryTree());
    Assert.assertTrue(avlTree.height() <= GenerateTree.idealMediumInputHeight() + 1);
  }

  @Test
  public void insertBalanced1() {
    AVLTree<Integer> avlTree = GenerateTree
        .generateAVLShort1((integerAVLTree, integer) -> integerAVLTree.insertBalanced(integer));
    avlTree.print();

    Assert.assertTrue(avlTree.isValidBinaryTree());
    Assert.assertTrue(avlTree.height() <= GenerateTree.idealShortInputHeight());
  }

  @Test
  public void insertBalanced2() {
    AVLTree<Integer> avlTree = GenerateTree
        .generateAVLShort2((integerAVLTree, integer) -> integerAVLTree.insertBalanced(integer));
    avlTree.print();

    Assert.assertTrue(avlTree.isValidBinaryTree());
    Assert.assertTrue(avlTree.height() <= GenerateTree.idealShortInputHeight());
  }

  @Test
  public void insertBalanced() {
    AVLTree<Integer> avlTree = GenerateTree
        .generateAVLShort((integerAVLTree, integer) -> integerAVLTree.insertBalanced(integer));
    avlTree.print();

    Assert.assertTrue(avlTree.isValidBinaryTree());
    Assert.assertTrue(avlTree.height() <= GenerateTree.idealShortInputHeight());
  }

  @Test
  public void insertBalanced3() {
    AVLTree<Integer> avlTree = GenerateTree
        .generateAVLMedium1((integerAVLTree, integer) -> integerAVLTree.insertBalanced(integer));
    avlTree.print();

    Assert.assertTrue(avlTree.isValidBinaryTree());
    Assert.assertTrue(avlTree.height() <= GenerateTree.idealMediumInputHeight() + 1);
  }
}
