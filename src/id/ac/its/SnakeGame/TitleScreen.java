package id.ac.its.SnakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
	static final int SCREEN_WIDTH = 1300;
	static final int SCREEN_HEIGHT = 750;
	//Font Handling
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	Font normalFont = new Font("arial", Font.PLAIN, 30);
	Font titleFont1;
	Font itimFont;
	//Color Handling
	Color transparent = new Color(0,0,0,0);
	
	public void createUI(ChoiceHandler choiceHandler) {
		window = new JFrame();
		window.pack();
		window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		window.setLocationRelativeTo(null);
		window.setTitle("PBO-Nihboss");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// background Handling
		try {
            window.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("img\\titleScreen.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

		//font handling
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			titleFont1 = Font.createFont(Font.TRUETYPE_FONT, new File("font\\IrishGrover.ttf")).deriveFont(85f);
			ge.registerFont(titleFont1);
			itimFont = Font.createFont(Font.TRUETYPE_FONT, new File("font\\Itim-Regular.ttf")).deriveFont(35f);
			ge.registerFont(itimFont);

		} 
		catch(Exception e){
			e.printStackTrace();
		}

		window.setLayout(null);
		window.setResizable(false);
		
//		Welcome Screen Handling
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(350, 170, 600, 150);
		titleNamePanel.setBackground(transparent);
		titleNameLabel = new JLabel("SNAKE GAMES");
		titleNameLabel.setFont(titleFont1);
		titleNamePanel.add(titleNameLabel);
		titleNamePanel.setForeground(Color.getColor("#945A32"));
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(425, 338, 410, 111);
		startButtonPanel.setBackground(transparent);
		
		startButton = new JButton(new ImageIcon("img\\Button.png"));
		startButton.setPreferredSize(new Dimension(400, 100));
		startButton.setBorderPainted(false);
		startButton.setBackground(transparent);
		startButton.setFocusPainted(false);
		startButton.addActionListener(choiceHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);
	
		// Level Option Handling
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(300,150,690,100);
		mainTextPanel.setBackground(transparent);
		window.add(mainTextPanel);

		mainTextArea = new JTextArea("Select ur Level");
		mainTextArea.setBounds(0,150,600,150);
		mainTextArea.setBackground(transparent);
		mainTextArea.setFont(titleFont1);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		ChoiceButtonPanel = new JPanel();
		ChoiceButtonPanel.setBounds(60,375,1182,109); 
		ChoiceButtonPanel.setBackground(transparent);
		window.add(ChoiceButtonPanel);

		choice1 = new JButton(new ImageIcon("img\\hard.png"));
		choice1.setBackground(transparent);
		choice1.setOpaque(false);
		choice1.setContentAreaFilled(false);
		choice1.setBorderPainted(false);
		choice1.setFocusPainted(false);
		ChoiceButtonPanel.add(choice1);
		choice1.setRolloverEnabled(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		
		choice2 = new JButton(new ImageIcon("img\\medium.png"));
		choice2.setBackground(transparent);
		choice2.setOpaque(false);
		choice2.setContentAreaFilled(false);
		choice2.setBorderPainted(false);
		choice2.setFocusPainted(false);
		ChoiceButtonPanel.add(choice2);
		choice2.setRolloverEnabled(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		
		choice3 = new JButton(new ImageIcon("img\\eazy.png"));
		choice3.setBackground(transparent);
		choice3.setOpaque(false);
		choice3.setContentAreaFilled(false);
		choice3.setBorderPainted(false);
		choice3.setFocusPainted(false);
		choice3.setRolloverEnabled(false);
		ChoiceButtonPanel.add(choice3);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");

		window.setVisible(true);

	}
}
