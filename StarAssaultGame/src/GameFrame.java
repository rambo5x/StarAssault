import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	Timer mainTimer, daytimer;
	Player player;
	Shootsound shoot;
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();// arraylist for creating multiple enemys
	static ArrayList<Missile> missiles = new ArrayList<Missile>();// arraylist for missiles to shoot.
	Random rand = new Random();
	int enemyCount = 5; // amount of enemys
	private JLabel lvlTXT;
	public static int level = 1;
	
	public GameFrame() {
		// TODO Auto-generated constructor stub
		setFocusable(true);// able to be focused
		
		JOptionPane.showMessageDialog(null, "Controls: \nA - Left \nD - Right \nSpaceBar - fire");
		
		player = new Player(230, 530); // adding the player in our game with x and y coords being both 100.
		addKeyListener(new KeyAdapt(player)); // the keys for our player movement
		
		shoot = new Shootsound();
		
		mainTimer = new Timer(10, this); // timer for our spawning of the player and enemies
		mainTimer.start();
		
		startGame();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//ImageIcon ic = new ImageIcon("C:\\res\\background.gif");
		//ImageIcon ic2 = new ImageIcon("C:\\res\\Skybackground.png");
		if(level >= 5){
		//	g2d.dispose();
		// 	enemies.clear();
			g2d.setColor(Color.BLUE);
			g2d.fillRect(0, 0, 500, 600);
			
			g2d.setColor(Color.yellow);
			g2d.fillOval(-30, -30, 180, 180);
	//	JOptionPane.showMessageDialog(null, "Good work, you have completed level " + (level-1) + ". Time for the boss!");
		//g2d.drawImage(ic2.getImage(), 0, 0, null);
		player.draw(g2d); // drawing player
		
		for(int i = 0; i < enemies.size(); i++){ //getting size of players and drawing all of them.
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
		
		for(int i = 0; i < missiles.size(); i++){
			Missile m = missiles.get(i);
			m.draw(g2d);
		}
		
		
		//lvlTXT = new JLabel("Level: " + Integer.toString(level));
		g2d.drawString("Level: " + Integer.toString(level), 430, 20);
		g2d.drawString("Made By Michael Morales", 5, 530); 
		g2d.drawString("v1.0 alpha", 5, 560); 
		
		}else{
		//g2d.drawImage(ic.getImage(), 0,0, null);
		g2d.setBackground(Color.BLACK);
		g2d.fillRect(0, 0, 500, 600);
		

		g2d.setColor(Color.white);
		g2d.fillOval(-30, -30, 180, 180);
		
		player.draw(g2d); // drawing player
		
		for(int i = 0; i < enemies.size(); i++){ //getting size of players and drawing all of them.
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
		
		for(int i = 0; i < missiles.size(); i++){
			Missile m = missiles.get(i);
			m.draw(g2d);
		}
			
		//lvlTXT = new JLabel("Level: " + Integer.toString(level));
		g2d.drawString("Level: " + Integer.toString(level), 430, 20);
		g2d.drawString("v1.0 alpha", 5, 560);
	
		}
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		player.update();// updating player for key listeners
		
		for(int i = 0; i < enemies.size(); i++){
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.update();
		}
		
		for(int i = 0; i < missiles.size(); i++){
			Missile m = missiles.get(i);
			m.update();
		}
		
		checkEnd();
		repaint();// repainting all objects
	}
	
	public static void removeMissile(Missile m){
		missiles.remove(m);
	}

	public static void addMissile(Missile m){ // method for adding multiple enemies.
		missiles.add(m);
	}
	
	public static ArrayList<Missile> getMissileList() {
		return missiles;
	}
	
	public static void addEnemy(Enemy e){ // method for adding multiple enemies.
		enemies.add(e);
	}
	
	public static void removeEnemy(Enemy e){
		enemies.remove(e);
	}
	
	public static ArrayList<Enemy> getEnemyList() {
		return enemies;
	}
	
	public void startGame(){
		enemyCount = level * 5;
		
		for(int i = 0; i < enemyCount; i++){ //adding 5 enemys at random points between 800 for x and y for 600.
			addEnemy(new Enemy(rand.nextInt(500), -10 + -rand.nextInt(600)));
		}
	}
	
	public void checkEnd(){
		if(enemies.size() == 0 ){
			level++;
			enemies.clear();
			missiles.clear(); 
			//	lvlTXT.setText("Level: " + Integer.toString(level));
			startGame();
		}
	}
	
	public void checkLEnd(){
		if(level == 10){
			if(enemies.size() == 0){
				JOptionPane.showMessageDialog(null, "Good work, you have completed level " + (level-1) + ". Time for the boss!");
				
			}
		}
	}
}
