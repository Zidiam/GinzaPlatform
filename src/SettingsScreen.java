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
public class SettingsScreen {
	private GinzaImages Images;
	private GinzaPanel env;
	private JButton volumeMute;
	private boolean mute;
	
	public SettingsScreen(GinzaPanel environment) {
		mute = false;
		Images = new GinzaImages();
		volumeMute = new JButton(new ImageIcon("src//Images//VolumeButton.png"));
		volumeMute.setBounds(100, 100, 50, 50);
		volumeMute.addActionListener(new ButtonListener());
		volumeMute.setBackground(Color.RED);
		
		env = environment;
		env.setLayout(null);
	}

	public void setupScreen() {
		env.add(volumeMute);
	}
	
	public void paint(Graphics g) {
		Images.levelSelectBackground.paintIcon(env, g, 0, 0);
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == volumeMute) {
				mute = !mute;
				if (mute == true) {
					volumeMute.setIcon(Images.muteButton);
					//SoundEffect.stopMusic();
				}
				else {
					//SoundEffect.volume = SoundEffect.Volume.LOW;
					volumeMute.setIcon(Images.volumeButton);
				}
			}
		}
	}
	public void Wipe() {
		env.removeAll();
		env.revalidate();
	}
	
}
