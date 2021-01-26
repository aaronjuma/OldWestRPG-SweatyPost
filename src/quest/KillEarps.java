/*
 * KillEarps.java
 * Controls Kill Earps quest
 * Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

import java.awt.event.KeyEvent;
import character.CharacterDetails;
import npc.NPCManager;

public class KillEarps extends Quest{

	boolean inTarget;
	NPCManager npc;
	
	
	
	/**
	 * Constructor
	 * pre : npcs must be created
	 * post : Kill Earps quest created
	 */
	public KillEarps(NPCManager npc) {
		super("RW");
		inTarget = false;
		this.npc = npc;
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
		boolean returnValue = true;
		for(int i = 1; i <= 3; ++i){
			if(npc.getNPC(i).dead() == false){
				returnValue = false;
			}
		}
		return returnValue;
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
