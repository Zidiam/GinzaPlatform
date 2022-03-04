import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GinzaCharacter {
	private GinzaImages Images = new GinzaImages();
	private ImageIcon currentFace;
	private GinzaPanel env;
	private int movement, jumpTimer, dy, oldy, Level, oldy2, jump2;
	private boolean jumping, left, right, jumpdown, jumping2, down, up, leftKey, rightKey;
	public Level currentLevel;
	private ArrayList<Point> solidBlockPoints;
	private ArrayList<Death> deathObjects = new ArrayList<Death>();
	public static int deathCount = 0;
	private static int x, y;
	
	public GinzaCharacter(GinzaPanel environment, int Level) {
		SoundEffect.init();
		currentFace = Images.frontFace;
		env = environment;
		x = 24;
		y = 24*18;
		jump2 = 0;
		movement = 12;
		jumpTimer = 10;
		jumping = left = right = down = jumpdown = up = leftKey = rightKey = jumping2 = false;
		dy = 0;
		this.Level = Level;
		currentLevel = new Level(environment, Level);
		solidBlockPoints = currentLevel.solidBlockPoints;
		Death.deathBlocksRight.clear();
	}
	
	public static void reset() {
		x = 24;
		y = 24*18;
	}
	
	public void changeLevel(int level) {
		Death.deathBlocksRight.clear();
		x = 24;
		y = 24*18;
		Level = level;
		currentLevel = new Level(env, Level);
		deathObjects = new ArrayList<Death>();
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < deathObjects.size(); i++) {
			deathObjects.get(i).update(g);
			if(deathObjects.get(i).isDead())
				deathObjects.remove(i);
		}
		currentFace.paintIcon(env, g, (int) x, (int) y);
		if(x < 200 && y > 250) {
			for(int i = 0; i < currentLevel.playerText.size(); i++) {
				String temp = "";
				for(int z = 3; z < currentLevel.playerText.get(i).size(); z++) {
					temp += " " + currentLevel.playerText.get(i).get(z);
				}
				//g.drawString(temp, Integer.parseInt((String)currentLevel.playerText.get(i).get(0)), Integer.parseInt((String)currentLevel.playerText.get(i).get(1)));
				g.drawString(temp, x, y);
			}
			
			for(int i = 0; i < currentLevel.enemyText.size(); i++) {
				String temp = "";
				for(int z = 3; z < currentLevel.enemyText.get(i).size(); z++) {
					temp += " " + currentLevel.enemyText.get(i).get(z);
				}
				g.drawString(temp, Integer.parseInt((String)currentLevel.enemyText.get(i).get(0)), Integer.parseInt((String)currentLevel.enemyText.get(i).get(1)));
			}
		}
	}
	
	public boolean levelFinished() {
		return x >= env.WIDTH;
	}
	
	public boolean checkFlooring() {
		for(int i = 0; i < currentLevel.solidBlockPoints.size(); i++) {
			if (y == currentLevel.solidBlockPoints.get(i).y - Images.getCharacter_Size_Height() &&
				x + Images.getCharacter_Size_Width() > currentLevel.solidBlockPoints.get(i).x &&
				x < currentLevel.solidBlockPoints.get(i).x + Images.getCharacter_Size_Width()) {
				jumping = false;
				return true;
			}
			
		}
		return false;
	}
	
	public boolean checkCeiling() {
		for(int i = 0; i < currentLevel.solidBlockPoints.size(); i++) {
			if (y == currentLevel.solidBlockPoints.get(i).y + Images.getCharacter_Size_Width() &&
				x + Images.getCharacter_Size_Width() > currentLevel.solidBlockPoints.get(i).x &&
				x < currentLevel.solidBlockPoints.get(i).x + Images.getCharacter_Size_Width()) {
				return true;
			}
		}
		return false;
	}
	
	private int Min(int a, int b) {
		if(a < b)
			return a;
		else
			return b;
	}
	private int Max(int a, int b) {
		if(a > b)
			return a;
		else
			return b;
	}
	
	public boolean checkDeathCollision() {
		for(int i = 0; i < currentLevel.allBlocks.size(); i++) {
			for(int t = 0; t < Images.getBadSmallCircleNames().size(); t++) {
				if(currentLevel.allBlocks.get(i).get(2).toString().equals(Images.getBadSmallCircleNames().get(t))) {
					int CircleX = Integer.parseInt((String) currentLevel.allBlocks.get(i).get(0)) + 12;
					int CircleY = Integer.parseInt((String) currentLevel.allBlocks.get(i).get(1)) + 12;
					
					int DeltaX = CircleX - Max(x, Min(CircleX, x + 24));
					int DeltaY = CircleY - Max(y, Min(CircleY, y + 48));
					if ((DeltaX * DeltaX + DeltaY * DeltaY) < (12 * 12))
						return true;
				}
			}
			
			for(int t = 0; t < Images.getBadBigCircleNames().size(); t++) {
				if(currentLevel.allBlocks.get(i).get(2).toString().equals(Images.getBadBigCircleNames().get(t))) {
					int CircleX = Integer.parseInt((String) currentLevel.allBlocks.get(i).get(0)) + 24;
					int CircleY = Integer.parseInt((String) currentLevel.allBlocks.get(i).get(1)) + 24;
					
					int DeltaX = CircleX - Max(x, Min(CircleX, x + 24));
					int DeltaY = CircleY - Max(y, Min(CircleY, y + 48));
					if ((DeltaX * DeltaX + DeltaY * DeltaY) < (24 * 24))
						return true;
				}
			}
			
		}
		return false;
	}
	
	public boolean checkLeftCollision() {	
		if (left == true) {
			for(int i = 0; i < currentLevel.solidBlockPoints.size(); i++) {
				if (x <= currentLevel.solidBlockPoints.get(i).x + Images.getCharacter_Size_Width() &&
						x >= currentLevel.solidBlockPoints.get(i).x &&
						y > currentLevel.solidBlockPoints.get(i).y - Images.getCharacter_Size_Height() &&
						y + Images.getCharacter_Size_Height()  < currentLevel.solidBlockPoints.get(i).y + Images.getCharacter_Size_Height() + Images.getCharacter_Size_Width()) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	public boolean checkRightCollision() {
		if (right == true ) {
			for(int i = 0; i < currentLevel.solidBlockPoints.size(); i++) {
				if (x + Images.getCharacter_Size_Width() <= currentLevel.solidBlockPoints.get(i).x + Images.getCharacter_Size_Width() &&
						x + Images.getCharacter_Size_Width() >= currentLevel.solidBlockPoints.get(i).x &&
						y > currentLevel.solidBlockPoints.get(i).y - Images.getCharacter_Size_Height() &&
						y + Images.getCharacter_Size_Height()  < currentLevel.solidBlockPoints.get(i).y + Images.getCharacter_Size_Height() + Images.getCharacter_Size_Width()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkLeftCollision(int a) {	
		if (left == true) {
			for(int i = 0; i < currentLevel.solidBlockPoints.size(); i++) {
				if (x - a <= currentLevel.solidBlockPoints.get(i).x + Images.getCharacter_Size_Width() &&
						x - a >= currentLevel.solidBlockPoints.get(i).x &&
						y > currentLevel.solidBlockPoints.get(i).y - Images.getCharacter_Size_Height() &&
						y + Images.getCharacter_Size_Height()  < currentLevel.solidBlockPoints.get(i).y + Images.getCharacter_Size_Height() + Images.getCharacter_Size_Width()) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	public boolean checkRightCollision(int a) {
		if (right == true ) {
			for(int i = 0; i < currentLevel.solidBlockPoints.size(); i++) {
				if (x + a + Images.getCharacter_Size_Width() <= currentLevel.solidBlockPoints.get(i).x + Images.getCharacter_Size_Width() &&
						x + a + Images.getCharacter_Size_Width() >= currentLevel.solidBlockPoints.get(i).x &&
						y > currentLevel.solidBlockPoints.get(i).y - Images.getCharacter_Size_Height() &&
						y + Images.getCharacter_Size_Height()  < currentLevel.solidBlockPoints.get(i).y + Images.getCharacter_Size_Height() + Images.getCharacter_Size_Width()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void jump() {
		if(jumping == false && checkFlooring() == true) {
			SoundEffect.Jump.play();
			oldy = y;
			jumping = true;
		}
		if(jumping == true && jump2 < 84) {
			jump2 += movement;
		}
	}
	
	public void moveLeft() {
		left = true;
		right = false;
	}
	
	public void moveRight() {
		right = true;
		left = false;
	}
	
	public void moveUp() {
		up = true;
	}
	
	public void stopUp() {
		up = false;
	}
	
	public void stopRight() {
		right = false;
	}
	
	public void stopLeft() {
		left = false;
	}
	
	public void update() {
		
		if(checkDeathCollision() == true) {
			System.out.println("tesssst");
			//reset
			deathCount ++;
			Death temp = new Death(env, x, y, currentLevel.allBlocks);
			deathObjects.add(temp);
			SoundEffect.Death.play();
			x = 24;
			y = 24*18;
		}
		if(y + Images.getCharacter_Size_Height() - movement >= env.HEIGHT) {
			//reset
			deathCount ++;
			Death temp = new Death(env, x, y, currentLevel.allBlocks);
			deathObjects.add(temp);
			SoundEffect.Death.play();
			x = 24;
			y = 24*18;
		}
		if(left == true && checkLeftCollision() == false) {
			if(x % movement != 0 && checkLeftCollision(movement) == true) {
				x += movement/2;
			}
			if(x > 0)
				x -= movement;
			
		}
		if(right == true && checkRightCollision() == false) {
			if(x % movement != 0 && checkRightCollision(movement) == true) {
				x -= movement/2;
			}
			x += movement;
		}
		
		if(up == true) {
			jump();
		}
		
		if(checkCeiling() == true) {
			jumping = false;
		}
		
		if(jumping == true) {
			System.out.println("test");
			if(y >= oldy-jump2) {
				if(right == true && checkRightCollision(6) == false)
					x += 6;
				if(left == true && checkLeftCollision(6) == false) {
					if(x > 0)
						x -= 6;
				}
				y -= movement;
			}
			else {
				jump2 = 0;
				jumping = false;
			}
		}
		
		if(checkFlooring() == false && jumping == false) {
			if(right == true && checkRightCollision(6) == false)
				x += 6;
			if(left == true && checkLeftCollision(6) == false) {
				if(x > 0)
					x -= 6;
			}
			y += movement;
		}
	}

}
