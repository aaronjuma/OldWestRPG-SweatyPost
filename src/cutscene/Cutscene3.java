/*
 * Cutscene3.java
 * Controls third cutscene
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */

package cutscene;

public class Cutscene3 extends Cutscene {

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
	 * post ; cutscene3 object created
	 */
	public Cutscene3(DialogueBox box) {
		super(box);
		setDialogue(dialogueList);
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
