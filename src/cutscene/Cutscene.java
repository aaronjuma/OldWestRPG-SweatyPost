/*
 * Cutscene.java
 * Superclass for cutscenes object
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package cutscene;

import java.awt.event.KeyEvent;

public class Cutscene {

	String[] dialogue;
	public int currentDialogue;
	boolean spaceClicked;
	DialogueBox box;
	
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : Cutscene object created
	 */
	public Cutscene(DialogueBox box) {
		currentDialogue = 0;
		this.box = box;
	}
	
	
	
	/**
	 * Set text to dialogue
	 * pre : none
	 * post : dialogue is set
	 */
	public void setDialogue(String[] dialogue) {
		this.dialogue = dialogue;
	}
	
	
	
	/**
	 * Queues next string to dialogue
	 * pre : none
	 * post : string is queued
	 */
	public void check() {
		if(currentDialogue != dialogue.length){
			box.queue(dialogue[currentDialogue]);
		}
	}
	
	
	
	/**
	 * Checks input
	 * pre : none
	 * post : displays next dialogue
	 */
	public void checkInput(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			if(spaceClicked != true){
				spaceClicked = true;
				if(currentDialogue < dialogue.length){
					++currentDialogue;
				}
			}
		}
		
	}
	
	
	
	/**
	 * Checks input, also makes sure that space can't be spammed
	 * pre : none
	 * post : prevents space from being spammed
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			spaceClicked = false;
		}
	}
	
	
	
	/**
	 * Checks if dialogue is done
	 * pre : none
	 * post : true if dialogue is done, false if not
	 */
	public boolean isDialogueDone() {
		if(currentDialogue == dialogue.length){
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
