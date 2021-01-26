/*
 * Stack.java
 * Stack data structure
 * Aaron Jumarang
 * Jan 26 2021
 * ICS4U
 */
package util;

import java.util.ArrayList;

public class Stack<E> {
	private ArrayList<E> data;
	
	
	/**
	* constructor
	* pre: none
	* post: An empty stack is created
	*/
	public Stack() {
		data = new ArrayList<E>();
	}
	
	
	
	/**
	* Returns the top item without removing it from the stack.
	* pre: Stack contains at least one item.
	* post: The top item has been returned while leaving it
	* on the stack.
	*/
	public E top() {
		return(data.get(data.size() - 1));
	}
	
	
	
	/**
	* Removes the top item from the stack and returns it.
	* pre: Stack contains at least one item.
	* post: The top item of the stack has been removed
	* and returned.
	*/
	public E pop() {
		E returnValue = top();
		data.remove(data.size() -1);
		return returnValue;
	}
	
	
	
	/**
	* Adds an item to the top of the stack if there is room.
	* pre: none
	* post: A new item has been added to the top of the stack.
	*/
	public void push(E obj) {
		data.add(obj);
	}
	
	
	
	/**
	* Determines if there are items on the stack.
	* pre: none
	* post: true returned if there are items on the stack,
	* false returned otherwise.
	*/
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	
	
	/**
	* Returns the number of items in the stack.
	* pre: none
	* post: The number of items in the stack is returned.
	*/
	public int size() {
		return data.size();
	}
	
	
	
	/**
	* Empties the stack.
	* pre: none
	* post: There are no items in the stack.
	*/
	public void makeEmpty() {
		data.clear();
	}
}
