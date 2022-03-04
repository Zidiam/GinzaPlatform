import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/*
 * 
 */
public class LevelSelectScreen {
	private GinzaImages Images;
	private GinzaPanel env;
	private ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	private int Level;
	private int levelsUnlocked;
	
	public LevelSelectScreen(GinzaPanel environment) {
		int x = 50;
		int y = 50;
		for(int i = 1; i <= 50; i++) {
			JButton button = new JButton(i + "", new ImageIcon("src//Images/lock.png"));
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.CENTER);
			button.setBounds(x, y, 50, 50);
			button.addActionListener(new ButtonListener());
			button.setBackground(Color.RED);
			x += 100;
			if(x >= 1000) {
				x = 50;
				y += 100;
			}
		    //button.setIcon(new ImageIcon("src//Images/lock.png"));
			levelButtons.add(button);
		}
		
		env = environment;
		levelsUnlocked = env.getLevelsUnlocked();
		env.setLayout(null);
		
		Images = new GinzaImages();
	}
	
	public void levelSetup() {
		for(JButton b : levelButtons)
			env.add(b);
	}
	
	public void unlockLevels() {
		levelsUnlocked = env.getLevelsUnlocked();
		for(int i = 0; i < levelsUnlocked; i++) {
			levelButtons.get(i).setIcon(null);
		}
	}
	
	public void paint(Graphics g) {
		Images.levelSelectBackground.paintIcon(env, g, 0, 0);
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < levelButtons.size(); i++) {
				if (e.getSource() == levelButtons.get(i) && i+1 <= levelsUnlocked) {
					Level = i + 1;
				}
			}
		}
	}
	
	public int getLevel() {
		if(Level != 0) {
			env.removeAll();
			env.revalidate();
		}
		return Level;
	}
	
	public void Wipe() {
		env.removeAll();
		env.revalidate();
	}
	
}
