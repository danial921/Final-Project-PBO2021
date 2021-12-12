package id.ac.its.SnakeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	int SCREEN_WIDTH = (int)size.width;
	int SCREEN_HEIGHT = (int)size.height;
	static final int UNIT_SIZE = 25;
	int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
//	static final int DELAY = 120;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	private Image apples;
	private Image kepala;
	int score;
	int score2;
	int highScore;
	
	GamePanel(final int DELAY){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame(DELAY);
	}
	
	/*private void loadImages() {
        ImageIcon app = new ImageIcon("img/apples.png");
        apples = app.getImage();
        
        ImageIcon iih = new ImageIcon("img/kanan.png");
        kepala = iih.getImage();
	}*/
	
	public void startGame(final int DELAY) {
		newApple();
		running = true;
		timer = new Timer(DELAY,this);
		timer.start();
		
		ImageIcon kiri = new ImageIcon("img/kanan.png");
	    kepala = kiri.getImage();
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		ImageIcon app = new ImageIcon("img/apples.png");
	    apples = app.getImage();
	    
	    if(running) {
			//g.setColor(Color.red);
			// g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
			
	        g.drawImage(apples, appleX, appleY, this);
		
			for(int i = 0; i< bodyParts;i++) {
				if(i == 0) {
					
					g.drawImage(kepala, x[i], y[i], this);
					//g.setColor(Color.blue);
					//g.fill3DRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE, true);
					//g.setColor(Color.white);
					//g.fillOval(x[i]+(UNIT_SIZE/5/2), y[i]+(UNIT_SIZE/5/2), UNIT_SIZE/5*4, UNIT_SIZE/5*4);
				}
				else {
					g.setColor(new Color(45,180,0));
					//g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
					// g.drawOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
					g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}			
			}
			g.setColor(Color.red);
			g.setFont( new Font("Ink Free",Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		}
		else {
			gameOver(g);
		}
		
	}
	
	public void newApple(){
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	public void move(){
		for(int i = bodyParts;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
	}
	public void checkCollisions() {
		//checks if head collides with body
		for(int i = bodyParts;i>0;i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		//check if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		//check if head touches top border
		if(y[0] < 0) {
			running = false;
		}
		//check if head touches bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
	}
	
	public void highscoreinisiate (){
		File file = new File("highscore.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
            	try	{
                    score2 = Integer.parseInt(line.trim());
                    if (score2 >= highScore)               
                    { 
                        highScore = score2; 
                    }
                } catch (NumberFormatException e1) {
                    System.err.println("ignoring invalid score: " + line);
                }
                line = reader.readLine();
            }
            reader.close();
		}
		catch (IOException ex) {
            System.err.println("ERROR reading scores from file");
		}
	}
	public void gameOver(Graphics g) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("highscore.txt", true));
            writer.println(applesEaten);              
            writer.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		File file = new File("highscore.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
            	try	{
                    score = Integer.parseInt(line.trim());
                    if (score >= highScore)               
                    { 
                        highScore = score; 
                    }
                } catch (NumberFormatException e1) {
                    System.err.println("ERROR");
                }
                line = reader.readLine();
            }
            reader.close();
		}
		catch (IOException ex) {
            System.err.println("ERROR");
		}
		
		//Score
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
		
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 50));
		FontMetrics metrics3 = getFontMetrics(g.getFont());
		g.drawString("High Score: " + highScore , (SCREEN_WIDTH - metrics3.stringWidth("High Score : " + highScore))/2, SCREEN_HEIGHT/3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
					ImageIcon kiri = new ImageIcon("img/kiri.png");
       	 			kepala = kiri.getImage();
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
					ImageIcon kiri = new ImageIcon("img/kanan.png");
       	 			kepala = kiri.getImage();
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
					ImageIcon kiri = new ImageIcon("img/atas.png");
       	 			kepala = kiri.getImage();
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
					ImageIcon kiri = new ImageIcon("img/bawah.png");
       	 			kepala = kiri.getImage();
				}
				break;
			}
		}
	}
}
