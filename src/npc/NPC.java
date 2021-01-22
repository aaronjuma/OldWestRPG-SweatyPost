/*
 * NPC.java
 * NPC object
 * Benji Magyar-Samoila
 * Jan 22 2021
 * ICS4U
 */

package npc;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import util.GameObject;

public class NPC extends GameObject {

	String ID;
	Image npcImage;
	boolean hidden;
	boolean dead;
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : NPC created
	 */
	public NPC(String directory){
		super(0,0,0,0);
		npcImage = new ImageIcon(directory).getImage();
		dead = false;
	}
	
	
	
	/**
	 * Updates size of NPC
	 * pre : width, height > 0
	 * post : NPC size updated
	 */
	public void updateSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	
	
	/**
	 * Updates position of NPC
	 * pre : x, y > 0
	 * post : NPC position updated
	 */
	public void position(int x, int y) {
		setX(x);
		setY(y);
	}
	
	
	
	/**
	 * Draws NPC onto screen
	 * pre : none
	 * post : NPC position updated
	 */
	public void draw(Graphics g){
		g.drawImage(npcImage, getX(), getY(), width(), height(), null);
	}
	
	
	
	/**
	 * Checks if NPC is hidden
	 * pre : none
	 * post : true if NPC is hidden, false if not
	 */
	public boolean hidden() {
		return hidden;
	}
	
	
	
	/**
	 * Hides NPC
	 * pre : none
	 * post : NPC is hidden
	 */
	public void hide() {
		hidden = true;
	}
	
	
	
	/**
	 * Shows NPC
	 * pre : none
	 * post : NPC is shown
	 */
	public void show() {
		hidden = false;
	}
	
	
	
	/**
	 * Kills NPC
	 * pre : none
	 * post : NPC is dead
	 */
	public void die() {
		dead = true;
	}
	
	
	
	/**
	 * Checks if NPC is dead
	 * pre : none
	 * post : true if NPC is dead, false if not
	 */
	public boolean dead() {
		return dead;
	}
	
}
