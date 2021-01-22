package cutscene;

import java.awt.event.KeyEvent;


public class Cutscene {

	String[] dialogue;
	public int currentDialogue;
	boolean spaceClicked;
	DialogueBox box;
	
	public Cutscene(DialogueBox box) {
		currentDialogue = 0;
		this.box = box;
	}
	
	public void setDialogue(String[] dialogue) {
		this.dialogue = dialogue;
	}
	
	public void check() {
		if(currentDialogue != dialogue.length){
			box.queue(dialogue[currentDialogue]);
		}
	}
	
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
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			spaceClicked = false;
		}
	}
	
	public boolean isDialogueDone() {
		if(currentDialogue == dialogue.length){
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
