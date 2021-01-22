package gui;

import game.GameManager;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import character.Bullets;
import character.Character;

import background.BackgroundControl;


public class GamePanel extends JPanel implements Runnable{
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)((GAME_WIDTH * 3)/4);
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	GameManager game;
	
	GamePanel() {
		game = new GameManager();
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		g.drawImage(game.background(), 0, 0, 1000, 750, null);
		game.draw(g);
	}
	
	public void draw(Graphics g){
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void move() {
		game.move();
	}
	
	public void checkCollision() {
	}
	
	public void check() {
		game.check();
	}
	
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				check();
				repaint();
				delta--;
			}
		}
	}
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			game.keyPressed(e);			
		}
		public void keyReleased(KeyEvent e) {
			game.keyReleased(e);
		}
	}
}
