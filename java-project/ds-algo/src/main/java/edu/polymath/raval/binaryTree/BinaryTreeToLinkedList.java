package edu.polymath.raval.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToLinkedList<T extends Comparable<T>> {

  private Node<T> lastNode;

  private BinaryTreeToLinkedList() {

  }

  public static <T extends Comparable<T>> Node<T> inorder(BinarySearchTree<T> bst) {
    return new BinaryTreeToLinkedList<T>().inOrderChange(bst.root);
  }

  public static <T extends Comparable<T>> Node<T> breadthFirst(BinarySearchTree<T> bst) {
    return new BinaryTreeToLinkedList<T>().breadthFirstChange(bst.root);
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

  private Node<T> breadthFirstChange(Node<T> root) {
    Queue<Node<T>> queue = new LinkedList<>();
    if (root != null) {
      queue.offer(root);
    }
    Node<T> last = null;
    while (!queue.isEmpty()) {
      Node<T> current = queue.remove();
      if (current.left != null) {
        queue.offer(current.left);
      }
      if (current.right != null) {
        queue.offer(current.right);
      }
      current.left = last;
      if (last != null) {
        last.right = current;
      }
      last = current;
    }
    return root;
  }

}
