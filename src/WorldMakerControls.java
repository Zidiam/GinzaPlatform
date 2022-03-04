import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/*
 * 
 */
public class WorldMakerControls extends JPanel{
	private String[] solidBlockNames;
	private JComboBox<String> solidBlocksCombo;
	
	private String[] nonsolidBlockNames;
	private JComboBox<String> nonsolidBlocksCombo;
	
	
	private String[] importantStrings = {" ", "Load", "Delete", "Create", "Add"};
	private JComboBox<String> importantStringsCombo;
	
	private GinzaImages Images = new GinzaImages();
	private static String current = " ";
	private static String important;
	
	private int solidblock, nonsolid;
	
	public WorldMakerControls() {
		solidblock = nonsolid = 0;
		
		importantStringsCombo = new JComboBox<String>(importantStrings);
		importantStringsCombo.addActionListener(new ComboListener());
		add(importantStringsCombo);
		
		solidBlockNames = (String[]) Images.getSolidBlockNames().toArray(new String[Images.getSolidBlockNames().size()]);
		solidBlocksCombo = new JComboBox<String>(solidBlockNames);
		solidBlocksCombo.addActionListener(new ComboListener());
		add(solidBlocksCombo);
		
		nonsolidBlockNames = (String[]) Images.getNoneSolidBlockNames().toArray(new String[Images.getNoneSolidBlockNames().size()]);
		nonsolidBlocksCombo = new JComboBox<String>(nonsolidBlockNames);
		nonsolidBlocksCombo.addActionListener(new ComboListener());
		add(nonsolidBlocksCombo);
	}
	
	private class ComboListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(solidblock != solidBlocksCombo.getSelectedIndex()) {
				current =  solidBlockNames[solidBlocksCombo.getSelectedIndex()];
				solidblock = solidBlocksCombo.getSelectedIndex();
			}
			if(nonsolid != nonsolidBlocksCombo.getSelectedIndex()) {
				current =  nonsolidBlockNames[nonsolidBlocksCombo.getSelectedIndex()];
				nonsolid = nonsolidBlocksCombo.getSelectedIndex();
			}
			important = importantStrings[importantStringsCombo.getSelectedIndex()];
		}

	}
	
	public String getImportant() {
		return important;
	}
	
	public String getBlock(){
		return current + " ";
	}
	
}
