import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {
	
	Player p;

	public KeyAdapt(Player player){ // method for adapting the player to keys
		p = player;
	}

	public void keyPressed(KeyEvent e){ // key pressed for player
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){ // key released for player
		p.keyReleased(e);
	}
	
}
