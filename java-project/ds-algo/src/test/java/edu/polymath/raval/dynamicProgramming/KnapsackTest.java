package edu.polymath.raval.dynamicProgramming;

import edu.polymath.raval.dynamicProgramming.Knapsack.Item;
import java.util.Arrays;
import org.junit.Test;

public class KnapsackTest {

  @Test
  public void chooseItems() throws Exception {
    Knapsack knapsack = new Knapsack();
    Item[] items = new Item[]{
        new Item("a", 2, 3, false),
        new Item("b", 3, 5, false),
        //new Item("c",3,4, false),
        //new Item("d",4,5, false),
        new Item("e", 5, 10, false),
        new Item("e", 6, 9, false),
        new Item("e", 7, 6, false),
    };
    knapsack.chooseItems(items, 9);
    System.out.println(Arrays.toString(items));
  }

}