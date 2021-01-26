/*
 * Quest.java
 * Superclass for all quest objects
 * Aaron Jumarang, Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

import java.awt.event.KeyEvent;
import character.CharacterDetails;

public abstract class Quest {
	
	boolean isQuestFinished;
	String targetBG;
	
	
	/**
	 * Constructor
	 * pre : target must have same ID as one of the backgrounds
	 * post : Quest is created
	 */
	public Quest(String targetBG) {
		this.targetBG = targetBG;
	}
	
	
	
	/**
	 * Returns if quest is done
	 * pre : none
	 * post : true if quest is done, false if not
	 */
	public boolean isQuestDone() {
		return isQuestFinished;
	}
	
	
	
	/**
	 * Finshes a quest
	 * pre : none
	 * post : quest is set to finished
	 */
	public void questFinished() {
		isQuestFinished = true;
	}
	
	
	
	/**
	 * Empty method that gets defined by subclasses
	 * pre : none
	 * post : none
	 */
	abstract void check(String ID);
	
	
	
	/**
	 * Empty method that gets defined by subclasses
	 * pre : none
	 * post : none
	 */
	abstract void checkInput(CharacterDetails details, KeyEvent e);
	
	
	
	/**
	 * Returns the target backgrounds
	 * pre : none
	 * post : target background is returned
	 */
	public String getTarget() {
		return targetBG;
	}
	
	
	
	/**
	 * Returns the goal, defined by the subclasses
	 * pre : none
	 * post : none
	 */
	abstract boolean goal();
}
