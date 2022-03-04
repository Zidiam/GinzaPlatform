import java.awt.BorderLayout;

import javax.swing.JFrame;

/*
 * Project6_1.java -- Displays a window with a button that when clicked will display a number between 1 - 100
 * Jason Melnik
 * CSC 120
 * 11/07/2018
 */
public class WorldMaker{
	public static void main(String[] args) {
		JFrame frame = new JFrame("World Maker!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new WorldMakerPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(new WorldMakerControls(), BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
