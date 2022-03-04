import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GinzaWorld{ 
	public final int WIDTH = 1020, HEIGHT = 516;
	private int speed = 40;
	private Timer timer;
	private GinzaCharacter Player;
	private Level currentLevel;
	public int playerLevel;
	private GinzaPanel env;
	
	public GinzaWorld(GinzaPanel environment, int assignedLevel){
		env = environment;
		env.addKeyListener(new DirectionListener());
		
		playerLevel = assignedLevel;
		
		currentLevel = new Level(env, playerLevel);
		
		Player = new GinzaCharacter(env, playerLevel);
		
	}
	
	public void paint(Graphics page)
	{
		currentLevel.paint(page);
		page.drawString("Deaths: " + GinzaCharacter.deathCount, 500, 10);
		Player.paint(page);
		if(currentLevel.getNextLevel() == false && Player.levelFinished()) {
			currentLevel.endLevel(page);
		}
	}
	
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_W) {
				Player.jump();
				Player.moveUp();
			}
			if(event.getKeyCode() == KeyEvent.VK_A) {
				Player.moveLeft();
			}
			if(event.getKeyCode() == KeyEvent.VK_D) {
				Player.moveRight();
			}
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_D) {
				Player.stopRight();
			}
			if(event.getKeyCode() == KeyEvent.VK_A) {
				Player.stopLeft();
			}
			if(event.getKeyCode() == KeyEvent.VK_W) {
				Player.stopUp();
			}
		}
	}
	
	public void update(Graphics g) {
		//loops
		if(Player.levelFinished()) {
			if(currentLevel.getNextLevel() == true) {
				env.addLevelsUnlocked(1);
				playerLevel ++;
				Player.changeLevel(playerLevel);
				currentLevel.levelSelect(playerLevel);
			}
		}
		else {
			Player.update();
		}
		paint(g);
	}
}
	
	

