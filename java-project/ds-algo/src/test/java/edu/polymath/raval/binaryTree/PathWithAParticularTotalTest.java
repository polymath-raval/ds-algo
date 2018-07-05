package edu.polymath.raval.binaryTree;

import java.util.Stack;
import org.junit.Test;

public class PathWithAParticularTotalTest {

  @Test
  public void testImplentation() {
    BinarySearchTree<Integer> bst = GenerateTree.generateBSTShort();
    bst.print();
    PathWithAParticularTotal.findPath(bst.root, 450);

  }


}
