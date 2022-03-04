import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GinzaPanel extends JPanel{
	public final int WIDTH = 1020, HEIGHT = 516;
	private int speed = 40;
	private Timer timer;
	private GinzaCharacter Player;
	private Level currentLevel;
	private int playerLevel;
	private GinzaWorld world;
	public boolean start, levelSelected, back, settingsScreen;
	private int Level;
	private GinzaMenuScreen menu;
	private LevelSelectScreen levelscreen = new LevelSelectScreen(this);
	private JButton backButton;
	private int levelsUnlocked;
	private SettingsScreen screenSettings;
	
	public GinzaPanel() {
		levelsUnlocked = 1;
		
		setLayout(null);
		SoundEffect.init();
		backButton = new JButton("<-Back");
		backButton.setBounds(0, 0, 100, 25);
		backButton.addActionListener(new ButtonListener());
		backButton.setBackground(Color.CYAN);
		
		start = levelSelected = back = settingsScreen =false;
		menu = new GinzaMenuScreen(this);
		
		world = new GinzaWorld(this, 1);
		Level = 1;
		
		screenSettings = new SettingsScreen(this);
		
		SoundEffect.Background.play();
		
		timer = new Timer(speed, new ReboundListener());
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
	}
	
	public int getLevelsUnlocked() {
		return levelsUnlocked;
	}
	
	public void addLevelsUnlocked(int a) {
		levelsUnlocked += a;
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		if(back == true) {
			back = false;
			levelscreen = new LevelSelectScreen(this);
			menu = new GinzaMenuScreen(this);
			remove(backButton);
		}
		if (menu.isPlaying() == true) {
			start = true;
		}
		
		if (menu.isLevelSelect() == true && start == false) {
			levelSelected = true;
		}
		
		if (menu.isSettingsSelect() == true && start == false) {
			settingsScreen = true;
		}
		
		if(settingsScreen == true) {
			add(backButton);
			screenSettings.setupScreen();
			screenSettings.paint(page);
		}
		
		if(levelSelected == true) {
			removeAll();
			revalidate();
			add(backButton);
			levelscreen.unlockLevels();
			levelscreen.paint(page);
			levelscreen.levelSetup();
			if(levelscreen.getLevel() != 0) {
				start = true;
				levelSelected = false;
				world = new GinzaWorld(this, levelscreen.getLevel());
				Level = levelscreen.getLevel();
			}
		}
		
		if(start == true) {
			add(backButton);
			world.update(page);
		}
		
		if(start == false && levelSelected == false && settingsScreen == false)
			menu.paint(page);
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == backButton) {
				removeAll();
				revalidate();
				start = false;
				levelSelected = false;
				back = true;
				settingsScreen = false;
			}
		}
	}
	
	private class ReboundListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Updates the position of the image and possibly the direction
		//  of movement whenever the timer fires an action event.
		//--------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			//loops
			repaint();
			
		}
	}

}
