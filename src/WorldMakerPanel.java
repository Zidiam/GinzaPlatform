import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseEvent;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WorldMakerPanel extends JPanel{
	private final int WIDTH = 1020, HEIGHT = 516;
	private int speed = 40;
	private Timer timer;
	private int mousex, mousey, oldmousex, oldmousey;
	
	private Level worldname;
	
	private String filename;
	
	private GinzaImages Images = new GinzaImages();
	
	private Scanner scan = new Scanner(System.in);
	
	private boolean deleteOn, fileChosen;
	private String currentBlock;
	
	private String important = " ";
	
	private WorldMakerControls controls;
	
	public WorldMakerPanel(){
		controls = new WorldMakerControls();
		
		deleteOn = true;
		fileChosen = false;

		currentBlock = "grassBlock ";

		timer = new Timer(speed, new ReboundListener());
		
		addMouseMotionListener(new MouseStuff());
		addMouseListener(new MouseStuff2());
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
		
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		if (fileChosen == true) {
			worldname = new Level(filename);
			worldname.paint(this, page);
		}
		page.drawRect(mousex - mousex%24, mousey-mousey%24, 24, 24);
	}
	
	private class MouseStuff extends MouseMotionAdapter {

		public void mouseMoved(MouseEvent e) {
			mousex = e.getX();
			mousey = e.getY();
		}
		public void mouseDragged(MouseEvent e) {
			if (fileChosen == true && deleteOn == false && !currentBlock.equals("  ")){
				worldname.read.addToFile((mousex - mousex%24) + "," + (mousey - mousey%24) + "," + currentBlock);
			}
			mousex = e.getX();
			mousey = e.getY();
		}
	}
	
	private class MouseStuff2 extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
			System.out.println((mousex - mousex%24) + "," + (mousey - mousey%24));
			if (fileChosen == true && deleteOn == false && !currentBlock.equals("  ")){
				worldname.read.addToFile((mousex - mousex%24) + "," + (mousey - mousey%24) + "," + currentBlock);
				mousex = e.getX();
				mousey = e.getY();
			}
			
			if (deleteOn == true && fileChosen == true) {
				worldname.read.removeFromFile((mousex - mousex%24) + "," + (mousey - mousey%24) + ",");
				
				mousex = e.getX();
				mousey = e.getY();
			}
		}
	}
	
	public void importantStuff() {
		System.out.println(important);
		if(important == "Load") {
			System.out.println("What World you want to Load");
			fileChosen = true;
			filename = scan.next();
			
			worldname = new Level(filename);
			
		}
		if(important == "Create") {
			fileChosen = true;
			System.out.println("What do you want to call the new World? ");
			filename = scan.next();
			LevelReader quick = new LevelReader();
			quick.createFile(filename);
			worldname = new Level(filename);
		}
		if(important == "Delete") {
			deleteOn = true;
			System.out.println("Deletion Tool Selected");
		}
		if(important == "Add") {
			deleteOn = false;
			System.out.println("Add Tool Selected");
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
			if(important != controls.getImportant()) {
				important = controls.getImportant();
				importantStuff();
			}
			
			if(controls.getBlock() != " ")
				currentBlock = controls.getBlock();
			repaint();
		}
	}
}
	
	

