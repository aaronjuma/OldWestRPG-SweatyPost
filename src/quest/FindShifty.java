/*
 * FindShifty.java
 * Controls Finding Shifty quest
 * Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

import java.awt.event.KeyEvent;
import character.CharacterDetails;

public class FindShifty extends Quest{

	boolean inTarget;
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : Find Shifty quest created
	 */
	public FindShifty() {
		super("BR");
		inTarget = false;
	}

	
	
	/**
	 * Continiously checks if quest is done
	 * pre : none
	 * post : turns inTarget to true if user is in target area
	 */
	public void check(String ID) {
		if(targetBG.equals(ID)){
			inTarget = true;
		}
	}
	
	
	
	/**
	 * Returns if quest goal is achieved
	 * pre : none
	 * post : true if quest goal is achieved, false if not
	 */
	public boolean goal() {
		return inTarget;
	}



	/**
	 * Checks for input
	 * pre : none
	 * post : action performed based on input
	 */
	void checkInput(CharacterDetails details, KeyEvent e) {
		//Nothing
	}
}
