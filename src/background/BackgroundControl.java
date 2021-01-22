package background;

import gui.DrawTextBox;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import util.LinearSearch;
import character.CharacterDetails;



public class BackgroundControl {

	Background currentImage;
	ArrayList<Background> backgrounds = new ArrayList<Background>();
	CharacterDetails details;
	int currentBackgroundID;
	DrawTextBox textBox;
	boolean requestChange = false;
	
	public BackgroundControl(CharacterDetails details) {
		Background Jail = new Background("src/resources/Jail.jpg", 250, 250, 350, "JL"); 
		Background Bank = new Background("src/resources/Bank.jpg", 200, 200, 500, "BK"); 
		Background Saloon = new Background("src/resources/Saloon.png", 200, 200, 500, "SL");
		Background Hotel = new Background("src/resources/Hotel.png", 200, 200, 530, "HT");
		Background Railway = new Background("src/resources/Railway.jpg", 200, 200, 500, "RW");
		
		Background JailCell = new Background("src/resources/JailCell.png", 400, 400, 200, "JC");
		Background Bar = new Background("src/resources/Bar.jpg", 300, 300, 300, "BR");
		Background HotelRoom = new Background("src/resources/HotelRoom.png", 300, 300, 300, "HR");
		
		JailCell.setMid(Jail, 570);
		Jail.setRight(Bank);
		Jail.setMid(JailCell, 270);
		Bank.setLeft(Jail);
		Bank.setRight(Saloon);
		Saloon.setLeft(Bank);
		Saloon.setMid(Bar, 500);
		Bar.setMid(Saloon, 20);
		Saloon.setRight(Hotel);
		Hotel.setLeft(Saloon);
		Hotel.setMid(HotelRoom, 400);
		HotelRoom.setMid(Hotel, 620);
		Hotel.setRight(Railway);
		Railway.setLeft(Hotel);
		
		
		backgrounds.add(Jail);
		backgrounds.add(Bank);
		backgrounds.add(Saloon);
		backgrounds.add(Hotel);
		backgrounds.add(Railway);
		backgrounds.add(JailCell);
		backgrounds.add(Bar);
		backgrounds.add(HotelRoom);
		
		this.details = details;
		currentBackgroundID = 0;
		currentImage = JailCell;
		details.setPos(currentImage.getExitX(), currentImage.getMidY());
		details.setDimensions(currentImage.getHeight(), currentImage.getWidth());
		textBox = new DrawTextBox();
		switchBackground("BR");
	}
	
	public void backgroundChange(int direction) {
		if(direction == 1){
			currentImage = currentImage.getLeft();
			details.setPos(1000-details.getWidth()-80, currentImage.getMidY());
		}
		else if(direction == 2){
			currentImage = currentImage.getMid();
			details.setPos(currentImage.getExitX(), currentImage.getMidY());
		}
		else if(direction == 3) {
			currentImage = currentImage.getRight();
			details.setPos(30, currentImage.getMidY());
		}
		details.setDimensions(currentImage.getHeight(), currentImage.getWidth());
	}
	
	public void switchBackground(String ID) {
		LinearSearch<Background> search = new LinearSearch<Background>(backgrounds);
		int index = search.searchFor(ID);
		if(index >= 0){
			currentImage = backgrounds.get(index);
			details.setPos(currentImage.getExitX(), currentImage.getMidY());
			details.setDimensions(currentImage.getHeight(), currentImage.getWidth());
		}
	}
	
	public Image getBackgroundImage() {
		return currentImage.getImage();
	}
	
	public Background getBackground() {
		return currentImage;
	}
	
	/**
	 * checks if a key is pressed
	 * pre : none
	 * post : sets a boolean value to the key
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_E) {
			requestChange = true;
		}
	}
	
	
	public void move() {
		if(requestChange == true){
			if(currentImage.exist(2)){
				requestChange = false;
				if(currentImage.getExitX()-75 < details.getX() && currentImage.getExitX()+75 > details.getX()){
					backgroundChange(2);
				}
			}
		}
	}
	
	
	
	public void checkBoundaries() {
		if(details.getX() < 20) {
			if(currentImage.exist(1)){
				backgroundChange(1);
			}
		}
		else if(details.getX() > 1000-details.getWidth()-20){
			if(currentImage.exist(3)){
				backgroundChange(3);
			}
		}
		
	}
	
	public void drawText(Graphics g){
//		if(currentImage.exist(2)){
//			if(currentImage.getExitX()-75 < details.getX() && currentImage.getExitX()+75 > details.getX()){
//				textBox.draw(g, "Press E to enter!", currentImage.getExitX(), 100);
//			}
//		}
	}
}
