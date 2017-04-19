package characters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

public class NumericDisplay extends AbstractSprite{
	private String label;
	private int value;	
	
	public NumericDisplay(String label, int startingValue, int x, int y) {
		super();
		this.label = label;
		this.value = startingValue;
		super.x = x;
		super.y = y;
		
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleTick(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void increment() {
		value++;
	}
	
	public void decrement() {
		value--;
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		Graphics2D g2 = (Graphics2D) g;
		Font font = new Font("Arial", Font.BOLD, 17);
		g2.setFont(font);
		g2.setColor(Color.black);
		String displayText = String.format("%s %d", label, value);
		g2.drawString(displayText, (int)x, (int)y);
	}

}
