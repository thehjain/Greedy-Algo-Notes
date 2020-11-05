//Here we have arrival and deparature time of trains
//we have to find minimum number of platform required
//so that no two traing timing clashes with each other.

//Basic approach is to run two loop and check the intersecting
//interval and keep updating max value it will give the solution in
//O(n^2).

//Efficient approach is to use greedy approach and keep the track of
//arrival trains but not yet departed and update the mac value accordingly.


// arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
// dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}

// All events are sorted by time.
// Total platforms at any time can be obtained by
// subtracting total departures from total arrivals
// by that time.

//  Time      Event Type     Total Platforms Needed
//                                at this Time
//  9:00       Arrival                  1
//  9:10       Departure                0
//  9:40       Arrival                  1
//  9:50       Arrival                  2
//  11:00      Arrival                  3
//  11:20      Departure                2
//  11:30      Departure                1
//  12:00      Departure                0
//  15:00      Arrival                  1
//  18:00      Arrival                  2
//  19:00      Departure                1
//  20:00      Departure                0

// Minimum Platforms needed on railway station
// = Maximum platforms needed at any time
// = 3




import java.util.*;
class MinimumNumberOfPlatforms {
	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		int n = arr.length;

		System.out.println("Minimum Number of Platforms Required = "
		                   + findPlatform(arr, dep, n));

	}

	static int findPlatform(int[] arr, int[] dep, int n) {

		Arrays.sort(arr);
		Arrays.sort(dep);

		int plat_needed = 1, res = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {

			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;
			} else if (arr[i] > dep[j]) {
				plat_needed--;
				j++;
			}
			if (plat_needed > res)
				res = plat_needed;
		}

		return res;
	}

}


//Problem is available on geeksforgeeks