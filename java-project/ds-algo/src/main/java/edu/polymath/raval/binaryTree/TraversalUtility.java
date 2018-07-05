package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.BinarySearchTree.TraversalType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TraversalUtility<T extends Comparable<T>> {

  private void inOrderTraversal(Node<T> _root, List<T> _result) {
    if (_root != null) {
      inOrderTraversal(_root.left, _result);
      _result.add(_root.data);
      inOrderTraversal(_root.right, _result);
    }
  }

  private void preOrderTraversal(Node<T> _root, List<T> _result) {
    if (_root != null) {
      _result.add(_root.data);
      preOrderTraversal(_root.left, _result);
      preOrderTraversal(_root.right, _result);
    }
  }

  private void postOrderTraversal(Node<T> _root, List<T> _result) {
    if (_root != null) {
      postOrderTraversal(_root.left, _result);
      postOrderTraversal(_root.right, _result);
      _result.add(_root.data);
    }
  }

  private void breadthFirstTraversal(Node<T> _root, List<T> _result) {
    Queue<Node<T>> queue = new LinkedList<>();
    if (_root != null) {
      queue.add(_root);
    }
    while (!queue.isEmpty()) {
      Node<T> _node = queue.remove();
      _result.add(_node.data);
      if (_node.left != null) {
        queue.add(_node.left);
      }
      if (_node.right != null) {
        queue.add(_node.right);
      }
    }
  }

  List<T> traverse(Node<T> _root, TraversalType _type) {
    List<T> _result = new ArrayList<>();
    switch (_type) {
      case BREADTH_FIRST:
        breadthFirstTraversal(_root, _result);
        break;
      case DEPTH_FIRST_INORDER:
        inOrderTraversal(_root, _result);
        break;
      case DEPTH_FIRST_PREORDER:
        preOrderTraversal(_root, _result);
        break;
      case DEPTH_FIRST_POSTORDER:
        postOrderTraversal(_root, _result);
        break;
    }
    return _result;
  }
}
