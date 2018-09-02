package edu.polymath.raval.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CoinChangeProblem {

  public List<String> numberOfWays(int[] denomination, int value) {
    Map<Integer, List<String>> ways = new HashMap<>();
    ways.putIfAbsent(0, new ArrayList<>());
    ways.get(0).add("0");
    int[][] outputMatrix = new int[denomination.length + 1][value + 1];
    for (int i = 0; i < outputMatrix.length; i++) {
      outputMatrix[i][0] = 1;
    }
    for (int i = 1; i < outputMatrix[0].length; i++) {
      outputMatrix[0][i] = 0;
    }
 
    for (int i = 1; i < outputMatrix.length; i++) {
      for (int j = 1; j < outputMatrix[i].length; j++) {
        final int coinValue = denomination[i - 1];
        if (coinValue <= j) {
          outputMatrix[i][j] = outputMatrix[i - 1][j] + outputMatrix[i][j - coinValue];
          ways.putIfAbsent(j, new ArrayList<>());
          ways.get(j).addAll(ways.get(j - coinValue).stream().map(s -> coinValue + "+" + s)
              .collect(Collectors.toList()));
        } else {
          outputMatrix[i][j] = outputMatrix[i - 1][j];
        }
      }
    }

    return ways.get(value);
  }
}
