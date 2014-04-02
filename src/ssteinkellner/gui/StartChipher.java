package ssteinkellner.gui;

import java.awt.Dimension;

import ssteinkellner.cipher.Cipher;
import ssteinkellner.cipher.SecretException;
import ssteinkellner.cipher.SubstitutionCipher;

public class StartChipher {
	private MyModel m;
	private MyView v;
	private MyFrame f;
	
	public static void main(String[] args){
		new StartChipher("Cipher");
	}
	
	/**
	 * starts the program
	 * <br /> => generates the model, the view and the frame and loads all ciphers
	 * @param title
	 */
	public StartChipher(String title){
		m = new MyModel();
		try {
			Cipher defaultCipher = new SubstitutionCipher("defghijklmnopqrstuvwxyzäöüßabc");
			m.add("SubstitutionCipher", defaultCipher);
		} catch (SecretException se) {
			se.printStackTrace();
			return;
		}
		v = new MyView(m);
		f = new MyFrame(v,title);
		f.setMinimumSize(new Dimension(300,200));
	}
}
