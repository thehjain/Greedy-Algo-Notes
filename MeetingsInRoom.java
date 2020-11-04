
//N meeting in a room

//Here we have given the start and finish timing of N
//meeting in room. We have to check the maximum number
//of meeting possible in that room.

//We will solve this problem using greedy approach

import java.util.*;
import java.io.*;
import java.math.*;

class Meeting {
	int start, end, pos;
	Meeting(int start, int end, int pos) {
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}

class MyComparator implements Comparator<Meeting> {
	public int compare(Meeting a, Meeting b) {
		return a.end - b.end;
	}
}

class MeetingsInRoom {
	public static void main(String[] args) {

		int s[] = { 1, 3, 0, 5, 8, 5 };
		int f[] = { 2, 4, 6, 7, 9, 9 };

		ArrayList<Meeting> arr = new ArrayList<>();

		for (int i = 0; i < s.length; i++) {
			arr.add(new Meeting(s[i], f[i], i));
		}

		maxMeetings(arr, arr.size());

	}

	static void maxMeetings(ArrayList<Meeting> arr, int n) {

		ArrayList<Integer> res = new ArrayList<>();
		int time_limit = 0;

		Collections.sort(arr, new MyComparator());

		res.add(arr.get(0).pos);

		time_limit = arr.get(0).end;

		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i).start > time_limit) {
				res.add(arr.get(i).pos);
				time_limit = arr.get(i).end;
			}
		}
		for (int i = 0; i < res.size(); i++)
			System.out.print((res.get(i) + 1) + " ");
		System.out.println();
	}

}

//Problem is available on geeksforgeeks