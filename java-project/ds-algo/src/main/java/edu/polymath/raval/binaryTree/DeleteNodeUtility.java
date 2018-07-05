package edu.polymath.raval.binaryTree;

public class DeleteNodeUtility<T extends Comparable<T>> {

  Node<T> rootNode;
  Node<T> parentNode;
  Node<T> dataNode;

  private DeleteNodeUtility(Node<T> _root, T _data) {
    rootNode = _root;
    findNode(_root, _data);
    if (_data == null) {
      throw new RuntimeException("DataNode doesnot exists in tree");
    }
  }

  public static <T extends Comparable<T>> boolean deleteNode(Node<T> _root, T data) {
    DeleteNodeUtility<T> utility = new DeleteNodeUtility<>(_root, data);
    return utility.removeNodeWhenNoChild() || utility.removeNodeWithOneChild() || utility
        .removeNodeWithTwoChild();
  }

  private void findNode(Node<T> _root, T _data) {
    if (_root == null) {
      return;
    }
    int comparision = _root.data.compareTo(_data);
    if (comparision == 0) {
      dataNode = _root;
    } else if (comparision > 0) {
      parentNode = _root;
      findNode(_root.left, _data);
    } else {
      parentNode = _root;
      findNode(_root.right, _data);
    }
  }

  private boolean removeNodeWhenNoChild() {
    if (dataNode.left == null && dataNode.right == null) {
      if (parentNode == null) {
        throw new RuntimeException("Unhandled situation");
      } else if (parentNode.left != null && parentNode.left.data == dataNode.data) {
        dataNode.data = null;
        parentNode.left = null;
      } else if (parentNode.right != null && parentNode.right.data == dataNode.data) {
        dataNode.data = null;
        parentNode.right = null;
      } else {
        throw new RuntimeException("Invalid state of tree");
      }
      return true;
    }
    return false;
  }

  private boolean removeNodeWithOneChild() {
    if (dataNode.left != null && dataNode.right == null) {
      if (parentNode == null) {
        rootNode.data = dataNode.left.data;
        rootNode.left = dataNode.left.left;
        rootNode.right = dataNode.left.right;
      } else if (parentNode.left.data == dataNode.data) {
        parentNode.left = dataNode.left;
        dataNode.data = null;
        dataNode.left = null;
      } else if (parentNode.right.data == dataNode.data) {
        parentNode.right = dataNode.left;
        dataNode.data = null;
        dataNode.left = null;
      }
      return true;
    } else if (dataNode.left == null && dataNode.right != null) {
      if (parentNode == null) {
        rootNode.data = dataNode.right.data;
        rootNode.left = dataNode.right.left;
        rootNode.right = dataNode.right.right;
      } else if (parentNode.left != null && parentNode.left.data == dataNode.data) {
        parentNode.left = dataNode.right;
        dataNode.data = null;
        dataNode.right = null;
      } else if (parentNode.right != null && parentNode.right.data == dataNode.data) {
        parentNode.right = dataNode.right;
        dataNode.data = null;
        dataNode.right = null;
      }
      return true;
    }
    return false;
  }

  private boolean removeNodeWithTwoChild() {
    if (dataNode.left != null && dataNode.right != null) {
      T replacementData = new SearchInTreeUtility<T>().findMinimumInSubTree(dataNode.right).data;
      if (deleteNode(rootNode, replacementData)) {
        dataNode.data = replacementData;
        return true;
      }
    }
    return false;
  }


}
