package id.ac.its.SnakeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	ChoiceHandler cHandler = new ChoiceHandler();
	TitleScreen ui =  new TitleScreen();
	VisibilityManager vm = new VisibilityManager(ui);
	
	public static void main(String[] args) {
		 new Game();
	}

	public Game() {
		ui.createUI(cHandler);
		vm.showTitleScreen();
	}
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String yourChoice = event.getActionCommand();
			if (yourChoice.equals("start")) {
				vm.levelSelector();
			}
			if (yourChoice.equals("c1")) {
				// vm.MainGame();
				new GameFrame(60);
				vm.showTitleScreen();
				}
			if (yourChoice.equals("c2")) {
				// vm.MainGame();
				new GameFrame(100);
				vm.showTitleScreen();
			}
			if (yourChoice.equals("c3")) {
				// vm.MainGame();
				new GameFrame(200);
				vm.showTitleScreen();
			}
		}
	}
}
