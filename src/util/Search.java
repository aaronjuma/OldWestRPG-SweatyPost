/*
 * Search.java
 * Binary Searches an Array for an item
 * Aaron Jumarang
 * Jan 26 2021
 * ICS4U
 */
package util;

import java.util.ArrayList;

public class Search {
	
	/**
	* Searches items array for goal
	* pre: items is sorted from low to high
	* post: Position of goal has been returned,
	* or -1 has been returned if goal not found.
	*/
	public static <T extends Comparable<? super T>> int binarySearch(ArrayList<T> items, int start, int end, T goal) {
		if (start> end) {
			return(-1);
		}
		else {
			int mid =(start + end) / 2;
			
			int temp = goal.compareTo(items.get(mid));
			if (temp == 0) {
				return(mid);
			}
			else if (temp < 0) {
				return(binarySearch(items, start, mid-1, goal));
			}
			else {
				return(binarySearch(items, mid+1, end, goal));
			}
		}
	}

}
