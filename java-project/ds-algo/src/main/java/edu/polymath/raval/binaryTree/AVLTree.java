package edu.polymath.raval.binaryTree;

public class AVLTree<T extends Comparable<T>> {

  AVLTreeNode<T> root;

  public void insertUnbalanced(T data) {
    AVLTreeNode<T> dataNode = new AVLTreeNode<T>(data);
    if (root == null) {
      root = dataNode;
    } else {
      insertUnbalanced(root, dataNode);
    }
  }

  public void insertBalanced(T data) {
    insertUnbalanced(data);
    balance();
  }

  public void balance() {
    do{
      root = balance(root);
      computeBalanceFactor();
    }while(!isBalanced(root));
  }

  private boolean isBalanced(AVLTreeNode<T> _root){
    return _root == null ? true :
        (_root.balanceFactor >= -1 && _root.balanceFactor <= 1) &&
            isBalanced(_root.left) && isBalanced(_root.right);
  }

  private void insertUnbalanced(AVLTreeNode<T> _root, AVLTreeNode<T> _dataNode) {
    int comparision = _root.data.compareTo(_dataNode.data);
    if (comparision == 0) {
      _root.data = _dataNode.data;
    } else if (comparision > 0) {
      if (_root.left == null) {
        _root.left = _dataNode;
      } else {
        insertUnbalanced(_root.left, _dataNode);
      }
    } else {
      if (_root.right == null) {
        _root.right = _dataNode;
      } else {
        insertUnbalanced(_root.right, _dataNode);
      }
    }
  }

  private AVLTreeNode<T> balance(AVLTreeNode<T> _root) {
    if (_root == null) {
      return null;
    } else {
      _root.left = balance(_root.left);
      _root.right = balance(_root.right);
      if (!(_root.balanceFactor >= -1 && _root.balanceFactor <= 1)) {
        _root = applyRotation(_root);
      }
      return _root;
    }
  }

  private AVLTreeNode<T> applyRotation(AVLTreeNode<T> _root) {
    if (_root.balanceFactor >= -1 && _root.balanceFactor <= 1) {
      return _root;
    } else if (_root.balanceFactor < -1) {
      return _root.right.balanceFactor < 0 ? applyRRRotation(_root) : applyRLRotation(_root);
    } else {
      return _root.left.balanceFactor > 0 ? applyLLRotation(_root) : applyLRRotation(_root);
    }
  }

  private AVLTreeNode<T> applyLLRotation(AVLTreeNode<T> _root) {
    AVLTreeNode<T> result = _root.left;
    _root.left = result.right;
    result.right = _root;
    computeBalanceFactor(result);
    return result;
  }

  private AVLTreeNode<T> applyRRRotation(AVLTreeNode<T> _root) {
    AVLTreeNode<T> result = _root.right;
    _root.right = result.left;
    result.left = _root;
    computeBalanceFactor(result);
    return result;
  }

  private AVLTreeNode<T> applyLRRotation(AVLTreeNode<T> _root) {
    AVLTreeNode<T> result = _root.left.right;

    _root.left.right = result.left;
    result.left = _root.left;

    _root.left = result.right;
    result.right = _root;

    computeBalanceFactor(result);
    return result;
  }

  private AVLTreeNode<T> applyRLRotation(AVLTreeNode<T> _root) {
    AVLTreeNode<T> result = _root.right.left;

    _root.right.left = result.right;
    result.right = _root.right;

    _root.right = result.left;
    result.left = _root;

    computeBalanceFactor(result);
    return result;
  }

  void computeBalanceFactor() {
    computeBalanceFactor(root);
  }

  private void computeBalanceFactor(AVLTreeNode<T> _root) {
    if (_root == null) {
      return;
    }

    computeBalanceFactor(_root.left);
    computeBalanceFactor(_root.right);
    int leftSubTreeHeight = (_root.left == null ? 0 : _root.left.height);
    int rightSubTreeHeight = (_root.right == null ? 0 : _root.right.height);
    _root.height = 1 + Integer.max(leftSubTreeHeight, rightSubTreeHeight);
    _root.balanceFactor = leftSubTreeHeight - rightSubTreeHeight;
  }


  public void print() {
    if (root != null) {
      print(root, "", true);
    } else {
      System.out.println("Empty");
    }
  }

  private void print(AVLTreeNode<T> node, String prefix, boolean isTail) {
    System.out
        .println(
            prefix + (isTail ? "└── " : "├── ") + node.data + " bf: (" + node.balanceFactor + ")"
                + " hi: (" + node.height + ")");

    if (node.left instanceof AVLTreeNode) {
      print((AVLTreeNode<T>) node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
    }
    if (node.right instanceof AVLTreeNode) {
      print((AVLTreeNode<T>) node.right, prefix + (isTail ? "    " : "│   "), true);
    }
  }

  public boolean isValidBinaryTree() {
    return isValidBinaryTree(root);
  }

  private boolean isValidBinaryTree(AVLTreeNode<T> _root) {
    if (_root == null) {
      return true;
    } else {
      int leftComparision = _root.left == null ? 1 :
          _root.data.compareTo(_root.left.data);

      int rightComparision = _root.right == null ? -1 :
          _root.data.compareTo(_root.right.data);

      boolean isCurrentTreeAValidBinaryTree = leftComparision > 0 && rightComparision < 0;

      return isCurrentTreeAValidBinaryTree && isValidBinaryTree(_root.left)
          && isValidBinaryTree(_root.right);
    }
  }

  public int height(){
    return height(root);
  }

  private int height(AVLTreeNode<T> _root){
   return _root == null ? 0 : 1 + Integer.max(height(_root.left), height(_root.right));
  }
}
