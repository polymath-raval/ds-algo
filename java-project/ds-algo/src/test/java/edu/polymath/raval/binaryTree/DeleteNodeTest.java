package edu.polymath.raval.binaryTree;

import edu.polymath.raval.binaryTree.BinarySearchTree.TraversalType;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeTest {

  @Test
  public void deleteTree() {
    BinarySearchTree bst = GenerateTree.generateBSTMedium();
    bst.deleteTree();
  }

  @Test
  public void deleteNode() {
    deleteNode(TraversalType.DEPTH_FIRST_INORDER);
    deleteNode(TraversalType.DEPTH_FIRST_PREORDER);
    deleteNode(TraversalType.DEPTH_FIRST_POSTORDER);
    deleteNode(TraversalType.BREADTH_FIRST);
  }

  public void deleteNode(TraversalType traversalType) {
    BinarySearchTree<Integer> bst = GenerateTree.generateBSTShort();

    List<Integer> deleteSequence = bst.traverse(traversalType);
    Integer sum = deleteSequence.stream().collect(Collectors.summingInt(value -> value));

    int deleteSum = 0;
    for (Integer integer : deleteSequence) {
      deleteSum = deleteSum + integer;
      Assert.assertTrue(bst.delete(integer));
      Assert.assertEquals(new Long(sum - deleteSum), new Long(sumFromTree(bst, traversalType)));
    }
    Assert.assertEquals(new Long(deleteSum), new Long(sum));
    Assert.assertTrue(CollectionUtils.isEmpty(bst.traverse(traversalType)));
  }

  private Integer sumFromTree(BinarySearchTree<Integer> tree, TraversalType type) {
    List<Integer> list = tree.traverse(type);
    return list.stream().collect(Collectors.summingInt(value -> value));
  }


}
