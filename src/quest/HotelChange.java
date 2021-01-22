package quest;

import java.awt.event.KeyEvent;
import character.CharacterDetails;

public class HotelChange extends Quest {

	boolean changed;
	boolean inTargetBG;
	int cabinet1;
	int cabinet2;
	
	
	public HotelChange() {
		super("HR");
		cabinet1 = 50;
		cabinet2 = 160;
		changed = false;
	}
	
	public void check(String ID) {
		if(targetBG.equals(ID)){
			inTargetBG = true;
		}
		else {
			inTargetBG = false;
		}
	}
	public void checkInput(CharacterDetails details, KeyEvent e){
		if(inTargetBG == true) {
			if(changed == false){
				if(cabinet1 <= details.getX() && details.getX() <= cabinet2){
					if(e.getKeyCode()==KeyEvent.VK_F) {
						changed = true;
						System.out.println("CHANGED FOUND");
					}
				}
			}
		}
	}

	public boolean changed() {
		return changed;
	}
}
