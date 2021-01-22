/*
 * Music.java
 * Controls Music
 * Aaron Jumarang
 * Jan 22 2021
 * ICS4U
 */
package util;

import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

	Clip clip;
	
	
	/**
	 * Constructor
	 * pre : none
	 * post : music object created
	 */
	public Music(String directory){
		try{
			File file = new File(directory);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e){
			System.out.println("Error loading music");
			System.err.println(e.getMessage());
		}
	}
	
	
	
	/**
	 * Plays music
	 * pre : none
	 * post : music is playing
	 */
	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}
	
	
	
	/**
	 * Loops music
	 * pre : none
	 * post : music is looping
	 */
	public void loop() {
		 clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	
	
	/**
	 * Stops music
	 * pre : none
	 * post : music stopped
	 */
	public void stop() {
		clip.stop();
		clip.close();
	}
	
	
}
