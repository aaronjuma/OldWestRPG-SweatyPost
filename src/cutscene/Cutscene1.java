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
			"So, so, so. You look like you was new in town. I'm the sheriff.",
			"I got word from our neighbours from the East that\n some hooligans fled Millworth.",
			"From what I wreckon, you look like you was from the East.",
			"I reckon you come with me, don't bother resisting.",
			"I won't hesitate to kill you."
	};
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : Cutscene1 object created
	 */
	public Cutscene1(DialogueBox box) {
		super(box);
		setDialogue(dialogueList);
		setAnimation(true);
	}
	
	
	
	/**
	 * Loop code that controls cutscene
	 * pre : none
	 * post : cutscene is running
	 */
	public void check() {
		if(sheriff.getX() < 300) {
			moveSheriff();
		}
		else{
			if(currentDialogue < 5){
				setAnimation(false);
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
