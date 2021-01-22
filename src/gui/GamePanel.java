/*
 * GamePanel.java
 * Panel for GUI
 * Aaron Jumarang, Benji Magyar-Samoila, Scott Boyd
 * Jan 22 2021
 * ICS4U
 */

package gui;

import game.GameManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GamePanel extends JPanel implements Runnable{
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)((GAME_WIDTH * 3)/4);
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	GameManager game;
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : game thread is running
	 */
	public GamePanel() {
		game = new GameManager();
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	
	/**
	 * Paints components onto frame
	 * pre : none
	 * post : components painted
	 */
	public void paint(Graphics g){
		super.paint(g);
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		g.drawImage(game.background(), 0, 0, 1000, 750, null);
		game.draw(g);
	}
	
	
	
	/**
	 * draw components onto frame
	 * pre : none
	 * post : components drawn
	 */
	public void draw(Graphics g){
		Toolkit.getDefaultToolkit().sync();
	}
	
	
	
	/**
	 * moves components
	 * pre : none
	 * post : components are moving
	 */
	public void move() {
		game.move();
	}

	
	
	/**
	 * Runs game storyboard
	 * pre : none
	 * post : story is running
	 */
	public void check() {
		game.check();
	}
	
	
	
	/**
	 * Game thread
	 * pre : none
	 * post : game is running
	 */
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
				check();
				repaint();
				delta--;
			}
		}
	}
	
	
	
	/**
	 * Class that reads input from keyboard
	 */
	public class AL extends KeyAdapter{
		
		/**
		 * Checks inputs that are pressed
		 */
		public void keyPressed(KeyEvent e) {
			game.keyPressed(e);			
		}
		
		
		
		/**
		 * Checks inputs that are released
		 */
		public void keyReleased(KeyEvent e) {
			game.keyReleased(e);
		}
	}
}
