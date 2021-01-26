/*
 * Bullets.java
 * Bullet game object
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package character;

import java.awt.Color;
import java.awt.Graphics;
import util.GameObject;

public class Bullets extends GameObject{

	int initialSpeed = 20;
	int direction = 1; // 0 left, 1 right
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : bullet object created
	 */
	public Bullets(CharacterDetails details){
		super(0,0, 30, 30);
		this.direction = details.getDirection();
		setY(details.getY() + (int)(0.35 * details.getHeight()));
		if(direction == 0) {
			setX(details.getX());
		}
		else{
			setX(details.getX()+details.getWidth());
		}
	}
	
	
	
	/**
	 * moves bullet
	 * pre : none
	 * post : bullet is moving
	 */
	public void move() {
		if(direction == 1){
			setX(getX()+initialSpeed);
		}
		else{
			setX(getX()-initialSpeed);
		}
	}
	
	
	
	/**
	 * draws bullet onto screen
	 * pre : none
	 * post : bullet is drawn
	 */
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(getX(), getY(), height(), width());
	}
}
