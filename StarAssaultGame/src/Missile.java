import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile extends Entity {
 
	public Missile(int x, int y) {
		super(x, y);
	
	}
	
	public void update(){
		y -= 3;
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(getMissileImg(), x, y, null);
		g2d.draw(getBounds());
	}
	
	public Image getMissileImg(){ // method for getting the image of the player
		ImageIcon ic = new ImageIcon("C:\\res\\missile.png");
		return ic.getImage();
	
	}
	
	public Rectangle getBounds(){ // make new rectangle and draw around player
		return new Rectangle(x, y, getMissileImg().getWidth(null), getMissileImg().getHeight(null));
	}
}
