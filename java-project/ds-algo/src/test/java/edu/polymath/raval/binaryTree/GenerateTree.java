package edu.polymath.raval.binaryTree;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GenerateTree {
  public static AVLTree generateAVLMedium(){
    AVLTree<Integer> avl = new AVLTree<>();
    avl.insertUnbalanced(100);
    avl.insertUnbalanced(50);
    avl.insertUnbalanced(200);
    avl.insertUnbalanced(25);
    avl.insertUnbalanced(75);
    avl.insertUnbalanced(150);
    avl.insertUnbalanced(250);
    avl.insertUnbalanced(10);
    avl.insertUnbalanced(30);
    avl.insertUnbalanced(60);
    avl.insertUnbalanced(80);
    avl.insertUnbalanced(300);
    avl.insertUnbalanced(5);
    avl.insertUnbalanced(27);
    avl.insertUnbalanced(250);
    avl.insertUnbalanced(4);
    avl.insertUnbalanced(3);
    avl.insertUnbalanced(2);
    avl.insertUnbalanced(1);
    avl.insertUnbalanced(89);
    avl.insertUnbalanced(81);
    avl.insertUnbalanced(82);
    avl.insertUnbalanced(85);
    return avl;
  }

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

  public static AVLTree generateAVLShort(BiConsumer<AVLTree<Integer>, Integer> insert){
    AVLTree<Integer> avl = new AVLTree<>();
    insert.accept(avl, 100);
    insert.accept(avl, 50);
    insert.accept(avl, 200);
    insert.accept(avl, 25);
    insert.accept(avl, 75);
    insert.accept(avl, 150);
    insert.accept(avl, 250);
    insert.accept(avl, 60);
    insert.accept(avl, 80);
    insert.accept(avl, 300);
    return avl;
  }

  public static AVLTree generateAVLShort1(BiConsumer<AVLTree<Integer>, Integer> insert){

    AVLTree<Integer> avl = new AVLTree<>();
    insert.accept(avl, 25);
    insert.accept(avl, 50);
    insert.accept(avl, 60);
    insert.accept(avl, 80);
    insert.accept(avl, 75);
    insert.accept(avl, 100);
    insert.accept(avl, 200);
    insert.accept(avl, 150);
    insert.accept(avl, 250);
    insert.accept(avl, 300);
    return avl;
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
