/*
 * GameObject.java
 * Models an object for the Game,
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package util;

public class GameObject {

	int width;
	int height;
	int x;
	int y;
	
	
	/**
	* Constructor
	* pre: x, y, width, height >= 0
	* post: Game Object is created
	*/
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	
	/**
	 * Returns X position of object
	 * pre : none
	 * post : x position returned
	*/
	public int getX() {
		return x;
	}
	
	
	
	/**
	* Returns Y position of object
	* pre: none
	* post: Y position is returned
	*/
	public int getY() {
		return y;
	}
	
	
	
	/**
	* Returns Width of object
	* pre: none
	* post: Width is returned
	*/
	public int width() {
		return width;
	}
	
	
	
	/**
	* Returns Height of object
	* pre: none
	* post: Height is returned
	*/
	public int height() {
		return height;
	}
	
	
	
	/**
	* Sets X value for object
	* pre: none
	* post: object is set on X position
	*/
	public void setX(int x) {
		this.x = x;
	}
	
	
	
	/**
	* Sets Y value for object
	* pre: none
	* post: object is set on Y position
	*/
	public void setY(int y) {
		this.y = y;
	}
	
	
	
	/**
	* Changes height of object
	* pre: none
	* post: height of object is changed
	*/
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	/**
	* Changes width of object
	* pre: none
	* post: width of object is changed
	*/
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
	/**
	* Checks if object is intersecting with other object
	* pre: none
	* post: true if object is intersecting, false if not
	*/
    public boolean intersects(GameObject r) {
        int tw = this.width;
        int th = this.height;
        int rw = r.width();
        int rh = r.height();
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = getX();
        int ty = getY();
        int rx = r.getX();
        int ry = r.getY();
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }
}
