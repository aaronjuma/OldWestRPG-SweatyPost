package util;

import java.util.ArrayList;

public class LinearSearch<E> {

	ArrayList<E> list;
	
	public LinearSearch(ArrayList<E> list) {
		this.list = list;
	}
	
	public int searchFor(String o) {
		int returnValue = -1;
		
		for(int i = 0; i < list.size(); ++i){
			if(list.get(i).toString().equals(o)) {
				returnValue = i;
			}
		}
		
		return returnValue;
	}
}
