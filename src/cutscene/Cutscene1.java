/*
 * Cutscene1.java
 * Controls first cutscene
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */

package cutscene;

import npc.NPC;
import npc.NPCManager;

public class Cutscene1 extends Cutscene {

	NPC sheriff;
	String[] dialogueList = {
			"So, so, so. I see a new face in town.\nI'm the sheriff of this town",
			"I got word from our neighbours from the East that\n some hooligans fled Millworth",
			"From what I wreckon, you look like you was from the East",
			"Just to be safe, come with me, don't bother resisting",
			"I won't hesitate to kill you"
	};
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : Cutscene1 object created
	 */
	public Cutscene1(DialogueBox box) {
		super(box);
		setDialogue(dialogueList);
	}
	
	
	
	/**
	 * Loop code that controls cutscene
	 * pre : none
	 * post : cutscene is running
	 */
	public void check() {
		if(sheriff.getX() < 400) {
			moveSheriff();
		}
		else{
			if(currentDialogue < 5){
				box.queue(dialogueList[currentDialogue]);
			}
		}
	}
	
	
	
	/**
	 * Obtains sheriff NPC to control
	 * pre : none
	 * post : sheriff NPC is obtained
	 */
	public void getSheriff(NPCManager npc) {
		sheriff = npc.getNPC(4);
	}
	
	
	
	/**
	 * Moves sheriff
	 * pre : none
	 * post : sheriff is moving
	 */
	public void moveSheriff() {
		sheriff.setX(sheriff.getX()+2);
	}
}
