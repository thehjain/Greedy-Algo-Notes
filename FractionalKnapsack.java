//Here we have given items with their value.
//And we have limited capacity bag and limited items. So
//we have to choose items in such a way that give maixmum value
//accoriding to weight.


//Point to be noted here is that we can break the items and
//take fractional value so that means greedy approach will
//always give optimal solution.

import java.util.*;
class FractionalKnapsack {
	public static void main(String[] args) {

		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };
		int capacity = 50;

		double maxValue = findMax(wt, val, capacity);

		System.out.println(maxValue);
	}

	static double findMax(int[] wt, int[] val, int capacity) {

		Item[] arr = new Item[wt.length];

		for (int i = 0; i < wt.length; i++)
			arr[i] = new Item(wt[i], val[i], i);

		Arrays.sort(arr, new Comparator<Item>() {
			@Override
			public int compare(Item a, Item b) {
				return b.cost.compareTo(a.cost);
			}
		});

		double totalValue = 0d;

		for (Item ele : arr) {
			int currWt = (int)ele.wt;
			int currVal = (int)ele.val;

			if (capacity - currWt >= 0) {
				capacity -= currWt;
				totalValue += currVal;
			} else {
				double fraction = (double)capacity / (double)currWt;
				totalValue += currVal * fraction;
				capacity = (int)(capacity - (currWt * fraction));
				break;
			}

		}
		return totalValue;
	}

}

class Item {
	int index;
	double wt, val;
	Double cost;
	Item(int wt, int val, int index) {
		this.wt = wt;
		this.val = val;
		this.index = index;
		this.cost = new Double(Double.valueOf(val / wt));
	}

}

//Problem is available on geeksforgeeks