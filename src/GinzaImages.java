import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GinzaImages {
	private int Character_Size_Width = 24;
	private int Character_Size_Height = 48;
	private ArrayList<String> solidBlockNames = new ArrayList<String>();
	private ArrayList<ImageIcon> solidBlockImages = new ArrayList<ImageIcon>();
	
	private ArrayList<String> noneSolidBlockNames = new ArrayList<String>();
	private ArrayList<ImageIcon> noneSolidBlockImages = new ArrayList<ImageIcon>();
	
	private ArrayList<String> badSmallCircleNames = new ArrayList<String>();
	private ArrayList<String> badBigCircleNames = new ArrayList<String>();
	
	public ImageIcon frontFace, rightFace, grassBlock, metalBlock, smallSaw, bigSaw, menuScreen, 
					 playButton, bloodAnimation, light_grayBlock, skyBlock, lock, bloodSpatter1, bloodSpatter2, 
					 bloodSpatter3, bloodSpatter4, bloodSpatter5, bloodSpatter6, bloodSpatter7, bloodSpatter8, 
					 brownBlock, bloodBlock, enemyImage, levelSelectBackground, settingsBackground, muteButton, 
					 volumeButton, settingsButton, zeroStar, oneStar, twoStar, threeStar;
	
	public int getCharacter_Size_Width() {
		return Character_Size_Width;
	}
	
	public int getCharacter_Size_Height() {
		return Character_Size_Height;
	}
	
	public ArrayList getSolidBlockNames() {
		return solidBlockNames;
	}
	
	public ArrayList<ImageIcon> getSolidBlockImages() {
		return solidBlockImages;
	}
	
	public ArrayList getNoneSolidBlockNames() {
		return noneSolidBlockNames;
	}
	
	public ArrayList<ImageIcon> getNoneSolidBlockImages() {
		return noneSolidBlockImages;
	}
	
	public ArrayList getBadSmallCircleNames() {
		return badSmallCircleNames;
	}
	
	public ArrayList getBadBigCircleNames() {
		return badBigCircleNames;
	}
	
	public void setupLists() {
		solidBlockNames.add(" ");
		solidBlockNames.add("grassBlock");
		solidBlockNames.add("metalBlock");
		solidBlockNames.add("brownBlock");
		
		solidBlockImages.add(grassBlock);
		solidBlockImages.add(grassBlock);
		solidBlockImages.add(metalBlock);
		solidBlockImages.add(brownBlock);
		
		
		
		noneSolidBlockNames.add(" ");
		noneSolidBlockNames.add("smallSaw");
		noneSolidBlockNames.add("bigSaw");
		noneSolidBlockNames.add("skyBlock");
		noneSolidBlockNames.add("light_grayBlock");
		noneSolidBlockNames.add("enemyImage");
		
		noneSolidBlockImages.add(smallSaw);
		noneSolidBlockImages.add(smallSaw);
		noneSolidBlockImages.add(bigSaw);
		noneSolidBlockImages.add(skyBlock);
		noneSolidBlockImages.add(light_grayBlock);
		noneSolidBlockImages.add(enemyImage);
		
		badSmallCircleNames.add("smallSaw");
		badBigCircleNames.add("bigSaw");
	}
	
	public GinzaImages(){
		ImageIcon test = new ImageIcon("src\\Images\\standingStill.png");
		Image img = test.getImage();
		BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Height, null);
		frontFace = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\standingStill.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Height, null);
		rightFace = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\grass.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Width, null);
		grassBlock = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\metal.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Width, null);
		metalBlock = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\smallSaw.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Width, null);
		smallSaw = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bigSaw.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Height, Character_Size_Height, null);
		bigSaw = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\menuScreen.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 12, 12, 1020, 516, null);
		menuScreen = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\levelSelectBackground.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 12, 12, 1020, 516, null);
		levelSelectBackground = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\levelSelectBackground.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 12, 12, 1020, 516, null);
		settingsBackground = new ImageIcon(bi);		
		
		test = new ImageIcon("src\\Images\\playButton.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 50, null);
		playButton= new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\light_gray.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Width, null);
		light_grayBlock = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\sky.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Width, null);
		skyBlock = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\lock.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 25, 25, null);
		lock = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 48, 48, null);
		bloodSpatter1 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 60, 60, null);
		bloodSpatter2 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 72, 72, null);
		bloodSpatter3 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 84, 84, null);
		bloodSpatter4 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 106, 106, null);
		bloodSpatter5 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 130, 130, null);
		bloodSpatter6 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 178, 178, null);
		bloodSpatter7 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodSpatter.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 226, 226, null);
		bloodSpatter8 = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\bloodBlock.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Width, null);
		bloodBlock = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\brownBlock.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Width, null);
		brownBlock = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\enemyImg.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, Character_Size_Width, Character_Size_Height, null);
		enemyImage = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\VolumeButton.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 25, 25, null);
		volumeButton = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\MuteButton.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 25, 25, null);
		muteButton = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\settingSelect.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 50, null);
		settingsButton = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\0Star.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 75, null);
		zeroStar = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\1Star.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 75, null);
		oneStar = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\2Star.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 75, null);
		twoStar = new ImageIcon(bi);
		
		test = new ImageIcon("src\\Images\\3Star.png");
		img = test.getImage();
		bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		g = bi.createGraphics();
		g.drawImage(img, 0, 0, 250, 75, null);
		threeStar = new ImageIcon(bi);
		
		this.setupLists();
	}
}
