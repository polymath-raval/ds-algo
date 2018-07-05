package edu.polymath.raval.binaryTree;

public class BinaryTreeToLinkedList<T extends Comparable<T>> {

  private Node<T> lastNode;

  private BinaryTreeToLinkedList() {

  }

  private Node<T> inOrderChange(Node<T> current) {
    if (current == null) {
      return lastNode;
    }

    inOrderChange(current.left);

    current.left = lastNode;
    if (lastNode != null) {
      lastNode.right = current;
    }
    lastNode = current;

    inOrderChange(current.right);

    return lastNode;
  }

  public static <T extends Comparable<T>> Node<T> inorder(BinarySearchTree<T> bst) {
    return new BinaryTreeToLinkedList<T>().inOrderChange(bst.root);
  }
}
