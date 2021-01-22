package quest;

public class FindShifty extends Quest{

	boolean inTarget;
	
	public FindShifty() {
		super("BR");
		inTarget = false;
	}

	public void check(String ID) {
		if(targetBG.equals(ID)){
			inTarget = true;
		}
	}
	
	public boolean goal() {
		return inTarget;
	}
}
