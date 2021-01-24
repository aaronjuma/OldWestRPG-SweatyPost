/*
 * Cutscene2.java
 * Constrols second cutscene
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */

package cutscene;

public class Cutscene2 extends Cutscene {

	String[] dialogueList = {
			"Well, well, well. How ya doin my lil' brother from another mother",
			"I got word from our neighbours from the East that\n some hooligans fled Millworth",
			"From what I wreckon, you look like you was from the East",
			"Just to be safe, come with me, don't bother resisting",
			"I won't hesitate to kill you"
	};
	
	
	/**
	 * Constructor
	 * pre : none
	 * post ; cutscene2 object created
	 */
	public Cutscene2(DialogueBox box) {
		super(box);
		setDialogue(dialogueList);
		setAnimation(false);
	}
	
	
	
	/**
	 * Runs cutscene
	 * pre : none
	 * post : cutscene is running
	 */
	public void check() {
		if(currentDialogue < 5){
			box.queue(dialogueList[currentDialogue]);
		}
	}
}
