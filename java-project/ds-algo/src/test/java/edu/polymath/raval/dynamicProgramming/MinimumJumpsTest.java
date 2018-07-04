package edu.polymath.raval.dynamicProgramming;

import org.junit.Test;

public class MinimumJumpsTest {

  @Test
  public void computeMinimumJump() throws Exception {
    MinimumJumps minimumJumps = new MinimumJumps();
    minimumJumps.computeMinimumJump(new int[]{1, 2, 3, 1, 3, 4, 5, 1, 2, 8});
  }

}