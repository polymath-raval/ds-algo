package edu.polymath.raval.binaryTree;

public class Node<T extends Comparable<T>> {

  T data;
  Node<T> left;
  Node<T> right;

  public Node(T data, Node<T> left, Node<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public Node(T data) {
    this.data = data;
  }
}
