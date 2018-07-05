package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.ThreadedBinaryTree.ThreadedBinaryTreeNode;
import org.junit.Test;

public class ThreadedBinaryTreeTest {

  @Test
  public void covert() throws Exception {
    BinarySearchTree<Integer> bst = GenerateTree.generateBSTShort();
    ThreadedBinaryTreeNode<Integer> tbtNode = ThreadedBinaryTree.covert(bst);
    inorderTraversal(tbtNode);
  }

  private void inorderTraversal(ThreadedBinaryTreeNode<Integer> tbtNode) {
    if (tbtNode != null) {
      if (tbtNode.isLeftThreaded && tbtNode.node.left != null) {
        System.out.printf("Current Node [%d] Left Threaded to [%d]\n", tbtNode.node.data, tbtNode.node.left.data);
      }else{
        inorderTraversal(tbtNode.left);
      }

      System.out.printf("Current Node [%d]\n", tbtNode.node.data);

      if (tbtNode.isRightThreaded && tbtNode.node.right != null) {
        System.out.printf("Current Node [%d] Right Threaded to [%d]\n", tbtNode.node.data, tbtNode.node.right.data);
      }else{
        inorderTraversal(tbtNode.right);
      }
      System.out.println("\n\n");
    }
  }

}