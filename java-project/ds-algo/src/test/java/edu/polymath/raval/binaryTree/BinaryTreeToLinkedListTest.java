package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.TraversalUtility.TraversalType;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeToLinkedListTest {

  @Test
  public void inorder() throws Exception {
    BinarySearchTree<Integer> bst = GenerateTree.generateBSTShort();
    List<Integer> inOrderTraversal = bst.traverse(TraversalType.DEPTH_FIRST_INORDER);

    Node<Integer> head = BinaryTreeToLinkedList.inorder(bst);
    Stack<Integer> stack = new Stack<>();
    while (true) {
      stack.push(head.data);
      if (head.left == null) {
        break;
      }
      head = head.left;
    }
    Assert.assertEquals(inOrderTraversal.size(), stack.size());
    int index = 0;
    while (!stack.isEmpty()) {
      Assert.assertEquals(inOrderTraversal.get(index), stack.pop());
      index++;
    }
    Assert.assertEquals(inOrderTraversal.size(), index);

    Queue<Integer> queue = new LinkedList<>();
    while (true) {
      queue.offer(head.data);
      if (head.right == null) {
        break;
      }
      head = head.right;
    }
    Assert.assertEquals(inOrderTraversal.size(), queue.size());
    index = 0;
    while (!queue.isEmpty()) {
      Assert.assertEquals(inOrderTraversal.get(index), queue.remove());
      index++;
    }
    Assert.assertEquals(inOrderTraversal.size(), index);
  }

  @Test
  public void breadthFirst() {
    BinarySearchTree<Integer> bst = GenerateTree.generateBSTShort();
    List<Integer> breadthFirstTraversal = bst.traverse(TraversalType.BREADTH_FIRST);
    Node<Integer> head = BinaryTreeToLinkedList.breadthFirst(bst);
    Queue<Integer> queue = new LinkedList<>();
    while (true) {
      queue.offer(head.data);
      if (head.right == null) {
        break;
      }
      head = head.right;
    }
    Assert.assertEquals(breadthFirstTraversal.size(), queue.size());
    int index = 0;
    while (!queue.isEmpty()) {
      Assert.assertEquals(breadthFirstTraversal.get(index), queue.remove());
      index++;
    }
    Assert.assertEquals(breadthFirstTraversal.size(), index);

    Stack<Integer> stack = new Stack<>();
    while (true) {
      stack.push(head.data);
      if (head.left == null) {
        break;
      }
      head = head.left;
    }
    Assert.assertEquals(breadthFirstTraversal.size(), stack.size());
    index = 0;
    while (!stack.isEmpty()) {
      Assert.assertEquals(breadthFirstTraversal.get(index), stack.pop());
      index++;
    }
    Assert.assertEquals(breadthFirstTraversal.size(), index);
  }

}