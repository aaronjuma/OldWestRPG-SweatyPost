package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;


public class DrawTextBox {
	int boxHeight, boxWidth;
	boolean hidden;
	String text;
	public DrawTextBox(){
		hidden = true;
		text = "";
	}
	
	
	public void draw(Graphics g, int x, int y) {
		if(hidden == false){
			boxWidth = text.length()*14;
			boxHeight = 100;
			
			Graphics2D g2 = (Graphics2D) g;
			g.setColor(Color.black);
			g.fillRect(x, y, boxWidth, boxHeight);
			Font font = new Font("Comic Sans MS",Font.BOLD,25);
			FontRenderContext context = g2.getFontRenderContext();
			g2.setFont(font);
			int textWidth = (int) font.getStringBounds(text, context).getWidth();
			LineMetrics ln = font.getLineMetrics(text, context);
			int textHeight = (int) (ln.getAscent() + ln.getDescent());
			int x1 = x + (boxWidth - textWidth)/2;
			int y1 = (int)(y + (boxHeight + textHeight)/2 - ln.getDescent());
			
			g2.setColor(Color.yellow);
			
			g2.drawString(text, (int) x1, (int) y1);
		}
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void show() {
		hidden = false;
	}
	public void hide() {
		hidden = true;
	}
}
