import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player extends Entity {
	
	int velX = 0, velY = 0; // x and y coords for player movement
	int speed = 3; // speed of player

	Shootsound shoot = new Shootsound();
	
	public Player(int x, int y) { // constructor method for starting coords of player
		super(x, y);
		update();
	}
	
	public void update(){ // update method that updates the players coords
		//y += velY;
		x += velX;
		checkOffScreen();
		checkCollisions();
	}
	
	public void draw(Graphics2D g2d){ // draw method to draw the player
		g2d.drawImage(getPlayerImg(), x, y, null);
		//g2d.draw(getBounds());
	}
	
	public Image getPlayerImg(){ // method for getting the image of the player
		ImageIcon ic = new ImageIcon("C:\\res\\player_ship.png");
		return ic.getImage();
	
	}
	
	public void keyPressed(KeyEvent e){ // when key is pressed
		int key = e.getKeyCode();
		
		/*if(key == KeyEvent.VK_W){ // Move left which is to subtract
			velY = -speed;
		} else if(key == KeyEvent.VK_S) {// Move right which is to add
			velY = speed;*/
		if(key == KeyEvent.VK_A) { // move up which is to subtract.
			velX = -speed;
		} else if(key == KeyEvent.VK_D) { // move down which is to add.
			velX = speed;
		} else if(key == KeyEvent.VK_SPACE){
			GameFrame.addMissile(new Missile(x, y));
			shoot.play();
		}
	}
	
	public void keyReleased(KeyEvent e){ // on release of key
		int key = e.getKeyCode();
		
		/*if(key == KeyEvent.VK_W){ // value of velocity will remain 0 for stop.
			velY = 0;
		} else if(key == KeyEvent.VK_S) {
			velY = 0;*/
		if(key == KeyEvent.VK_A) {
			velX = 0;
		} else if(key == KeyEvent.VK_D) {
			velX = 0;
		}else if(key == KeyEvent.VK_SPACE){
		}
	}
	
	public void checkCollisions() {
		ArrayList<Enemy> enemies = GameFrame.getEnemyList();
		
		for(int i = 0; i < enemies.size(); i++){
			Enemy tempEnemy = enemies.get(i);
			
			if(getBounds().intersects(tempEnemy.getBounds())){
				//GameFrame.removeEnemy(tempEnemy);
				JOptionPane.showMessageDialog(null, "You have died on level " + GameFrame.level + ". Try harder next time."); //LOL GOOD LUCK JJ WITH DA PRANK BAE!
				//JOptionPane.showMessageDialog(null, "GREAT JOB! Game Made by Michael Morales aka(rambo5x). Not Jesus Jose Meza aka(Hentailover69");
				
				System.exit(0);
			}
		}
	}
	
	public void checkOffScreen(){
		if(x >= 500){//680 for it wont disappear
		x = -15;// spawn back at top
		}else if(x <= -15){
			x = 500;
		}
	}
	
	public Rectangle getBounds(){ // make new rectangle and draw around player
		return new Rectangle(x, y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
	}
}

