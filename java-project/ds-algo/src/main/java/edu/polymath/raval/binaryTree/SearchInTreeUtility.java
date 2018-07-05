package edu.polymath.raval.binaryTree;

import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class SearchInTreeUtility<T extends Comparable<T>> {

  Node<T> findMinimumInSubTree(Node<T> _root) {
    if (_root == null) {
      return null;
    }
    Node<T> _result = _root;
    while (_result.left != null) {
      _result = _result.left;
    }
    return _result;
  }

  Node<T> findMaximumInSubTree(Node<T> _root) {
    if (_root == null) {
      return null;
    }
    Node<T> _result = _root;
    while (_result.right != null) {
      _result = _result.right;
    }
    return _result;
  }

}
