package edu.polymath.raval.dynamicProgramming;

import java.util.Arrays;

public class Knapsack {

  public void chooseItems(Item[] items, int totalWeight) {
    int[][] outputMatrix = new int[items.length + 1][totalWeight + 1];
    for (int i = 0; i < outputMatrix.length; i++) {
      outputMatrix[i][0] = 0;
    }
    for (int i = 0; i < outputMatrix[0].length; i++) {
      outputMatrix[0][i] = 0;
    }

    for (int i = 1; i < outputMatrix.length; i++) {
      for (int j = 1; j < outputMatrix[i].length; j++) {
        if (items[i - 1].weight <= j) {
          outputMatrix[i][j] = Integer.max(outputMatrix[i - 1][j],
              items[i - 1].value + outputMatrix[i - 1][j - items[i - 1].weight]);
        } else {
          outputMatrix[i][j] = outputMatrix[i - 1][j];
        }
      }
    }

    for (int[] line : outputMatrix) {
      System.out.println(Arrays.toString(line));
    }

    int i = outputMatrix.length - 1;
    int j = outputMatrix[0].length - 1;
    while (i > 0 && j > 0) {
      if (outputMatrix[i][j] == outputMatrix[i - 1][j]) {
        i--;
      } else {
        items[i - 1].selected = true;
        j = j - items[i - 1].weight;
        i--;
      }
    }


  }

  public static class Item {

    String name;
    int weight;
    int value;
    boolean selected;

    public Item(String name, int weight, int value, boolean selected) {
      this.name = name;
      this.weight = weight;
      this.value = value;
      this.selected = selected;
    }

    @Override
    public String toString() {
      return "\nItem{" +
          "name='" + name + '\'' +
          ", weight=" + weight +
          ", value=" + value +
          ", selected=" + selected +
          '}';
    }
  }

}
