package edu.polymath.raval.dynamicProgramming;

import static org.junit.Assert.*;

import edu.polymath.raval.dynamicProgramming.WeightedJobScheduling.Job;
import edu.polymath.raval.dynamicProgramming.WeightedJobScheduling.JobOutput;
import org.junit.Test;

public class WeightedJobSchedulingTest {

  @Test
  public void chooseJobsForMaximumProfit() throws Exception {
    Job a=new Job("a",1,4,3);
    Job b=new Job("b",2,6,5);
    Job c=new Job("c",4,7,2);
    Job d=new Job("d",5,9,4);
    Job e=new Job("e",6,8,6);
    Job f=new Job("f",7,10,8);
    WeightedJobScheduling weightedJobScheduling = new WeightedJobScheduling();
    JobOutput jobOutput = weightedJobScheduling.chooseJobsForMaximumProfit(new Job[]{a,b,c,d,e,f});
    System.out.println(jobOutput.totalProfit);
    System.out.println(jobOutput.selectedJobs);

  }

}