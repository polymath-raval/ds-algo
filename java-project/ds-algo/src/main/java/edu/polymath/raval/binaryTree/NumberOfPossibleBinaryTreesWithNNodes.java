package edu.polymath.raval.binaryTree;

public class NumberOfPossibleBinaryTreesWithNNodes {

  public long count(int numberOfNodes) {
    long[] resultArray = new long[numberOfNodes + 1];
    resultArray[0] = 1;
    for (int i = 1; i < resultArray.length; i++) {
      resultArray[i] = 0;
      for (int j = 0; j < i; j++) {
        resultArray[i] += (resultArray[j] * resultArray[i - j - 1]);
      }
    }
    return resultArray[numberOfNodes];
  }
}
