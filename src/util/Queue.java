/*
 * Queue.java
 * Queue data structure
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package util;

import java.util.ArrayList;

public class Queue<E> {
	private ArrayList<E> data;
	
	
	/**
	* constructor
	* pre: none
	* post: An empty queue that can hold up to maxItems
	* has been created.
	*/
	public Queue() {
		data = new ArrayList<E>();
	}
	
	
	
	/**
	* Returns the front item without removing it from
	* the queue.
	* pre: Queue contains at least one item.
	* post: The front item has been returned while leaving
	* it in the queue.
	*/
	public E front() {
		return(data.get(0));
	}
	
	
	
	/**
	* Removes the front item from the queue and returns it.
	* pre: Queue contains at least one item.
	* post: The front item of the queue has been removed
	* and returned.
	*/
	public E dequeue() {
		E num;
		num = data.get(0); //get front item
		data.remove(0);
		return(num);
	}
	
	
	
	/**
	* Adds an item to the queue if there is room.
	* pre: none
	* post: A new item has been added to the queue.
	*/
	public void enqueue(E num) {
		data.add(num);
	}
	
	
	
	/**
	* Determines if there are items on the queue.
	* pre: none
	* post: true returned if there are items on the queue,
	* false returned otherwise.
	*/
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	
	
	/**
	* Returns the number of items in the queue.
	* pre: none
	* post: The number of items in the queue is returned.
	*/
	public int size() {
		return data.size();
	}
	
	
	
	/**
	* Empties the queue.
	* pre: none
	* post: There are no items in the queue.
	*/
	public void makeEmpty() {
		data.clear();
	}
}
