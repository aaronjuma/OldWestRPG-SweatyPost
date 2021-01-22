/*
 * KillEarps.java
 * Controls Kill Earps quest
 * Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

import npc.NPCManager;

public class KillEarps extends Quest{

	boolean inTarget;
	NPCManager npc;
	
	public KillEarps(NPCManager npc) {
		super("RW");
		inTarget = false;
		this.npc = npc;
	}

	public void check(String ID) {
		if(targetBG.equals(ID)){
			inTarget = true;
		}
	}
	
	public boolean goal() {
		boolean returnValue = true;
		for(int i = 1; i <= 3; ++i){
			if(npc.getNPC(i).dead() == false){
				returnValue = false;
			}
		}
		return returnValue;
	}
	
	
}
