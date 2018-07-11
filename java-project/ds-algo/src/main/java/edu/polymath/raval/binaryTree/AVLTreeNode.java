package edu.polymath.raval.binaryTree;

public class AVLTreeNode<T extends Comparable<T>> {

  T data;
  AVLTreeNode<T> left;
  AVLTreeNode<T> right;
  int balanceFactor;
  int height;

  public AVLTreeNode(T data, AVLTreeNode<T> left, AVLTreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public AVLTreeNode(T data) {
    this.data = data;
  }
}
