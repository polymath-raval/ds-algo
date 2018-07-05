package edu.polymath.raval.dynamicProgramming;

import java.util.List;
import org.junit.Test;

public class CuttingARodTest {

  @Test
  public void cut() throws Exception {
    CuttingARod cuttingARod = new CuttingARod();
    List<Integer> findRods = cuttingARod
        .cut(100, new int[]{1, 2, 3, 4, 8}, new int[]{4, 5, 8, 11, 17});
    System.out.println(findRods);

    /*List<Integer> findRods = cuttingARod.cut(5, new int[]{1, 2, 3, 4, 8}, new int[]{2, 5, 9, 6, 30});
    System.out.println(findRods);*/
  }

}