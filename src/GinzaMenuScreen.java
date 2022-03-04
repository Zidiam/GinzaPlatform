import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/*
 * 
 */
public class GinzaMenuScreen {
	private GinzaImages Images;
	private GinzaPanel env;
	private JButton playButton, levelSelectButton, settingsSelectButton;
	private boolean play, levelSelected, settingsSelected;
	
	public GinzaMenuScreen(GinzaPanel environment) {
		play = levelSelected = settingsSelected = false;
		
		
		playButton = new JButton(new ImageIcon("src//Images//playButton.png"));
		levelSelectButton = new JButton(new ImageIcon("src//Images//levelSelect.png"));
		settingsSelectButton = new JButton(new ImageIcon("src//Images//settingSelect.png"));
		
		env = environment;
		env.setLayout(null);
		playButton.setBounds(385, 150, 250, 50);
		playButton.addActionListener(new ButtonListener());
		
		levelSelectButton.setBounds(385, 200, 250, 50);
		levelSelectButton.addActionListener(new ButtonListener());
		
		settingsSelectButton.setBounds(385, 250, 250, 50);
		settingsSelectButton.addActionListener(new ButtonListener());
		
		env.add(playButton);
		env.add(levelSelectButton);
		env.add(settingsSelectButton);
		Images = new GinzaImages();
	}
	
	public void paint(Graphics g) {
		Images.menuScreen.paintIcon(env, g, 0, 0);
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == playButton) {
				play = true;
			}
			if (e.getSource() == levelSelectButton) {
				levelSelected = true;
			}
			if (e.getSource() == settingsSelectButton) {
				settingsSelected = true;
			}
		}
	}
	
	public boolean isPlaying() {
		if (play == true){
			env.removeAll();
			env.revalidate();
		}
		return play;
	}
	
	public boolean isLevelSelect() {
		if (levelSelected == true){
			env.removeAll();
			env.revalidate();
		}
		return levelSelected;
	}
	
	public boolean isSettingsSelect() {
		if (settingsSelected == true){
			env.removeAll();
			env.revalidate();
		}
		return settingsSelected;
	}
}
