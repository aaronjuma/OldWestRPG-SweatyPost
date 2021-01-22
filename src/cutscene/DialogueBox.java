package cutscene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

import javax.swing.ImageIcon;

import util.GameObject;

public class DialogueBox extends GameObject{

	Image textBox;
	boolean activeQueue = false;
	String text = "HELLO";
	public DialogueBox() {
		super(0, 5, 1000, 100);
		textBox = new ImageIcon("src/resources/dialogueBox.jpg").getImage();
		
	}
	
	public void draw(Graphics g){
		g.drawImage(textBox, getX(), getY(), width(), height(), null);
		Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Comic Sans MS",Font.BOLD,25);
        FontRenderContext context = g2.getFontRenderContext();
        g2.setFont(font);
        int textWidth = (int) font.getStringBounds(text, context).getWidth();
        LineMetrics ln = font.getLineMetrics(text, context);
        int textHeight = (int) (ln.getAscent() + ln.getDescent());
        int x1 = 50;
//        int y1 = (int)(getY() + (height() + textHeight)/2 - ln.getDescent());
        int y1 = 5;

        g2.setColor(Color.white);

        for (String line : text.split("\n")){
        	 g2.drawString(line, x1, (int) (y1 += g.getFontMetrics().getHeight()));
        }
        g2.setFont(new Font("Consolas",Font.PLAIN,10));
        g2.drawString("(Press Space to continue)", 30, 90);
        activeQueue = false;
	}
	
	public void queue(String text){
		activeQueue = true;
		this.text = text;
		
	}
	
	public boolean isActive(){
		return activeQueue;
	}
}
