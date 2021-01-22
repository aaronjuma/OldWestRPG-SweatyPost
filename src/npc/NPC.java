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
	
	
	public NPC(String directory){
		super(0,0,0,0);
		npcImage = new ImageIcon(directory).getImage();
		dead = false;
	}
	
	public void updateSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	public void position(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void draw(Graphics g){
		g.drawImage(npcImage, getX(), getY(), width(), height(), null);
	}
	
	public boolean hidden() {
		return hidden;
	}
	
	public void hide() {
		hidden = true;
	}
	
	public void show() {
		hidden = false;
	}
	
	public void die() {
		dead = true;
	}
	
	public boolean dead() {
		return dead;
	}
	
}
