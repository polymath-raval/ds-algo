package edu.polymath.raval.dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubsetSumProblemTest {

  @Test
  public void checkIfSubSetSumPossible() throws Exception {
    SubsetSumProblem subsetSumProblem = new SubsetSumProblem();
    for(int i=1;i<20;i++){
      System.out.printf("%d ==> %s\n",i,subsetSumProblem.checkIfSubSetSumPossible(new int[]{2,3,4,7},i));
    }
  }

}