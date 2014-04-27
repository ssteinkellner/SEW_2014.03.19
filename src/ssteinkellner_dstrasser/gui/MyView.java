package ssteinkellner_dstrasser.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ssteinkellner_dstrasser.cipher.Cipher;
import ssteinkellner_dstrasser.cipher.SecretException;
import ssteinkellner_dstrasser.cipher.SubstitutionCipher;

/**
 * @author SSteinkellner
 * @version 2014.04.02
 */
public class MyView extends JPanel implements ActionListener{
	private MyModel m;
	
	//grafische objekte
	private JButton[] buttons;
	private MyArea[] felder;
	private JPanel feldPanel, buttonPanel;
	
	//Text-arrays
	private String[] ftext = {"Klartext:","verschlüsselt:"};
	private String[][] btext = {
			{"verschlüsseln","ver"},
			{"entschlüsseln","ent"},
			{"Optionen","opt"}};
		// text und actioncommand für buttons
	
	/**
	 * creates a new JPanel with the graphical interface
	 * @param model - model with the ciphers
	 */
	public MyView(MyModel model){
		m = model;
		
		// generate panels
		feldPanel = new JPanel();
		buttonPanel = new JPanel();
		
		feldPanel.setLayout(new GridLayout(ftext.length,1));
		buttonPanel.setLayout(new GridLayout(btext.length,1));
		
		// generate areas
		felder = new MyArea[ftext.length];
		for(int i=0;i<ftext.length;i++){
			felder[i] = new MyArea(ftext[i]);
			feldPanel.add(felder[i]);
		}
		
		// generate buttons
		buttons = new JButton[btext.length];
		for(int i=0;i<btext.length;i++){
			buttons[i] = new JButton(btext[i][0]);
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand(btext[i][1]);
			buttonPanel.add(buttons[i]);
		}
		
		// put all together
		this.setLayout(new BorderLayout());
		this.add(feldPanel);
		this.add(buttonPanel,BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		
		if(cmd.equals("ver")){
			if(felder[0].getArea().getText().length()<1){
				return;	//abbruch, wenn feld leer
			}
			String text = felder[0].getArea().getText();	//text aus feld 1 holen
			text = m.getActiveCipher().encrypt(text);		//text verschlüsseln
			felder[1].getArea().setText(text);				//text in feld 2 schreiben
		}else if(cmd.equals("ent")){
			if(felder[1].getArea().getText().length()<1){
				return;	//abbruch, wenn feld leer
			}
			String text = felder[1].getArea().getText();	//text aus feld 2 holen
			text = m.getActiveCipher().decrypt(text);		//text entschlüsseln
			felder[0].getArea().setText(text);				//text in feld 1 schreiben
		}else if(cmd.equals("opt")){
			JComboBox<String> wahl = new JComboBox<String>(m.getCipherNames()); //eine Dropdown-box mit den verschiedenen ciphern
			JTextField key = new JTextField(20);			//ein textfeld
			Object[] anzeige = {"select Cipher",wahl,key};	//ein object-array zum anzeigen im dialog
			int ok = JOptionPane.showConfirmDialog(null, anzeige, "options",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//			System.out.println(ok);
			if(ok!=0){ return; }	//return wenn nicht ok gedrückt wurde
			m.selectCipher(wahl.getSelectedIndex());	//dem model wird mitgeteilt, welcher cipher jetzt verwendet werden soll
			setCipherKey(key.getText());				//ruft methode zur schlüsseländerung auf
		}
	}
	
	/**
	 * method, that changes the key as needed for the active cipher
	 * @param key new key, that the user has typed into the textfield
	 */
	private void setCipherKey(String key){
		Cipher c = m.getActiveCipher();
		if(c instanceof SubstitutionCipher){
			try {
				((SubstitutionCipher)c).setSecretAlphabet(key);
			} catch (SecretException e) {
//				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
			}
//		}else if(c instanceof ShiftCipher){
//			try {
//				((ShiftCipher)c).setShiftAmount(Integer.parseInt(key));
//			} catch (SecretException e) {
////				e.printStackTrace();
//				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
//			}
//		}else if(c instanceof KeywordCipher){
//			try {
//				((KeywordCipher)c).setKeyword(key);
//			} catch (SecretException e) {
////			e.printStackTrace();
//				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
//			}
//		}else if(c instanceof TranspositionCipher){
//			try {
//				((TranspositionCipher)c)setTranspositionLevel(Integer.parseInt(key));
//			} catch (SecretException e) {
////			e.printStackTrace();
//				JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
//			}
		}
	}
}
