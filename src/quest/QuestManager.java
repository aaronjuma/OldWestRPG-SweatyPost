package quest;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import npc.NPCManager;

import character.CharacterDetails;

public class QuestManager {

	CharacterDetails details;
	ArrayList<Quest> quests;
	
	int currentQuest;
	
	public QuestManager(CharacterDetails details, NPCManager npc) {
		this.details = details;
		quests = new ArrayList<Quest>();
		currentQuest = 0;
		quests.add(new EscapeJail());
		quests.add(new FindShifty());
		quests.add(new HotelChange());
		quests.add(new KillEarps(npc));
		quests.add(new ReturnShifty());
	}
	
	/**
	 * checks if a key is pressed
	 * pre : none
	 * post : sets a boolean value to the key
	 */
	public void keyPressed(KeyEvent e) {
		if(currentQuest == 0 || currentQuest == 2){
			quests.get(currentQuest).checkInput(details, e);
		}
	}
	
	
	public boolean goal() {
		return quests.get(currentQuest).goal();
	}
	
	
	public void nextQuest() {
		++currentQuest;
	}
	
	public boolean isQuestDone() {
		return quests.get(currentQuest).isQuestDone();
	}
	
	public void questFinished() {
		quests.get(currentQuest).questFinished();
	}
	
	public void check(String ID) {
		quests.get(currentQuest).check(ID);
	}
}
