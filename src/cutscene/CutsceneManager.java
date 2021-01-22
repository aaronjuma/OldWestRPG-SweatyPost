/*
 * CutsceneManager.java
 * Controls Cutscene
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */

package cutscene;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CutsceneManager {

	ArrayList<Cutscene> cutscenes;
	int currentCutscene;
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : cutsceneManager object created
	 */
	public CutsceneManager(DialogueBox box) {
		cutscenes = new ArrayList<Cutscene>();
		cutscenes.add(new Cutscene1(box));
		cutscenes.add(new Cutscene2(box));
		cutscenes.add(new Cutscene3(box));
		currentCutscene = 0;
	}
	
	
	
	/**
	 * Runs cutscene code
	 * pre : none
	 * post : cutscene is running
	 */
	public void check() {
		cutscenes.get(currentCutscene).check();
	}
	
	
	
	/**
	 * Goes to next cutscene
	 * pre : none
	 * post : current cutscene is now the next cutscene
	 */
	public void nextCutscene() {
		++currentCutscene;
	}
	
	
	
	/**
	 * Checks input
	 * pre : none
	 * post : action is performed based on input
	 */
	public void checkInput(KeyEvent e){
		cutscenes.get(currentCutscene).checkInput(e);
	}
	
	
	
	/**
	 * Checks input
	 * pre : none
	 * post : action is performed based on input
	 */
	public void keyReleased(KeyEvent e) {
		cutscenes.get(currentCutscene).keyReleased(e);
	}
	
	
	
	/**
	 * Checks if dialogue is done
	 * pre : none
	 * post : true if dialogue is done, false if not
	 */
	public boolean isDialogueDone() {
		return cutscenes.get(currentCutscene).isDialogueDone();
	}
	
	
	
	/**
	 * Special method for first cutscene
	 * Note : Cutscene1 was buggy and needed this method
	 * pre : none
	 * post : return cutscene1
	 */
	public Cutscene getCutscene1() {
		return cutscenes.get(currentCutscene);
	}
}
