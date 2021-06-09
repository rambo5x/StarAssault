 import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
   
		JFrame frame = new JFrame("StarAssault - by Michael A. Morales"); //Title of app
		frame.setSize(500, 600); // size of app
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exiting on close
		frame.setResizable(false); // not resizable yet
		frame.add(new GameFrame()); // adding our game into this app
		frame.setVisible(true); // is visible
		
	}

}   
  