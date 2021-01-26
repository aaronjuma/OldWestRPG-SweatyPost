/*
 * CutsceneManager.java
 * Manages all the cutscenes
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package cutscene;

import java.awt.event.KeyEvent;
import util.Stack;

public class CutsceneManager {

	Stack<Cutscene> cutscenes;
	
	/**
	 * Constructor
	 * pre : none
	 * post : cutsceneManager object created
	 */
	public CutsceneManager(DialogueBox box) {
		cutscenes = new Stack<Cutscene>();
		cutscenes.push(new Cutscene3(box));
		cutscenes.push(new Cutscene2(box));
		cutscenes.push(new Cutscene1(box));
	}
	
	
	
	/**
	 * Runs cutscene code
	 * pre : none
	 * post : cutscene is running
	 */
	public void check() {
		cutscenes.top().check();
	}
	
	
	
	/**
	 * Goes to next cutscene
	 * pre : none
	 * post : current cutscene is now the next cutscene
	 */
	public void nextCutscene() {
		cutscenes.pop();
	}
	
	
	
	/**
	 * Checks input
	 * pre : none
	 * post : action is performed based on input
	 */
	public void checkInput(KeyEvent e){
		cutscenes.top().checkInput(e);
	}
	
	
	
	/**
	 * Checks input
	 * pre : none
	 * post : action is performed based on input
	 */
	public void keyReleased(KeyEvent e) {
		cutscenes.top().keyReleased(e);
	}
	
	
	
	/**
	 * Checks if dialogue is done
	 * pre : none
	 * post : true if dialogue is done, false if not
	 */
	public boolean isDialogueDone() {
		return cutscenes.top().isDialogueDone();
	}
	
	
	
	/**
	 * Special method for first cutscene
	 * Note : Cutscene1 was buggy and needed this method
	 * pre : none
	 * post : return cutscene1
	 */
	public Cutscene getCutscene1() {
		return cutscenes.top();
	}
}
