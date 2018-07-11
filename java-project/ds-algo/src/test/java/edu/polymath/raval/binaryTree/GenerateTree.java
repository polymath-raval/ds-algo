package edu.polymath.raval.binaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiConsumer;

public class GenerateTree {


  final static int[] mediumInput = new int[]{100, 50, 200, 25, 75, 150, 250, 10, 30, 60, 80, 300, 5,
      27, 250, 4, 3, 2, 1, 89, 81, 82, 85};
  final static int[] shortInput = new int[]{100, 50, 200, 25, 75, 150, 250, 60, 80, 300};

  public static int idealMediumInputHeight(){
    int i=0;
    while(Math.pow(2,i) < GenerateTree.mediumInput.length){i++;}
    return i;
  }

  public static int idealShortInputHeight(){
    int i=0;
    while(Math.pow(2,i) < GenerateTree.shortInput.length){i++;}
    return i;
  }

  public static AVLTree generateAVLMedium(BiConsumer<AVLTree<Integer>, Integer> insert) {
    AVLTree<Integer> avl = new AVLTree<>();
    Arrays.stream(mediumInput).forEach(i -> insert.accept(avl, i));
    return avl;
  }

  public static AVLTree generateAVLMedium1(BiConsumer<AVLTree<Integer>, Integer> insert) {
    AVLTree<Integer> avl = new AVLTree<>();
    Arrays.stream(mediumInput).sorted().forEach(i -> insert.accept(avl, i));
    return avl;
  }

  public static BinarySearchTree generateBSTMedium() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    Arrays.stream(mediumInput).forEach(bst::insert);
    return bst;
  }

  public static AVLTree generateAVLShort(BiConsumer<AVLTree<Integer>, Integer> insert) {
    AVLTree<Integer> avl = new AVLTree<>();
    Arrays.stream(shortInput).forEach(i -> insert.accept(avl, i));
    return avl;
  }

  public static AVLTree generateAVLShort1(BiConsumer<AVLTree<Integer>, Integer> insert) {
    AVLTree<Integer> avl = new AVLTree<>();
    Arrays.stream(shortInput).sorted().forEach(i -> insert.accept(avl, i));
    return avl;
  }

  public static AVLTree generateAVLShort2(BiConsumer<AVLTree<Integer>, Integer> insert) {
    AVLTree<Integer> avl = new AVLTree<>();
    Arrays.stream(shortInput).mapToObj(Integer::valueOf).sorted(Collections.reverseOrder())
        .forEach(i -> insert.accept(avl, i));
    return avl;
  }

  public static BinarySearchTree generateBSTShort() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    Arrays.stream(shortInput).forEach(i -> bst.insert(i));
    return bst;
  }


}
