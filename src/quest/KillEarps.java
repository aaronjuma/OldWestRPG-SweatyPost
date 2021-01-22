package quest;

import npc.NPCManager;

public class KillEarps extends Quest{

	boolean inTarget;
	
	public KillEarps() {
		super("RW");
		inTarget = false;
	}

	public void check(String ID) {
		if(targetBG.equals(ID)){
			inTarget = true;
		}
	}
	
	public boolean allDead(NPCManager npc) {
		boolean returnValue = true;
		for(int i = 1; i <= 3; ++i){
			if(npc.getNPC(i).dead() == false){
				returnValue = false;
			}
		}
		return returnValue;
	}
}
