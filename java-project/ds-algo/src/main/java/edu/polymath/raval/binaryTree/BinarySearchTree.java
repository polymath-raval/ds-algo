package edu.polymath.raval.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

  Node<T> root;

  public void insert(T data) {
    Node<T> dataNode = new Node<>(data);
    if (root == null) {
      root = dataNode;
    } else {
      insert(root, dataNode);
    }
  }

  private void insert(Node<T> _root, Node<T> _dataNode) {
    int comparision = _root.data.compareTo(_dataNode.data);
    if (comparision == 0) {
      _root.data = _dataNode.data;
    } else if (comparision > 0) {
      if (_root.left == null) {
        _root.left = _dataNode;
      } else {
        insert(_root.left, _dataNode);
      }
    } else {
      if (_root.right == null) {
        _root.right = _dataNode;
      } else {
        insert(_root.right, _dataNode);
      }
    }
  }

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

  public List<T> traverse(TraversalType type) {
    List<T> result = new ArrayList<>();
    switch (type) {
      case BREADTH_FIRST:
        breadthFirstTraversal(root, result);
        break;
      case DEPTH_FIRST_INORDER:
        inOrderTraversal(root, result);
        break;
      case DEPTH_FIRST_PREORDER:
        preOrderTraversal(root, result);
        break;
      case DEPTH_FIRST_POSTORDER:
        postOrderTraversal(root, result);
        break;
    }
    return result;
  }

  public T findPredecessor(T data) {
    Node<T> _lastRight = null;
    Node<T> _current = root;
    while (_current != null) {
      int comparision = _current.data.compareTo(data);
      if (comparision == 0) {
        return _current.left != null ?
            findMaximumInSubTree(_current.left).data :
            _lastRight != null ? _lastRight.data : null;
      } else if (comparision > 0) {
        _current = _current.left;
      } else {
        _lastRight = _current;
        _current = _current.right;
      }
    }
    return null;
  }

  private Node<T> findMaximumInSubTree(Node<T> _root) {
    if (_root == null) {
      return null;
    }
    Node<T> _result = _root;
    while (_result.right != null) {
      _result = _result.right;
    }
    return _result;
  }

  public T findSuccessor(T data) {
    Node<T> _lastLeft = null;
    Node<T> _current = root;
    while (_current != null) {
      int comparision = _current.data.compareTo(data);
      if (comparision == 0) {
        return _current.right != null ?
            findMinimumInSubTree(_current.right).data :
            _lastLeft != null ? _lastLeft.data : null;
      } else if (comparision > 0) {
        _lastLeft = _current;
        _current = _current.left;
      } else {
        _current = _current.right;
      }
    }
    return null;
  }

  private Node<T> findMinimumInSubTree(Node<T> _root) {
    if (_root == null) {
      return null;
    }
    Node<T> _result = _root;
    while (_result.left != null) {
      _result = _result.left;
    }
    return _result;
  }

  public enum TraversalType {
    BREADTH_FIRST,
    DEPTH_FIRST_INORDER,
    DEPTH_FIRST_PREORDER,
    DEPTH_FIRST_POSTORDER;
  }
}
