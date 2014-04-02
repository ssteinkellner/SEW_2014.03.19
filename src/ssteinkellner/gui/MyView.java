package ssteinkellner.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author SSteinkellner
 * @version 2014.04.02
 */
public class MyView extends JPanel implements ActionListener{
	private MyModel m;
	
	//grafische objekte
	private JButton[] buttons;
	private MyField[] felder;
	private JPanel feldPanel, buttonPanel;
	
	//variablen-arrays
	private String[]
			ftext = {"Klartext:","verschlüsselt:"},
			btext = {"verschlüsseln","entschlüsseln","optionen"};
	
	public MyView(MyModel model){
		m = model;
		
		// generate panels
		feldPanel = new JPanel();
		buttonPanel = new JPanel();
		
		feldPanel.setLayout(new GridLayout(ftext.length,1));
		buttonPanel.setLayout(new GridLayout(btext.length,1));
		
		// generate fields
		felder = new MyField[ftext.length];
		for(int i=0;i<ftext.length;i++){
			felder[i] = new MyField(ftext[i]);
			feldPanel.add(felder[i]);
		}
		
		// generate buttons
		buttons = new JButton[btext.length];
		for(int i=0;i<btext.length;i++){
			buttons[i] = new JButton(btext[i]);
			buttonPanel.add(buttons[i]);
		}
		
		this.setLayout(new BorderLayout());
		this.add(feldPanel);
		this.add(buttonPanel,BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}
}
