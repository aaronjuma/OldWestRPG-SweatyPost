package quest;

import java.awt.event.KeyEvent;

import character.CharacterDetails;

public class QuestManager {

	CharacterDetails details;
	
	public QuestManager(CharacterDetails details) {
		this.details = details;
		EscapeJail jailQuest = new EscapeJail();
	}
	
	/**
	 * checks if a key is pressed
	 * pre : none
	 * post : sets a boolean value to the key
	 */
	public void keyPressed(KeyEvent e) {
//		jailQuest.checkInput
	}
	
}
