package edu.polymath.raval.binaryTree;

public class GenerateTree {

  public static BinarySearchTree generateBSTMedium() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(100);
    bst.insert(50);
    bst.insert(200);
    bst.insert(25);
    bst.insert(75);
    bst.insert(150);
    bst.insert(250);
    bst.insert(10);
    bst.insert(30);
    bst.insert(60);
    bst.insert(80);
    bst.insert(300);
    bst.insert(5);
    bst.insert(27);
    bst.insert(250);
    bst.insert(4);
    bst.insert(3);
    bst.insert(2);
    bst.insert(1);
    bst.insert(89);
    bst.insert(81);
    bst.insert(82);
    bst.insert(85);
    return bst;
  }


  public static BinarySearchTree generateBSTShort() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    bst.insert(100);
    bst.insert(50);
    bst.insert(200);
    bst.insert(25);
    bst.insert(75);
    bst.insert(150);
    bst.insert(250);
    bst.insert(60);
    bst.insert(80);
    bst.insert(300);
    return bst;
  }
}
