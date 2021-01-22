package cutscene;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CutsceneManager {

	ArrayList<Cutscene> cutscenes;
	int currentCutscene;
	
	public CutsceneManager(DialogueBox box) {
		cutscenes = new ArrayList<Cutscene>();
		cutscenes.add(new Cutscene1(box));
		cutscenes.add(new Cutscene2(box));
		cutscenes.add(new Cutscene3(box));
		currentCutscene = 0;
	}
	
	public void check() {
		cutscenes.get(currentCutscene).check();
	}
	
	public void nextCutscene() {
		++currentCutscene;
	}
	
	public void checkInput(KeyEvent e){
		cutscenes.get(currentCutscene).checkInput(e);
	}
	
	public void keyReleased(KeyEvent e) {
		cutscenes.get(currentCutscene).keyReleased(e);
	}
	
	public boolean isDialogueDone() {
		return cutscenes.get(currentCutscene).isDialogueDone();
	}
	
	public Cutscene getCutscene1() {
		return cutscenes.get(currentCutscene);
	}
}
