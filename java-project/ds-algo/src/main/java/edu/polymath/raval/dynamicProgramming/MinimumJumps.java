package edu.polymath.raval.dynamicProgramming;

import java.util.Arrays;

public class MinimumJumps {

  public int[][] computeMinimumJump(int[] array) {
    int[] path = createArrayOfLengthWithDefaultValue(array.length, -1);
    int[] cost = createArrayOfLengthWithDefaultValue(array.length, Integer.MAX_VALUE);

    path[0] = 0;
    cost[0] = 0;
    for (int desired_address = 1; desired_address < array.length; desired_address++) {
      System.out.printf("\n\nComputing for desired path %d\n", desired_address);
      for (int path_address = 0; path_address < desired_address && path[path_address] != -1;
          path_address++) {
        int maximum_possible_jump = array[path_address];
        if (path_address + maximum_possible_jump >= desired_address) {
          int cost_to_reach_path_address = cost[path_address];
          int proposed_cost_to_reach_desired_address = cost_to_reach_path_address + 1;
          int current_cost_to_reach_desired_address = cost[desired_address];
          if (proposed_cost_to_reach_desired_address < current_cost_to_reach_desired_address) {
            path[desired_address] = path_address;
            cost[desired_address] = proposed_cost_to_reach_desired_address;
            System.out.printf("Cost %s\nPath %s\n", Arrays.toString(cost), Arrays.toString(path));
          }
        }
      }
    }
    return new int[][]{path, cost};
  }

  private int[] createArrayOfLengthWithDefaultValue(int length, int defaultValue) {
    int[] arr = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = defaultValue;
    }
    return arr;
  }

}
