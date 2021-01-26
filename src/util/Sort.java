/*
 * Sort.java
 * Sort an array of objects that are comparable
 * Aaron Jumarang
 * Jan 26 2021
 * ICS4U
 */
package util;

import java.util.ArrayList;

public class Sort {

	
	
	/**
	* Sorts items [start .. end]
	* pre: start > 0, end > 0
	* post: items[start .. end] is sorted low to high
	*/
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> items, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(items, start, mid);
			mergesort(items, mid + 1, end);
			merge(items, start, mid, end);
		}
	}
	
	
	
	/**
	* Merges two sorted portion of items array
	* pre: items[start .. mid] is sorted. items[mid+1 .. end] sorted.
	* start <= mid <= end
	* post: items[start .. end] is sorted.
	*/
	private static <T extends Comparable<? super T>>  void merge(ArrayList<T> items, int start, int mid, int end) {
		
		//Creates temporary array
		int size = items.size();
		ArrayList<T> temp = new ArrayList<T>(size);
		
		//To allocate space for temp array
		for (int i = 0; i < size; i++) {
			  temp.add(null);
		}
		
		
		int pos1 = start;
		int pos2 = mid + 1;
		int spot = start;
		while (!(pos1 > mid && pos2 > end)) {
			if((pos1>mid)||((pos2<=end) &&( items.get(pos2).compareTo(items.get(pos1)) < 0))) {
				temp.set(spot, items.get(pos2));
				pos2 += 1;
			}
			else {
				temp.set(spot, items.get(pos1));
				pos1 += 1;
			}
			spot += 1;
		}
		/* copy values from temp back to items */
		for (int i = start; i <= end; i++) {
			items.set(i, temp.get(i));
		}
	}
	
}

