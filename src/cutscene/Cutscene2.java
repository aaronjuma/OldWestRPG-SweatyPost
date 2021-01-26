/*
 * Cutscene2.java
 * Controls second cutscene
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package cutscene;

public class Cutscene2 extends Cutscene {

	String[] dialogueList = {
			"Well, well, well. How ya doin my lil' brother from another mother",
			"I got junior Sneaky to sneak a key in your cell, \nthat fella is one sneaky fool",
			"Anways, now that you are here, I got a job for you",
			"As you know, the Earps run this town and they are pain. They have \nthe sheriff on their side, the bank, and they control this town",
			"I want you to kill them, Let's show them the power of the Dalton Brothers",
			"Here's a key to the hotel, get changed there",
			"I got big Snitchy to fix you your suit and your favourite shooter",
			"After you change, head to the railway station",
			"The junior Earps, Morgan and Wyatt are doin some funny business down \nthere",
			"I reckon there are more of those Earp twats, quietly kill em.",
			"Let's not disturb the citizens on our first week here",
			"This place feels better than Millworth, I'm tellin ya"
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
		if(currentDialogue < dialogueList.length){
			box.queue(dialogueList[currentDialogue]);
		}
	}
}
