package edu.polymath.raval.binaryTree;

class InsertNodeUtility<T extends Comparable<T>> {

  void insert(Node<T> _root, Node<T> _dataNode) {
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
}
