package edu.polymath.raval.dynamicProgramming;

import org.junit.Test;

public class LongestPalindromicSubSequenceTest {

  @Test
  public void find() throws Exception {
    LongestPalindromicSubSequence longestPalindromicSubSequence = new LongestPalindromicSubSequence();
    System.out.println(new String(longestPalindromicSubSequence.find("adbbca".toCharArray())));
  }

}