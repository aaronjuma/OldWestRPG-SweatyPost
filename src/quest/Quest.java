package quest;

import java.awt.event.KeyEvent;

import character.CharacterDetails;

public class Quest {
	boolean isQuestFinished;
	String targetBG;
	
	
	public Quest(String targetBG) {
		this.targetBG = targetBG;
	}
	
	public boolean isQuestDone() {
		return isQuestFinished;
	}
	
	public void questFinished() {
		isQuestFinished = true;
	}
	
	public void check(String ID) {
		
	}
	
	public void checkInput(CharacterDetails details, KeyEvent e){
		
	}
	
	public String getTarget() {
		return targetBG;
	}
	
	public boolean goal() {
		return false;
	}
}
