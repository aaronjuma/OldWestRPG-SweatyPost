/*
 * EscapeJail.java
 * Controls Escape Jail quest
 * Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

import gui.DrawTextBox;
import java.awt.event.KeyEvent;
import character.CharacterDetails;

public class EscapeJail extends Quest {

	CharacterDetails details;
	DrawTextBox helper;
	boolean keyFound;
	boolean doorOpen;
	int keyX1;
	int keyX2;
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : Escape Jail quest created
	 */
	public EscapeJail(DrawTextBox helper) {
		super("JC");
		keyFound = false;
		keyX1 = 40;
		keyX2 = 200;
		this.helper = helper;
	}
	
	
	
	/**
	 * Continously checks events throughout quest
	 * pre : none
	 * post : displays text box if user is near doors
	 */
	public void check(String ID) {
		if(keyX1 <= details.getX() && details.getX() <= keyX2){
			if(keyFound == false){
				helper.setText("Press F to pick up key");
				helper.setPos(150, 620);
				helper.show();
			}
			else{
				helper.hide();
			}
		}
		else{
			helper.hide();
		}
	}
	
	
	
	/**
	 * Checks for input
	 * pre : none
	 * post : action performed based on input
	 */
	public void checkInput(CharacterDetails details, KeyEvent e){
		this.details = details;
		if(keyFound == false){
			if(keyX1 <= details.getX() && details.getX() <= keyX2){
				if(e.getKeyCode()==KeyEvent.VK_F) {
					keyFound = true;
				}
			}
		}
		
	}
	
	
	
	/**
	 * Returns if quest goal is achieved
	 * pre : none
	 * post : true if quest goal is achieved, false if not
	 */
	public boolean goal() {
		return keyFound;
	}
}
