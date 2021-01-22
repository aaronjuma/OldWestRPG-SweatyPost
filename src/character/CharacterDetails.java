package character;

public class CharacterDetails {

	int x;
	int y;
	int charWidth;
	int charHeight;
	boolean jailSuit;
	String currentBG;
	int direction;
	
	public CharacterDetails(int x, int y, int charHeight, int charWidth) {
		this.x = x;
		this.y = y;
		this.charWidth = charWidth;
		this.charHeight = charHeight;
		jailSuit = false;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setDimensions(int charHeight, int charWidth) {
		this.charHeight = charHeight;
		this.charWidth = charWidth;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return charHeight;
	}
	
	public int getWidth() {
		return charWidth;
	}
	
	public boolean getJail() {
		return jailSuit;
	}
	
	public void setJail(boolean x) {
		jailSuit = x;
	}
	
	public void setDirection(int x){
		//0 left
		//1 right
		direction = x;
	}
	
	public int getDirection() {
		return direction;
	}
}
