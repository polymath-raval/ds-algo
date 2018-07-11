package edu.polymath.raval.binaryTree;

import org.junit.Test;

public class AVLTreeInsertTest {

  @Test
  public void insertUnbalanced() {
    AVLTree<Integer> avlTree = GenerateTree
        .generateAVLShort1((integerAVLTree, integer) -> integerAVLTree.insertUnbalanced(integer));
    avlTree.print();
    avlTree.balance();
    avlTree.print();
  }

  @Test
  public void insertBalanced() {
    AVLTree<Integer> avlTree = GenerateTree
        .generateAVLShort1((integerAVLTree, integer) -> integerAVLTree.insertBalanced(integer));
    avlTree.print();
  }
}
