package edu.polymath.raval.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumProblem {

  public List<Integer> checkIfSubSetSumPossible(int[] set, int sumValue) {
    boolean[][] outputMatrix = new boolean[set.length + 1][sumValue + 1];
    for (int i = 0; i < outputMatrix.length; i++) {
      outputMatrix[i][0] = true;
    }
    for (int i = 1; i < outputMatrix[0].length; i++) {
      outputMatrix[0][i] = false;
    }

    for (int i = 1; i < outputMatrix.length; i++) {
      for (int j = 1; j < outputMatrix[i].length; j++) {
        outputMatrix[i][j] =
            outputMatrix[i - 1][j] ||
                (set[i - 1] <= j && outputMatrix[i - 1][j - set[i - 1]]);
      }
    }

    if (outputMatrix[set.length][sumValue]) {
      List<Integer> firstCombination = new ArrayList<>();
      int i = set.length;
      int j = sumValue;
      while (i > 0 && j > 0) {
        if (outputMatrix[i][j] == outputMatrix[i - 1][j]) {
          i--;
        } else {
          firstCombination.add(set[i - 1]);
          j = j - set[i - 1];
          i--;
        }
      }
      return firstCombination;
    }

    return null;
  }
}
