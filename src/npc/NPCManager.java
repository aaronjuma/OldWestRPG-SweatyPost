/*
 * NPCManager.java
 * Manages NPCs
 * Benji Magyar-Samoila
 * Jan 22 2021
 * ICS4U
 */
package npc;

import java.awt.Graphics;
import java.util.ArrayList;

public class NPCManager {
	NPC shifty;
	ArrayList<NPC> npclist;
	String dir = "src/resources/npc/";
	
	/**
	 * Constructor
	 * pre : none
	 * post : NPCManager created, NPCs also created
	 */
	public NPCManager() {
		
		//Adding Shifty
		shifty = new NPC(dir + "LeftShifty.png");
		shifty.updateSize(300, 300);
		shifty.position(700, 300);
		npclist = new ArrayList<NPC>();
		npclist.add(shifty);
		
		
		//Adding Earps
		for(int i = 1; i <= 3; ++i){
			npclist.add(new NPC(dir +  "Earps" + i + ".png"));
			npclist.get(i).updateSize(200, 200);
			npclist.get(i).position(200+(i*200), 500);
			npclist.get(i).hide();
		}
		
		npclist.add(new NPC(dir + "Sheriff.png"));
		npclist.get(4).updateSize(300, 300);
		npclist.get(4).position(0, 300);
	}
	
	
	
	/**
	 * Show an NPC
	 * pre : n >= 0
	 * post : NPC is shown
	 */
	public void show(int n){
		npclist.get(n).show();
	}
	
	
	
	/**
	 * Hides an NPC
	 * pre : n >= 0
	 * post : NPC is hidden
	 */
	public void hide(int n){
		npclist.get(n).hide();
	}
	
	
	
	/**
	 * Draws an NPC
	 * pre : none
	 * post : NPC is drawn
	 */
	public void draw(Graphics g){
		for(int i = 0; i < npclist.size(); ++i){
			NPC temp = npclist.get(i);
			if(!temp.hidden()){
				temp.draw(g);
			}
		}
	}
	
	
	
	/**
	 * Returns an NPC
	 * pre : n >= 0
	 * post : NPC is returned
	 */
	public NPC getNPC(int n) {
		return npclist.get(n);
	}
}
