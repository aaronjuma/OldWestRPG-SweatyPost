/*
 * GameFrame.java
 * Sets up GUI Frame
 * Aaron Jumarang, Benji Magyar-Samoila, Scott Boyd
 * Jan 22 2021
 * ICS4U
 */
package gui;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{

	GamePanel panel;
	
	
	/**
	 * Constructor
	 * Sets up GUI
	 * pre : none
	 * post : GUI is set up
	 */
	public GameFrame(){
		JOptionPane.showMessageDialog(this,
			    "Welcome to Sweaty Post! You will be playing young Slimy, who, with his brothers, just escaped Millworth\n" +
			    " and are now laying low in a town called Sweaty Post, a town ruled by the Earps. Press A and D to move! ");
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Sweaty Post");
		this.setBackground(Color.black);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}