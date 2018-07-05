package edu.polymath.raval.dynamicProgramming;

import java.util.Stack;
import org.junit.Test;

public class LongestCommonSubSequenceTest {

  @Test
  public void find() throws Exception {
    LongestCommonSubSequence lcs = new LongestCommonSubSequence();
    Stack<Character> characters = lcs.find("bqdrcvefgh".toCharArray(), "abcvdefgh".toCharArray());
    while (!characters.isEmpty()) {
      System.out.print(characters.pop());
    }
  }

}