package id.ac.its.SnakeGame;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	GameFrame(int Delay){
		this.add(new GamePanel(Delay));
		this.setTitle("Snake");
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
