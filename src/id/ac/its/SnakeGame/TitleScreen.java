package id.ac.its.SnakeGame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

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
	

	public void createUI(ChoiceHandler cHandler) {
		window = new JFrame();
		window.pack();
		window.setSize(1300, 750);
		window.setLocationRelativeTo(null);
		window.setTitle("PBO-Nihboss");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
//		Welcome Screen
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
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		//startButton.setBorder(new RoundBtn(15));
		startButtonPanel.add(startButton);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		window.setVisible(true);
	}
}
