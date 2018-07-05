package edu.polymath.raval.binaryTree;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfPossibleBinaryTreesWithNNodesTest {

  @Test
  public void count() throws Exception {
    long[] catalanNumber = new long[]{
        1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845,
        35357670, 129644790, 477638700, 1767263190, 6564120420L, 24466267020L, 91482563640L,
        343059613650L, 1289904147324L, 4861946401452L
    };

    NumberOfPossibleBinaryTreesWithNNodes solution = new NumberOfPossibleBinaryTreesWithNNodes();
    for(int i=0;i<catalanNumber.length;i++){
      Assert.assertEquals(catalanNumber[i], solution.count(i));
    }
  }

}