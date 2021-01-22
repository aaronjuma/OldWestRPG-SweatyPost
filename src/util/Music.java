package util;

import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {

	Clip clip;
	
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
	
	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}
	
	public void loop() {
		 clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
		clip.close();
	}
	
	
}
