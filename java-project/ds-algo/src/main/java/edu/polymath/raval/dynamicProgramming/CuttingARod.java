package edu.polymath.raval.dynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class CuttingARod {

  public int[][] generateMatrix(int totalLength, int[] denomination, int[] value) {
    int[][] outputMatrix = new int[denomination.length + 1][totalLength + 1];
    for (int i = 0; i < outputMatrix.length; i++) {
      outputMatrix[i][0] = 0;
    }
    for (int i = 0; i < outputMatrix[0].length; i++) {
      outputMatrix[0][0] = 0;
    }
    for (int i = 1; i < outputMatrix.length; i++) {
      for (int j = 1; j < outputMatrix[i].length; j++) {
        if (denomination[i - 1] <= j) {
          outputMatrix[i][j] = Integer
              .max(outputMatrix[i - 1][j], value[i - 1] + outputMatrix[i][j - denomination[i - 1]]);
        } else {
          outputMatrix[i][j] = outputMatrix[i - 1][j];
        }
      }
    }
    return outputMatrix;
  }

  public List<Integer> findRodLengths(int[][] outputMatrix, int[] denomination, int[] value) {
    LinkedList<Integer> rods = new LinkedList<>();
    int i = outputMatrix.length - 1;
    int j = outputMatrix[0].length - 1;
    while (i > 0 && j > 0) {
      if (outputMatrix[i][j] == outputMatrix[i - 1][j]) {
        i--;
      } else {
        rods.add(denomination[i - 1]);
        j = j - denomination[i - 1];
      }
    }
    return rods;
  }

  public List<Integer> cut(int totalLength, int[] denomination, int[] value) {
    return findRodLengths(generateMatrix(totalLength, denomination, value), denomination, value);
  }

}
