package quest;

import java.awt.event.KeyEvent;

import background.Background;
import character.CharacterDetails;

public class EscapeJail extends Quest {

	boolean keyFound;
	boolean doorOpen;
	int keyX1;
	int keyX2;
	
	
	public EscapeJail() {
		super("JC");
		keyFound = false;
		keyX1 = 40;
		keyX2 = 200;
	}
	
	public void checkInput(CharacterDetails details, KeyEvent e){
		if(keyFound == false){
			if(keyX1 <= details.getX() && details.getX() <= keyX2){
				if(e.getKeyCode()==KeyEvent.VK_F) {
					keyFound = true;
					System.out.println("KEY FOUND");
				}
			}
		}
		
	}
	
	public boolean key() {
		return keyFound;
	}
}
