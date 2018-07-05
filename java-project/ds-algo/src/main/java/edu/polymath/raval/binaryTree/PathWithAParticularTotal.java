package edu.polymath.raval.binaryTree;

import java.util.Stack;

public class PathWithAParticularTotal {

  public static void findPath(Node<Integer> root, int requiredTotal){
    new PathWithAParticularTotal(requiredTotal).findPath(root);
  }

  private PathWithAParticularTotal( int requiredTotal) {
    this.requiredTotal = requiredTotal;
  }

  Stack<Integer> stack = new Stack<>();
  int requiredTotal;
  int runningTotal = 0;

  private void findPath(Node<Integer> _root) {
    runningTotal = runningTotal + _root.data;
    stack.push(_root.data);

    if (_root != null && _root.left == null && _root.right == null
        && runningTotal == requiredTotal) {
      System.out.println(stack);
    } else {
      if (_root.left != null) {
        findPath(_root.left);
      }
      if (_root.right != null) {
        findPath(_root.right);
      }
    }
    runningTotal = runningTotal - _root.data;
    stack.pop();
  }
}
