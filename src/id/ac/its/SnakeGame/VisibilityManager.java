package id.ac.its.SnakeGame;

public class VisibilityManager {

	TitleScreen ui;
	
	public VisibilityManager(TitleScreen userinterface){
        ui = userinterface;
    }
	
	public void showTitleScreen(){
        // show title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // hide Level Option
        ui.mainTextPanel.setVisible(false);
        ui.ChoiceButtonPanel.setVisible(false);
        ui.highScoreInfo.setVisible(false);
        
        // Game Dropzone
        ui.gamePanel.setVisible(false);
    }
	
	public void titleToTown(){
        // hide screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        
        new GameFrame(100);
    }
}
