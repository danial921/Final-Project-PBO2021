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
				vm.titleToTown();
				
			}
		}
	}
}
