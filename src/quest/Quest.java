package quest;

import character.CharacterDetails;
import background.Background;


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
	
	public String getTarget() {
		return targetBG;
	}
	
}
