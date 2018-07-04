package edu.polymath.raval.dynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;

public class WeightedJobScheduling {

  public JobOutput chooseJobsForMaximumProfit(Job[] interestJobs) {
    Arrays.sort(interestJobs, (o1, o2) -> Integer.compare(o1.endHour, o2.endHour));
    JobOutput[] jobOutputs = setJobOutput(interestJobs);

    for (int i = 1; i < interestJobs.length; i++) {
      for (int j = 0; j < i; j++) {
        if (!isOverlapping(interestJobs[i], interestJobs[j])) {
          if ((jobOutputs[i].totalProfit < interestJobs[i].profit + jobOutputs[j].totalProfit) ||
              (jobOutputs[i].totalProfit == interestJobs[i].profit + jobOutputs[j].totalProfit
                  && jobOutputs[i].selectedJobs.size() < jobOutputs[j].selectedJobs.size() + 1 )){
            jobOutputs[i].selectedJobs.clear();
            jobOutputs[i].selectedJobs.add(interestJobs[i]);
            jobOutputs[i].selectedJobs.addAll(jobOutputs[j].selectedJobs);
            jobOutputs[i].totalProfit = interestJobs[i].profit + jobOutputs[j].totalProfit;
          }
        }
      }
    }

    JobOutput maximumProfit = jobOutputs[0];
    for (int i = 1; i < jobOutputs.length; i++) {
      maximumProfit =
          maximumProfit.totalProfit >= jobOutputs[i].totalProfit ? maximumProfit : jobOutputs[i];
    }
    return maximumProfit;
  }

  private boolean isOverlapping(Job job1, Job job2) {
    return job1.endHour > job2.endHour ?
        job2.endHour > job1.startHour :
        job1.endHour > job2.startHour;
  }

  private JobOutput[] setJobOutput(Job[] interestJobs) {
    JobOutput[] jobOutputs = new JobOutput[interestJobs.length];
    for (int i = 0; i < interestJobs.length; i++) {
      jobOutputs[i] = new JobOutput();
      jobOutputs[i].selectedJobs.add(interestJobs[i]);
      jobOutputs[i].totalProfit = interestJobs[i].profit;
    }
    return jobOutputs;
  }


  public static class Job {

    String name;
    int startHour;
    int endHour;
    int profit;

    public Job(String name, int startHour, int endHour, int profit) {
      this.name = name;
      this.startHour = startHour;
      this.endHour = endHour;
      this.profit = profit;
    }

    @Override
    public String toString() {
      return "Job{" +
          "name='" + name + '\'' +
          '}';
    }
  }

  public static class JobOutput {

    LinkedList<Job> selectedJobs = new LinkedList<>();
    int totalProfit;
  }
}
