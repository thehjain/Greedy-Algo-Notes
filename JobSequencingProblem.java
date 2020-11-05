//Here we have given job with deadline and profit
//and we have to maximize the profit.

import java.util.*;

class JobSequencingProblem {
	public static void main(String[] args) {

		ArrayList<Job> arr = new ArrayList<Job>();

		arr.add(new Job('a', 2, 100));
		arr.add(new Job('b', 1, 19));
		arr.add(new Job('c', 2, 27));
		arr.add(new Job('d', 1, 25));
		arr.add(new Job('e', 3, 15));

		System.out.println("Following is maximum "
		                   + "profit sequence of jobs");
		printJobs(arr, 3);

	}

	static void printJobs(ArrayList<Job> arr, int time) {

		int n = arr.size();
		Collections.sort(arr, (a, b)-> b.profit - a.profit);

		boolean[] res = new boolean[time];
		char[] job = new char[time];

		for (int i = 0; i < n; i++) {
			for (int j = Math.min(time - 1, arr.get(i).deadline - 1); j >= 0; j--) {
				if (!res[j]) {
					res[j] = true;
					job[j] = arr.get(i).id;
					break;
				}
			}
		}
		for (char ele : job) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

}

class Job {
	char id;
	int deadline, profit;
	Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
}


//Problem is available on geeksforgeeks