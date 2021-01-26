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
			"Ya back! I'm asummin ya finished the job.",
			"Good on ya lil buddy.",
			"With the Earps gone, the Daltons control this town now",
			"That reminds me, I forgot to mention that the Earp are \ncelebrities in this area",
			"Sorry lil Slimy, but I forgot to mention this part of the plan",
			"But if we kill the person who killed the Earps, we will be seen as heroes\nto the people here",
			"They won't know who you are, heck they won't even know you was a Dalton",
			"Sorry lil bro, nothing personal"
	};
	
	
	/**
	 * Constructor
	 * pre : none
	 * post ; cutscene3 object created
	 */
	public Cutscene3(DialogueBox box) {
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
		if(currentDialogue < dialogueList.length){
			box.queue(dialogueList[currentDialogue]);
		}
	}
}
