/*
 * Dialoguebox.java
 * Controls Dialogue in Cutscenes
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package cutscene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

import util.GameObject;

public class DialogueBox extends GameObject{

	Image textBox;
	boolean activeQueue = false;
	String text = "HELLO";
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : DialogueBox object created
	 */
	public DialogueBox() {
		super(0, 5, 1000, 100);
		textBox = new ImageIcon("src/resources/dialogueBox.jpg").getImage();
		
	}
	
	
	
	/**
	 * Draws text and the dialogue box onto screen
	 * pre : none
	 * post : text and dialogue box is drawn
	 */
	public void draw(Graphics g){
		g.drawImage(textBox, getX(), getY(), width(), height(), null);
		Graphics2D g2 = (Graphics2D) g;
		Font font = new Font("Comic Sans MS",Font.BOLD,25);
		g2.setFont(font);
		int x1 = 50;
		int y1 = 5;
		
		g2.setColor(Color.white);

		for (String line : text.split("\n")){
			g2.drawString(line, x1, (int) (y1 += g.getFontMetrics().getHeight()));
		}
		g2.setFont(new Font("Consolas",Font.PLAIN,10));
		g2.drawString("(Press Space to continue)", 30, 90);
		activeQueue = false;
	}
	
	
	
	/**
	 * Queues text onto screen
	 * pre : none
	 * post : text is queued
	 */
	public void queue(String text){
		activeQueue = true;
		this.text = text;
		
	}
	
	
	
	/**
     * Sets the queue to inactive
     * pre : none
     * post : queue is inactive
     */
    public void dequeue() {
        activeQueue = false;
    }
    
    
    
	/**
	 * Checks if queue is active
	 * pre : none
	 * post : true if queue is active, false if not
	 */
	public boolean isActive(){
		return activeQueue;
	}
}