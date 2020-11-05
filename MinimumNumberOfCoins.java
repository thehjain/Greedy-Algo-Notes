//Here we have currency notes with different value
//and we have to find the minimum number notes or coins
//needed to complete the given number.

//Basic greedy approach is to start with maximum value coin
//and keep iterating accordingly till we find our value.

//But greedy approach is not going to always be optimal.
//It depends on currency. Dynamic programming approach is
//always going to be optimal

import java.util.Vector;

class MinimumNumberOfCoins {

	// All denominations of Indian Currency
	static int deno[] = {1, 2, 5, 10, 20,
	                     50, 100, 500, 1000
	                    };
	static int n = deno.length;

	static void findMin(int V) {
		// Initialize result
		Vector<Integer> ans = new Vector<>();

		// Traverse through all denomination
		for (int i = n - 1; i >= 0; i--) {
			// Find denominations
			while (V >= deno[i]) {
				V -= deno[i];
				ans.add(deno[i]);
			}
		}

		// Print result
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(
			    " " + ans.elementAt(i));
		}
	}

	// Driver code
	public static void main(String[] args) {
		int n = 93;
		System.out.print(
		    "Following is minimal number "
		    + "of change for " + n + ": ");
		findMin(n);
	}
}


//Problem is available on geeksforgeeks