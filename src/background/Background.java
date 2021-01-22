package background;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Background {

	Image image;
	int midExitX, midY, charHeight, charWidth;
	Background leftExit, rightExit, middleExit;
	String ID;
	
	public Background(String directory, int charHeight, int charWidth, int midY, String ID) {
		image = new ImageIcon(directory).getImage();
		this.charHeight = charHeight;
		this.charWidth = charWidth;
		this.midY = midY;
		this.ID = ID;
	}
	
	public void setMid(Background midExit, int midX) {
		this.middleExit = midExit;
		this.midExitX = midX;
	}
	
	public void setLeft(Background leftExit) {
		this.leftExit = leftExit;
	}
	
	public void setRight(Background rightExit) {
		this.rightExit = rightExit;
	}
	
	public Background getLeft() {
		return leftExit;
	}
	
	public Background getRight() {
		return rightExit;
	}
	
	public Background getMid() {
		return middleExit;
	}
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
	
	public int getExitX() {
		return midExitX;
	}
	
	public int getMidY() {
		return midY;
	}
	
	public int getHeight() {
		return charHeight;
	}
	
	public int getWidth() {
		return charWidth;
	}
	public Image getImage() {
		return image;
	}
	
	public String getID() {
		return ID;
	}
	
	public String toString() {
		return ID;
	}
}
