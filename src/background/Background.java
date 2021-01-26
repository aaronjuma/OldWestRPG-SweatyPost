/*
 * Background.java
 * Superclass for background objects
 * Benji Magyar-Samoila
 * Jan 22 2021
 * ICS4U
 */
package background;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Background implements Comparable{

	Image image;
	int midExitX, midY, charHeight, charWidth;
	Background leftExit, rightExit, middleExit;
	String ID;
	
	
	/**
	 * Constructor
	 * pre : charHeight, charWidth, midY > 0
	 * post : background object created
	 */
	public Background(String directory, int charHeight, int charWidth, int midY, String ID) {
		image = new ImageIcon(directory).getImage();
		this.charHeight = charHeight;
		this.charWidth = charWidth;
		this.midY = midY;
		this.ID = ID;
	}
	
	
	public Background(String ID){
		this.ID = ID;
	}
	
	
	/**
	 * Set the middle ext
	 * pre : 0 < midX < 1000
	 * post : middle exit is set
	 */
	public void setMid(Background midExit, int midX) {
		this.middleExit = midExit;
		this.midExitX = midX;
	}
	
	
	
	/**
	 * Set left exit
	 * pre : none
	 * post : left exit set
	 */
	public void setLeft(Background leftExit) {
		this.leftExit = leftExit;
	}
	
	
	
	/**
	 * Set right exit
	 * pre : none
	 * post : right exit set
	 */
	public void setRight(Background rightExit) {
		this.rightExit = rightExit;
	}
	
	
	
	/**
	 * Returns reference of left exit
	 * pre : none
	 * post : left exit returned
	 */
	public Background getLeft() {
		return leftExit;
	}
	
	
	
	/**
	 * Returns reference of right exit
	 * pre : none
	 * post : right exit returned
	 */
	public Background getRight() {
		return rightExit;
	}
	
	
	
	/**
	 * Returns reference of middle exit
	 * pre : none
	 * post : middle exit returned
	 */
	public Background getMid() {
		return middleExit;
	}
	
	
	
	/**
	 * Checks if there is an exit in a direction
	 * pre : exit = 1,2,3
	 * post : true if there is an exit in that direction, false if not
	 */
	public boolean exist(int exit) {
		boolean returnValue = false;
		
		//Left
		if(exit == 1){
			if(leftExit != null){
				returnValue = true;
			}
		}
		else if(exit == 2) {
			if(middleExit != null){
				returnValue = true;
			}
		}
		else {
			if(rightExit != null){
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	
	
	/**
	 * Gets character x pos
	 * pre : none
	 * post : x pos is returned
	 */
	public int getExitX() {
		return midExitX;
	}
	
	
	
	/**
	 * Gets character y pos
	 * pre : none
	 * post : y pos is returned
	 */
	public int getMidY() {
		return midY;
	}
	
	
	
	/**
	 * Gets character height for current background
	 * pre : none
	 * post : height is returned
	 */
	public int getHeight() {
		return charHeight;
	}
	
	
	
	/**
	 * Gets character width for current background
	 * pre : none
	 * post : width is returned
	 */
	public int getWidth() {
		return charWidth;
	}
	
	
	
	/**
	 * Gets image for background
	 * pre : none
	 * post : image is returned
	 */
	public Image getImage() {
		return image;
	}
	
	
	
	/**
	 * Gets ID for background
	 * pre : none
	 * post : ID is returned
	 */
	public String getID() {
		return ID;
	}
	
	
	
	/**
	 * Returns string
	 * pre : none
	 * post : ID is returned
	 */
	public String toString() {
		return ID;
	}



	@Override
	public int compareTo(Object o) {
		Background b = (Background)o;
		return getID().compareTo(b.getID());
	}
}
