/*
 * HotelChange.java
 * Controls Hotel Change quest
 * Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package quest;

import gui.DrawTextBox;

import java.awt.event.KeyEvent;
import character.CharacterDetails;

public class HotelChange extends Quest {

	boolean changed;
	boolean inTargetBG;
	int cabinet1;
	int cabinet2;
	DrawTextBox helper;
	CharacterDetails details;
	
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : Hotel Change quest created
	 */
	public HotelChange(DrawTextBox helper) {
		super("HR");
		cabinet1 = 50;
		cabinet2 = 160;
		changed = false;
		this.helper = helper;
	}
	
	
	
	/**
	 * Continiously checks if quest is done
	 * pre : none
	 * post : displays a text box if user is near cabinet
	 */
	public void check(String ID) {
		if(targetBG.equals(ID)){
			inTargetBG = true;
			if(cabinet1 <= details.getX() && details.getX() <= cabinet2){
				if(changed == false) {
					helper.setText("Press F to change");
					helper.setPos(100, 620);
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
		else {
			inTargetBG = false;
		}
	}
	
	
	
	/**
	 * Checks for input
	 * pre : none
	 * post : action performed based on input
	 */
	public void checkInput(CharacterDetails details, KeyEvent e){
		this.details = details;
		if(inTargetBG == true) {
			if(changed == false){
				if(cabinet1 <= details.getX() && details.getX() <= cabinet2){
					if(e.getKeyCode()==KeyEvent.VK_F) {
						changed = true;
					}
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
		return changed;
	}
}
