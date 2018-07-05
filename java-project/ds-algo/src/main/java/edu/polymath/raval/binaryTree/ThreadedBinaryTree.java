package edu.polymath.raval.binaryTree;

public class ThreadedBinaryTree<T extends Comparable<T>> {

  private ThreadedBinaryTreeNode<T> lastNode = null;

  private ThreadedBinaryTree() {
  }

  public static <T extends Comparable<T>> ThreadedBinaryTreeNode<T> covert(
      BinarySearchTree<T> bst) {
    return new ThreadedBinaryTree<T>().convert(bst.root);
  }

  private ThreadedBinaryTreeNode<T> convert(Node<T> rootNode) {
    if (rootNode == null) {
      return null;
    }

    ThreadedBinaryTreeNode<T> left = convert(rootNode.left);

    //convert the current node
    ThreadedBinaryTreeNode<T> tbtNode = new ThreadedBinaryTreeNode<>(rootNode);
    if (rootNode.left == null && lastNode != null) {
      tbtNode.isLeftThreaded = true;
      tbtNode.node.left = lastNode.node;
    }
    if (lastNode != null && lastNode.node.right == null) {
      lastNode.isRightThreaded = true;
      lastNode.node.right = rootNode;
    }
    lastNode = tbtNode;

    ThreadedBinaryTreeNode<T> right = convert(rootNode.right);
    tbtNode.left = left;
    tbtNode.right = right;

    return tbtNode;
  }

  public static class ThreadedBinaryTreeNode<T extends Comparable<T>> {

    Node<T> node;
    ThreadedBinaryTreeNode<T> left;
    ThreadedBinaryTreeNode<T> right;
    boolean isLeftThreaded = false;
    boolean isRightThreaded = false;

    public ThreadedBinaryTreeNode(Node<T> node) {
      this.node = node;
    }
  }

}
