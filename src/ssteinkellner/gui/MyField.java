package ssteinkellner.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * ein JPanel, auf dem ein titel und ein textfeld sitzen
 * @author SSteinkellner
 * @version 2014.04.02
 */
public class MyField extends JPanel{
	private JLabel label;
	private JTextField feld;
	
	/**
	 * creates a new JPanel, with the title on top of a Textfield
	 * @param title - title for the textField
	 */
	public MyField(String title){
		label = new JLabel(title);
		feld = new JTextField();
		
		this.setLayout(new BorderLayout());
		this.add(label,BorderLayout.NORTH);
		this.add(feld);
	}
	
	/**
	 * to get and edit the parameters of the Textfield
	 * @return TextField that is shown when an object of MyField is used
	 */
	public JTextField getField(){
		return feld;
	}
}
