package character;
import java.awt.Color;
import java.awt.Graphics;

import util.GameObject;


public class Bullets extends GameObject{

	int initialSpeed = 20;
	int direction = 1; // 0 left, 1 right
	
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
	
	public void move() {
		if(direction == 1){
			setX(getX()+initialSpeed);
		}
		else{
			setX(getX()-initialSpeed);
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(getX(), getY(), height(), width());
	}
}
