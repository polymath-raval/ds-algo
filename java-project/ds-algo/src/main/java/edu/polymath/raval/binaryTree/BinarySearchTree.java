package edu.polymath.raval.binaryTree;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

  Node<T> root;

  public void insert(T data) {
    Node<T> dataNode = new Node<>(data);
    if (root == null) {
      root = dataNode;
    } else {
      new InsertNodeUtility<T>().insert(root, dataNode);
    }
  }

  public List<T> traverse(TraversalType _type) {
    return new TraversalUtility<T>().traverse(root, _type);
  }

  public T findPredecessor(T data) {
    return new SucessionFinderUtility<T>().findPredecessor(root, data);
  }

  public T findSuccessor(T data) {
    return new SucessionFinderUtility<T>().findSuccessor(root, data);
  }

  public boolean deleteTree() {
    boolean deleted = true;
    for (T deleteCandidate : traverse(TraversalType.DEPTH_FIRST_POSTORDER)) {
      deleted = deleted && delete(deleteCandidate);
    }
    return deleted;
  }

  public boolean delete(T t) {
    if (root.data.compareTo(t) == 0 && root.left == null && root.right == null) {
      root.data = null;
      root = null;
      return true;
    } else {
      return DeleteNodeUtility.deleteNode(root, t);
    }
  }

  public int diameterOfBinaryTree() {
    return diameterFromNode(root);
  }

  private int diameterFromNode(Node _root) {
    return _root == null ? 0 :
        Integer.max(
            Integer.max(diameterFromNode(_root.left), diameterFromNode(_root.right)),
            1 + heightFromNode(_root.left) + heightFromNode(_root.right));
  }

  public int heightOfBinaryTree() {
    return heightFromNode(root);
  }

  private int heightFromNode(Node _root) {
    return _root == null ? 0 :
        1 + Integer.max(heightFromNode(_root.left), heightFromNode(_root.right));
  }

  public void print() {
    if (root != null) {
      print(root, "", true);
    } else {
      System.out.println("Empty");
    }
  }

  private void print(Node<T> node, String prefix, boolean isTail) {
    System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);

    if (node.left != null) {
      print(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
    }
    if (node.right != null) {
      print(node.right, prefix + (isTail ? "    " : "│   "), true);
    }

  }

  public enum TraversalType {
    BREADTH_FIRST,
    DEPTH_FIRST_INORDER,
    DEPTH_FIRST_PREORDER,
    DEPTH_FIRST_POSTORDER;
  }
}
