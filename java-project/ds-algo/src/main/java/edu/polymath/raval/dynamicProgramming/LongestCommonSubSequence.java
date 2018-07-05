package edu.polymath.raval.dynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class LongestCommonSubSequence {

  public Stack<Character> find(char[] string1, char[] string2) {
    int[][] outputMatrix = new int[string1.length + 1][string2.length + 1];
    for (int i = 0; i < outputMatrix.length; i++) {
      outputMatrix[i][0] = 0;
    }
    for (int i = 0; i < outputMatrix[0].length; i++) {
      outputMatrix[0][i] = 0;
    }

    for (int i = 1; i < outputMatrix.length; i++) {
      for (int j = 1; j < outputMatrix[i].length; j++) {
        if (string1[i - 1] == string2[j - 1]) {
          outputMatrix[i][j] = outputMatrix[i - 1][j - 1] + 1;
        } else {
          outputMatrix[i][j] = Integer.max(outputMatrix[i - 1][j], outputMatrix[i][j - 1]);
        }
      }
    }
    System.out.println(Arrays.toString(("0" + new String(string1)).toCharArray()));
    for (int[] line : outputMatrix) {
      System.out.println("a: " + Arrays.toString(line));
    }

    int i = string1.length;
    int j = string2.length;
    Stack<Character> stack = new Stack<>();
    while (i > 0 && j > 0) {
      if (outputMatrix[i][j] == outputMatrix[i - 1][j]) {
        i--;
      } else if (outputMatrix[i][j] == outputMatrix[i][j - 1]) {
        j--;
      } else {
        stack.push(string1[i - 1]);
        i--;
        j--;
      }
    }
    return stack;
  }
}
