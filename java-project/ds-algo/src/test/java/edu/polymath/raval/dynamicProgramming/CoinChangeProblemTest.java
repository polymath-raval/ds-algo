package edu.polymath.raval.dynamicProgramming;

import static org.junit.Assert.*;

import java.util.stream.Collectors;
import org.junit.Test;

public class CoinChangeProblemTest {

  @Test
  public void numberOfWays() throws Exception {
    CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
    System.out.println(coinChangeProblem.numberOfWays(new int[]{1, 2, 5, 10, 25}, 100).stream().collect(
        Collectors.joining("\n")));
  }

}