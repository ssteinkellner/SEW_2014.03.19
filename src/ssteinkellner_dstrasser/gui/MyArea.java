package ssteinkellner_dstrasser.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * a JPanel, with a visible titel and a textarea
 * @author SSteinkellner
 * @version 2014.04.02
 */
public class MyArea extends JPanel{
	private JLabel label;
	private JTextArea feld;
	
	/**
	 * creates a new JPanel, with the title on top of a TextArea
	 * @param title - title for the textArea
	 */
	public MyArea(String title){
		label = new JLabel(title);
		feld = new JTextArea();
		
		this.setLayout(new BorderLayout());
		this.add(label,BorderLayout.NORTH);
		this.add(feld);
	}
	
	/**
	 * to get and edit the parameters of the TextArea
	 * @return TextArea that is shown when an object of MyArea is used
	 */
	public JTextArea getArea(){
		return feld;
	}
}
