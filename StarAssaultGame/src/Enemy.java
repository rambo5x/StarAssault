 import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Entity { // same as player class
	
	private int startY;
	
	public Enemy(int x, int y) {
	 super(x, y);
	 startY = y;
	}
	
	public void update(){
		y += 2;
		checkCollisions();
		checkOffScreen();
	}
		
	public void draw(Graphics2D g2d){
		g2d.drawImage(getEnemyImg(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	
	public Image getEnemyImg(){
		ImageIcon ic = new ImageIcon("C:\\res\\enemy_1.png");
		return ic.getImage();
	
	}
	
	public void checkCollisions(){
		for(int i = 0; i < GameFrame.getMissileList().size(); i++){ // run a loop for each missile in the game
			Missile m = GameFrame.getMissileList().get(i);			
			
			if(getBounds().intersects(m.getBounds())){ // check if it collides with the enemy and if it does then
				GameFrame.removeEnemy(this); // remove both entities
				GameFrame.removeMissile(m);
		}
		}			
	}
	
	public void checkOffScreen(){
		if(y >= 680){//680 for it wont disappear
		y = startY;// spawn back at top
		}
	}
	
	public Rectangle getBounds(){ // make new rectangle and draw around player
		return new Rectangle(x, y, getEnemyImg().getWidth(null), getEnemyImg().getHeight(null));
	}

}
