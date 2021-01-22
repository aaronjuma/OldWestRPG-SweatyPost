package character;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

import util.GameObject;


public class Character extends GameObject{
	int speed = 10;
	int xVelocity = 0;
	Image prisonLeft;
	Image prisonRight;
	Image gunLeft;
	Image gunRight;
	Image guy;
	Image left;
	Image right;
	boolean aKey, dKey;
	int gameHeight, gameWidth;
	int direction = 1;
	CharacterDetails details;
	
	int xOffest = 0;
	
	public Character(int gameHeight, int gameWidth) {
		super(0,0,0,0);
		gunRight = new ImageIcon("src/resources/RightDalton1.png").getImage();
		gunLeft = new ImageIcon("src/resources/LeftDalton1.png").getImage(); 
		prisonRight = new ImageIcon("src/resources/RightPrisonDalton.png").getImage();
		prisonLeft = new ImageIcon("src/resources/LeftPrisonDalton.png").getImage();
	
		right = gunRight;
		guy = right;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		details = new CharacterDetails(30, 300, 350, 350);
		
	}
	
	
	
	/**
	 * checks if a key is pressed
	 * pre : none
	 * post : sets a boolean value to the key
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_A) {
			aKey = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			dKey = true;
		}
	}
	
	
	
	/**
	 * checks if a key is released
	 * pre : none
	 * post : sets a boolean value to the key
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_A) {
			aKey = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			dKey = false;
		}
	}
	
	
	/**
	 * Moves the character around, also checks for collisions
	 * pre : none
	 * post : character moves
	 */
	public void move() {
		xVelocity = 0;
		if(dKey == true) {
			if(details.getX() < gameWidth-details.getWidth()){
				details.setDirection(1);
//				guy = right;
				xVelocity = speed;
			}
		}
		if(aKey == true) {
			if(details.getX() > 0){
				details.setDirection(0);
//				guy = left;
				xVelocity = -speed;
			}
		}
		if(aKey == false && dKey == false) {
			xVelocity = 0;
		}
		
		details.setPos(details.getX() + xVelocity, details.getY());
	}
	
	
	/**
	 * draws character onto screen
	 * pre : none
	 * post : character is drawn
	 */
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		if(details.getJail() == true) {
			left = prisonLeft;
			right = prisonRight;
		}
		else{
			left = gunLeft;
			right = gunRight;
		}
		
		if(details.getDirection() == 0){
			guy = left;
		}
		else {
			guy = right;
		}
		setX(details.getX());
		setY(details.getY());
		setHeight(details.getHeight());
		setWidth(details.getWidth());
		
		g2d.drawImage(guy, getX(), getY(), height(), width(), null);
//		System.out.println(details.getX());
	}
	
	public CharacterDetails getDetails() {
		return details;
	}
}
