package edu.polymath.raval.dynamicProgramming;

public class LongestPalindromicSubSequence {

  public char[] find(char[] input) {
    int[][] outputMatrix = new int[input.length][input.length];
    for (int i = 0; i < outputMatrix.length; i++) {
      outputMatrix[i][i] = 1;
    }
    for (int i = 0; i < outputMatrix.length; i++) {
      for (int j = 0; j < i; j++) {
        outputMatrix[i][j] = 0;
      }
    }

    for (int i = 0; i < outputMatrix.length; i++) {
      for (int j = i; j < outputMatrix.length - 1; j++) {
        int x_coordinates = j - i;
        int y_coordinates = j + 1;
        if (input[x_coordinates] == input[y_coordinates]) {
          outputMatrix[x_coordinates][y_coordinates] =
              outputMatrix[x_coordinates + 1][y_coordinates - 1] + 2;
        } else {
          outputMatrix[x_coordinates][y_coordinates] =
              Integer.max(outputMatrix[x_coordinates][y_coordinates - 1],
                  outputMatrix[x_coordinates + 1][y_coordinates]);
        }
      }
    }

    char[] output = new char[outputMatrix[0][input.length - 1]];
    int i = 0;
    int j = input.length - 1;
    int index = 0;
    while (i < input.length && j > 0) {
      if (outputMatrix[i][j] == outputMatrix[i][j - 1]) {
        j--;
      } else if (outputMatrix[i][j] == outputMatrix[i + 1][j]) {
        i++;
      } else {
        output[index] = input[i];
        output[output.length - 1 - index] = input[i];
        index++;
        j--;
        i++;
      }
    }

    return output;
  }
}
