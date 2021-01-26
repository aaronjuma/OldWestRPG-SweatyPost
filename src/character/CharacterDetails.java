/*
 * CharacterDetails.java
 * Allows other classes to manipulate the character
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package character;

public class CharacterDetails {
	
	int x;
	int y;
	int charWidth;
	int charHeight;
	boolean jailSuit;
	String currentBG;
	int direction;
	
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : details created
	 */
	public CharacterDetails(int x, int y, int charHeight, int charWidth) {
		this.x = x;
		this.y = y;
		this.charWidth = charWidth;
		this.charHeight = charHeight;
		jailSuit = false;
	}
	
	
	
	/**
	 * Set x and y position
	 * pre : none
	 * post : character is set to new x and y position
	 */
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	/**
	 * Changes dimensions of character
	 * pre : none
	 * post : character dimensions changed
	 */
	public void setDimensions(int charHeight, int charWidth) {
		this.charHeight = charHeight;
		this.charWidth = charWidth;
	}
	
	
	
	/**
	 * Gets X value of character
	 * pre : none
	 * post : x value returned
	 */
	public int getX() {
		return x;
	}
	
	
	
	/**
	 * Gets Y value of character
	 * pre : none
	 * post : Y value returned
	 */
	public int getY() {
		return y;
	}
	
	
	
	/**
	 * Gets height of character
	 * pre : none
	 * post : height returned
	 */
	public int getHeight() {
		return charHeight;
	}
	
	
	
	/**
	 * Gets width of character
	 * pre : none
	 * post : width returned
	 */
	public int getWidth() {
		return charWidth;
	}
	
	
	
	/**
	 * Returns if character is in jail suit or not
	 * pre : none
	 * post : true if character is in jail, false if not
	 */
	public boolean getJail() {
		return jailSuit;
	}
	
	
	
	/**
	 * Changes characters suit
	 * pre : none
	 * post : character suit changed
	 */
	public void setJail(boolean x) {
		jailSuit = x;
	}
	
	
	
	/**
	 * Set direction
	 * pre : x = 1, 2
	 * post : character changed direction
	 */
	public void setDirection(int x){
		//0 left
		//1 right
		direction = x;
	}
	
	
	
	/**
	 * Returns direction
	 * pre : none
	 * post : direction returned
	 */
	public int getDirection() {
		return direction;
	}
}
