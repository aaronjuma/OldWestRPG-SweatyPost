/*
 * GameManager.java
 * Contains Bulk of Code to control the game
 * Aaron Jumarang, Benji Magyar-Samoila, Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package game;

import gui.DrawTextBox;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import quest.QuestManager;
import cutscene.Cutscene1;
import cutscene.CutsceneManager;
import cutscene.DialogueBox;
import npc.NPCManager;
import util.Music;
import background.BackgroundControl;
import character.Bullets;
import character.Character;

public class GameManager {
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)((GAME_WIDTH * 3)/4);
	boolean cutscene = false;
	int event = -1;
	
	BackgroundControl background;
	Bullets bullet;
	Character chara;
	NPCManager npc;
	CutsceneManager cutscenes;
	QuestManager quests;
	DialogueBox dialogue;
	DrawTextBox objective;
	DrawTextBox questHelper;
	Music backMusic;
	Music bulletSound;
	boolean bulletActive;
	boolean gameOver;
	
	
	/**
	 * Constructor
	 * Initializes the game
	 * pre : none
	 * post : game starts
	 */
	public GameManager() {
		chara = new Character(GAME_HEIGHT, GAME_WIDTH);
		background = new BackgroundControl(chara.getDetails());
		npc = new NPCManager();
		npc.hide(0);
		objective = new DrawTextBox();
		questHelper = new DrawTextBox();
		questHelper.hide();
		dialogue = new DialogueBox();
		cutscenes = new CutsceneManager(dialogue);
		backMusic = new Music("src/resources/music/backgroundMusic.wav");
		backMusic.play();
		bulletSound = new Music("src/resources/music/gunshot.wav");
		bulletActive = false;
		quests = new QuestManager(chara.getDetails(), npc, questHelper);
		gameOver = false;
	}
	
	
	
	/**
	 * Returns current background image
	 * pre : none
	 * post : image returned
	 */
	public Image background() {
		return background.getBackgroundImage();
	}
	
	
	
	/**
	 * Checks if game is done
	 * pre : none
	 * post : true if game is finished, false if not
	 */
	public boolean isGameOver() {
		return gameOver;
	}
	
	
	
	/**
	 * Draws game objects onto screen
	 * pre : none
	 * post : objects are drawn
	 */
	public void draw(Graphics g){
		chara.draw(g);
		npc.draw(g);
		if(bullet != null){
			bullet.draw(g);
		}
		if(dialogue.isActive() == true){
			dialogue.draw(g);
		}
		objective.draw(g, 10, 10);
		questHelper.draw(g);
		background.drawText(g);
	}
	
	
	
	/**
	 * move game objects
	 * pre : none
	 * post : objects are moving
	 */
	public void move() {
		if(cutscene != true) {
			chara.move();
		}
		
		if(bullet != null){
			bullet.move();
			if(bullet.getX() >= 1000 || bullet.getX() < 0){
				bullet = null;
			}
		}
		
		if(event != 1) { 
			background.move();
		}
		background.checkBoundaries();
	}
	
	
	
	/**
	 * Checks for input
	 * pre : none
	 * post : action is performed based on input
	 */
	public void keyPressed(KeyEvent e) {
		chara.keyPressed(e);
		if(cutscene == false){
			background.keyPressed(e);
		}
		quests.keyPressed(e);
		if(e.getKeyCode()==KeyEvent.VK_Q && bulletActive == true) {
			if(chara.getDetails().getJail() == false && bullet == null){
				bullet = new Bullets(chara.getDetails());
				bulletSound.play();
			}
		}
		cutscenes.checkInput(e);
	}
	
	
	
	/**
	 * Checks for input
	 * pre : none
	 * post : action is performed based on input
	 */
	public void keyReleased(KeyEvent e) {
		chara.keyReleased(e);
		cutscenes.keyReleased(e);
	}
	
	
	
	/**
	 * Storyboard controller for game
	 * pre : none
	 * post : game follows linear story
	 */
	public void check() {
		
		//Initialize
		if(event == -1){
			++event;
			background.switchBackground("BR");
		}
		
		//Cutscene 1 - Sherrif Arrest
		if (event == 0){
			cutscene = true;
			background.showText(false);
			chara.getDetails().setPos(700, chara.getDetails().getY());
			chara.getDetails().setDirection(0);
			Cutscene1 temp = (Cutscene1)cutscenes.getCutscene1();
			temp.getSheriff(npc);
			cutscenes.check();
			if(cutscenes.isDialogueDone() == true) {
				npc.getNPC(4).hide();
				++event;
				background.switchBackground("JC");
			}
		}
		
		//Quest 1 - Escape Jail
		if(event == 1) {
			cutscene = false;
			chara.getDetails().setJail(true);
			objective.setText("New Objective: Escape Jail" +
								"(Hint: Press find a key)");		
			objective.show();
			quests.check("JC");
			if(quests.goal() == true){
				background.showText(true);
				objective.setText("New Objective: Key found! Now escape jail cell");
				background.move();
				if(background.getBackground().getID().equals("JL")){
					quests.questFinished();
				}
			}
			if(quests.isQuestDone() == true){
				++event;
				quests.nextQuest();
			}
		}
		
		//Quest 2 - Find Shifty
		if(event == 2){
			cutscene = false;
			quests.check(background.getBackground().getID());
			objective.setText("New Objective: Find Shifty in the Saloon");
			if(quests.goal()){
				quests.questFinished();
				npc.show(0);
			}
			if(quests.isQuestDone() == true){
				++event;
				background.showText(false);
				cutscenes.nextCutscene();
			}
		}
		
		//Cutscene 2 - Shifty Job
		if(event == 3){
			cutscene = true;
			objective.hide();
			cutscenes.check();
			if(cutscenes.isDialogueDone() == true) {
				++event;
				quests.nextQuest();
				background.showText(true);
			}
		}
		
		//Quest 3 - Go to Hotel, Change
		if(event == 4) {
			objective.setText("New Objective: Get Changed in hotel");
			objective.show();
			if(!background.getBackground().getID().equals("BR")){
				npc.hide(0);
			}
			else{
				npc.show(0);
			}
			cutscene = false;
			quests.check(background.getBackground().getID());
			if(quests.goal() == true){
				chara.getDetails().setJail(false);
				quests.questFinished();
			}
			if(quests.isQuestDone() == true) {
				++event;
				bulletActive = true;
				quests.nextQuest();
			}
			
		}
		
		//Quest 4 - Kill Earps
		if(event == 5) {
			objective.setText("New Objective: Find the Earps and kill them (Press Q to shoot)");
			if(!background.getBackground().getID().equals("RW")){
				for(int i = 1; i <= 3; ++i){
					npc.hide(i);
				}
			}
			else{
				for(int i = 1; i <= 3; ++i){
					if(npc.getNPC(i).dead() == false){
						npc.show(i);
					}
					if(bullet != null){
						if(bullet.intersects(npc.getNPC(i)) && npc.getNPC(i).dead() == false){
							npc.hide(i);
							npc.getNPC(i).die();
							bullet = null;
						}
					}
				}
			}
			if(quests.goal() == true){
				quests.questFinished();
			}
			if(quests.isQuestDone()){
				++event;
				quests.nextQuest();
			}
		}
		
		
		//Quest 5 - Go Back to Shifty
		if(event == 6) {
			objective.setText("New Objective: Go back to Shifty");
			quests.check(background.getBackground().getID());
			if(quests.goal()){
				quests.questFinished();
				npc.show(0);
			}
			if(quests.isQuestDone() == true){
				++event;
				cutscenes.nextCutscene();
				background.showText(false);
				chara.getDetails().setDirection(1);
			}
		}
		
		//Cutscene 3 - Ending
		if(event == 7) {
			objective.hide();
			cutscene = true;
			cutscenes.check();
			if(cutscenes.isDialogueDone() == true) {
				bulletSound.play();
				gameOver = true;
			}
		}
	}
	
	
}
