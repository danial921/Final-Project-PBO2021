package id.ac.its.SnakeGame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import id.ac.its.SnakeGame.Game.ChoiceHandler;

public class TitleScreen {
	JFrame window;
	JPanel titleNamePanel, startButtonPanel,mainTextPanel, ChoiceButtonPanel, highScoreInfo;
	JPanel gamePanel;
	JLabel titleNameLabel,highLabel;
	JButton startButton,choice1,choice2,choice3, choice4;
	JTextArea mainTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	Font normalFont = new Font("arial", Font.PLAIN, 30);
	

	public void createUI(ChoiceHandler choiceHandler) {
		window = new JFrame();
		window.pack();
		window.setSize(1300, 750);
		window.setLocationRelativeTo(null);
		window.setTitle("PBO-Nihboss");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
	//	Welcome Screen
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(350, 150, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("SNAKE GAMES");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(550, 450, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("PLAY");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(choiceHandler);
		startButton.setActionCommand("start");
		//startButton.setBorder(new RoundBtn(15));
		startButtonPanel.add(startButton);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);

		// Level Option
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(300,150,690,100);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);

		mainTextArea = new JTextArea("Select ur Level");
		mainTextArea.setBounds(0,150,600,150);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		ChoiceButtonPanel = new JPanel();
		ChoiceButtonPanel.setBounds(60,375,1182,109); 
		ChoiceButtonPanel.setBackground(Color.black);
		window.add(ChoiceButtonPanel);

		choice1 = new JButton("Hard");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		ChoiceButtonPanel.add(choice1);
		choice1.setBorder(new RoundBtn(15));
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		
		choice2 = new JButton("Medium");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		ChoiceButtonPanel.add(choice2);
		choice2.setBorder(new RoundBtn(15));
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		
		choice3 = new JButton("Eazy");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		ChoiceButtonPanel.add(choice3);
		choice3.setBorder(new RoundBtn(15));
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");

		window.setVisible(true);
	}
	public void setVisible(boolean b) {
	}
}
