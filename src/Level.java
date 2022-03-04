import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.io.*;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * 
 */
public class Level {
	private GinzaImages Images;
	private GinzaPanel env;
	private boolean fileFound = false;
	public ArrayList<Point> solidBlockPoints = new ArrayList<Point>();
	public ArrayList<ArrayList> allSolidBlocks = new ArrayList<ArrayList>();
	public ArrayList<ArrayList> allNoneSolidBlocks = new ArrayList<ArrayList>();
	public ArrayList<ArrayList> allBlocks = new ArrayList<ArrayList>();
	public ArrayList<ImageIcon> solidBlockImages = new ArrayList<ImageIcon>();
	public ArrayList<ImageIcon> noneSolidBlockImages = new ArrayList<ImageIcon>();
	public ArrayList<ArrayList> enemyText = new ArrayList<ArrayList>();
	public ArrayList<ArrayList> playerText = new ArrayList<ArrayList>();
	private JButton nextButton, menuButton, levelsButton, restartButton;
	private ImageIcon drawImage;
	private String url;
	private Scanner fileScan, urlScan;
	private int Level, seconds;
	public LevelReader read;
	private String filename;
	private boolean nextLevel, timer;
	private Timer time = new Timer();
	private java.util.Date createdDate = new java.util.Date();
	private java.util.Date now;
	private static int fullTime = 0;
	
	public Level(GinzaPanel environment, int level){
		
		nextLevel = timer = false;
		
		nextButton = new JButton();
		menuButton = new JButton();
		levelsButton = new JButton();
		restartButton = new JButton();
		
		menuButton.setBackground(Color.red);
		nextButton.setBackground(Color.red);
		levelsButton.setBackground(Color.red);
		restartButton.setBackground(Color.red);
		
		nextButton.setText("Next");
		menuButton.setText("Menu");
		levelsButton.setText("Levels");
		restartButton.setText("Restart");
		
		this.Level = level;
		env = environment;
		
		env.setLayout(null);
		nextButton.setBounds(475, 200, 100, 25);
		nextButton.addActionListener(new ButtonListener());		
		
		menuButton.setBounds(475, 225, 100, 25);
		menuButton.addActionListener(new ButtonListener());		
		
		levelsButton.setBounds(475, 250, 100, 25);
		levelsButton.addActionListener(new ButtonListener());		
		
		restartButton.setBounds(475, 275, 100, 25);
		restartButton.addActionListener(new ButtonListener());	
		
		Images = new GinzaImages();
		solidBlockImages = Images.getSolidBlockImages();
		noneSolidBlockImages = Images.getNoneSolidBlockImages();
		LevelSetup(level);
	}
	
	public String getTime() {
		if (timer == false) {
			now = new java.util.Date();
			timer = true;
			fullTime += (int)((now.getTime() - this.createdDate.getTime()) / 1000);
		}
		seconds = (int)((now.getTime() - this.createdDate.getTime()) / 1000);
        return (int)seconds/86400 + ":" + (int)seconds/3600 + ":" + (int)seconds/60 + ":" + (int)(seconds - (int)seconds/86400 * 86400 - (int)seconds/3600 * 3600 - (int)seconds/60 * 60);
	}
	
	public ImageIcon getRank() {
		if(seconds <= 10)
			return Images.threeStar;
		if(seconds <= 30 && seconds > 10)
			return Images.twoStar;
		if(seconds <= 60 && seconds > 30)
			return Images.oneStar;
		if(seconds > 60)
			return Images.zeroStar;
		return null;
	}
	
//	public String getTime(int seconds) {
//		return (int)seconds/86400 + ":" + (int)seconds/3600 + ":" + (int)seconds/60 + ":" + (int)(seconds - (int)seconds/86400 * 86400 - (int)seconds/3600 * 3600 - (int)seconds/60 * 60);
//	}
	
	public Level(String filename){
		Images = new GinzaImages();
		solidBlockImages = Images.getSolidBlockImages();
		noneSolidBlockImages = Images.getNoneSolidBlockImages();
		
		LevelSetup(filename);
	}
	
	public void endLevel(Graphics g) {
		g.clearRect(375, 100, 300, 300);
		g.setColor(Color.ORANGE);
		g.fillRect(375, 100, 300, 300);
		g.setColor(Color.BLACK);
		g.drawRect(375, 100, 300, 300);
		g.drawString("Time: " + getTime(), 485, 185);
		getRank().paintIcon(env, g, 400, 100);
		env.add(nextButton);
		env.add(menuButton);
		env.add(levelsButton);
		env.add(restartButton);
	}
	
	public boolean getNextLevel() {
		return nextLevel;
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == nextButton) {
				nextLevel = true;
			}
			
			if (e.getSource() == menuButton) {
				System.out.println("tad");
				env.removeAll();
				env.revalidate();
				env.back = true;
				env.start = false;
				env.levelSelected = false;
				env.settingsScreen = false;
			}
			
			if (e.getSource() == levelsButton) {
				env.removeAll();
				env.revalidate();
				env.back = true;
				env.start = false;
				env.levelSelected = true;
			}
			
			if (e.getSource() == restartButton) {
				levelSelect(Level);
				GinzaCharacter.reset();
			}
		}
	}
	
	public void levelSelect(int level){
		this.Level = level;
		nextLevel = false;
		timer = false;
		createdDate = new java.util.Date();
		this.LevelSetup(level);
	}
	
	public void LevelSetup(int level) {
		read = new LevelReader(level);
		solidBlockPoints = read.getSolidBlockPoints();
		allSolidBlocks = read.getSolidBlocks();
		allNoneSolidBlocks = read.getNoneSolidBlocks();
		allBlocks = read.getAllBlocks();
		playerText = read.getPlayerText();
		enemyText = read.getEnemyText();
	}
	
	public void LevelSetup(String filename) {
		read = new LevelReader(filename);
		this.filename = filename;
		solidBlockPoints = read.getSolidBlockPoints();
		allSolidBlocks = read.getSolidBlocks();
		allNoneSolidBlocks = read.getNoneSolidBlocks();
		allBlocks = read.getAllBlocks();
		playerText = read.getPlayerText();
		enemyText = read.getEnemyText();
	}
	
	
	public void paint(Graphics g) {
		for(int i = 0; i < allSolidBlocks.size(); i++) {
			for(int x = 0; x < Images.getSolidBlockNames().size(); x++) {
				if(allSolidBlocks.get(i).get(2).toString().equals(Images.getSolidBlockNames().get(x).toString()))
					Images.getSolidBlockImages().get(x).paintIcon(env, g, Integer.parseInt((String) allSolidBlocks.get(i).get(0)), Integer.parseInt((String) allSolidBlocks.get(i).get(1)));
			}
		}
		
		for(int i = 0; i < Death.deathBlocksRight.size(); i++)
			Images.bloodBlock.paintIcon(env, g, Death.deathBlocksRight.get(i).x, Death.deathBlocksRight.get(i).y);
		
		for(int i = 0; i < allNoneSolidBlocks.size(); i++) {
			for(int x = 0; x < Images.getNoneSolidBlockNames().size(); x++) {
				if(allNoneSolidBlocks.get(i).get(2).toString().equals(Images.getNoneSolidBlockNames().get(x).toString()))
					Images.getNoneSolidBlockImages().get(x).paintIcon(env, g, Integer.parseInt((String) allNoneSolidBlocks.get(i).get(0)), Integer.parseInt((String) allNoneSolidBlocks.get(i).get(1)));
			}
		}
	}
	
	public void paint(WorldMakerPanel env, Graphics g) {
		for(int i = 0; i < allSolidBlocks.size(); i++) {
			for(int x = 0; x < Images.getSolidBlockNames().size(); x++) {
				if(allSolidBlocks.get(i).get(2).toString().equals(Images.getSolidBlockNames().get(x).toString()))
					Images.getSolidBlockImages().get(x).paintIcon(env, g, Integer.parseInt((String) allSolidBlocks.get(i).get(0)), Integer.parseInt((String) allSolidBlocks.get(i).get(1)));
			}
		}
		
		for(int i = 0; i < allNoneSolidBlocks.size(); i++) {
			for(int x = 0; x < Images.getNoneSolidBlockNames().size(); x++) {
				if(allNoneSolidBlocks.get(i).get(2).toString().equals(Images.getNoneSolidBlockNames().get(x).toString()))
					Images.getNoneSolidBlockImages().get(x).paintIcon(env, g, Integer.parseInt((String) allNoneSolidBlocks.get(i).get(0)), Integer.parseInt((String) allNoneSolidBlocks.get(i).get(1)));
			}
		}
	}
	
	
}
