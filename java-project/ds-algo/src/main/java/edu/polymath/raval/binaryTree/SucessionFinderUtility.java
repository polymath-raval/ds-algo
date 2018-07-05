package edu.polymath.raval.binaryTree;

class SucessionFinderUtility<T extends Comparable<T>> {

  T findPredecessor(Node<T> _root, T data) {
    Node<T> _lastRight = null;
    Node<T> _current = _root;
    while (_current != null) {
      int comparision = _current.data.compareTo(data);
      if (comparision == 0) {
        return _current.left != null ?
            new SearchInTreeUtility<T>().findMaximumInSubTree(_current.left).data :
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

  T findSuccessor(Node<T> _root, T data) {
    Node<T> _lastLeft = null;
    Node<T> _current = _root;
    while (_current != null) {
      int comparision = _current.data.compareTo(data);
      if (comparision == 0) {
        return _current.right != null ?
            new SearchInTreeUtility<T>().findMinimumInSubTree(_current.right).data :
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


}
