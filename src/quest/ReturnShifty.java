/*
 * ReturnShifty.java
 * Controls Return Shifty quest
 * Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

public class ReturnShifty extends Quest{


	boolean inTarget;
	
	public ReturnShifty() {
		super("BR");
		inTarget = false;
	}

	public void check(String ID) {
		if(targetBG.equals(ID)){
			inTarget = true;
		}
	}
	
	public boolean goal() {
		return inTarget;
	}
}
