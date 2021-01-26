/*
 * QuestManager.java
 * Manages all Quests
 * Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

import gui.DrawTextBox;
import java.awt.event.KeyEvent;
import util.Queue;
import npc.NPCManager;
import character.CharacterDetails;

public class QuestManager {

	CharacterDetails details;
	Queue<Quest> quests;
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : Quest Manager created
	 */
	public QuestManager(CharacterDetails details, NPCManager npc, DrawTextBox helper) {
		this.details = details;
		quests = new Queue<Quest>();
		quests.enqueue(new EscapeJail(helper));
		quests.enqueue(new FindShifty());
		quests.enqueue(new HotelChange(helper));
		quests.enqueue(new KillEarps(npc));
		quests.enqueue(new ReturnShifty());
	}
	
	
	
	/**
	 * checks if a key is pressed
	 * pre : none
	 * post : action performed based on key
	 */
	public void keyPressed(KeyEvent e) {
		quests.front().checkInput(details, e);
	}
	
	
	
	/**
	 * Checks if quest goal has been reached
	 * pre : none
	 * post : true if quest goal is reached, false if not
	 */
	public boolean goal() {
		return quests.front().goal();
	}
	
	
	
	/**
	 * Goes to next Quest
	 * pre : none
	 * post : sets the quest to the next one in queue
	 */
	public void nextQuest() {
		quests.dequeue();
	}
	
	
	
	/**
	 * Checks if quest is done
	 * pre : none
	 * post : true if quest is done, false if not
	 */
	public boolean isQuestDone() {
		return quests.front().isQuestDone();
	}
	
	
	
	/**
	 * Finishes a quest
	 * pre : none
	 * post : quest is finished
	 */
	public void questFinished() {
		quests.front().questFinished();
	}
	
	
	
	/**
	 * Calls continuously to check on quest 
	 * pre : none
	 * post : quest is checked
	 */
	public void check(String ID) {
		quests.front().check(ID);
	}
}
