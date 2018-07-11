package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.TraversalUtility.TraversalType;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections4.ListUtils;
import org.junit.Assert;
import org.junit.Test;

public class TraversalTest {

  @Test
  public void testInOrderTraversal() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    List<Integer> precomputedResults = Arrays.asList(25, 50, 60, 75, 80, 100, 150, 200, 250, 300);
    Assert.assertTrue(ListUtils.isEqualList(precomputedResults,
        tree.traverse(TraversalType.DEPTH_FIRST_INORDER)));
  }

  @Test
  public void testPreOrderTraversal() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    List<Integer> precomputedResults = Arrays.asList(100, 50, 25, 75, 60, 80, 200, 150, 250, 300);
    Assert.assertTrue(ListUtils.isEqualList(precomputedResults,
        tree.traverse(TraversalType.DEPTH_FIRST_PREORDER)));
  }

  @Test
  public void testPostOrderTraversal() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    List<Integer> precomputedResults = Arrays.asList(25, 60, 80, 75, 50, 150, 300, 250, 200, 100);
    Assert.assertTrue(ListUtils.isEqualList(precomputedResults,
        tree.traverse(TraversalType.DEPTH_FIRST_POSTORDER)));
  }

  @Test
  public void testBreadthFirstTraversal() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    List<Integer> precomputedResults = Arrays.asList(100, 50, 200, 25, 75, 150, 250, 60, 80, 300);
    Assert.assertTrue(ListUtils.isEqualList(precomputedResults,
        tree.traverse(TraversalType.BREADTH_FIRST)));
  }

  @Test
  public void testZigzagTraversal() {
    BinarySearchTree<Integer> tree = GenerateTree.generateBSTShort();
    //List<Integer> precomputedResults = Arrays.asList(100, 50, 200, 25, 75, 150, 250, 60, 80, 300);
    //Assert.assertTrue(ListUtils.isEqualList(precomputedResults,
    System.out.println(tree.traverse(TraversalType.ZIGZAG));
    //));
  }


}
