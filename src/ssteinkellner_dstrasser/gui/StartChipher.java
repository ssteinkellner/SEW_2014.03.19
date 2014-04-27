package ssteinkellner_dstrasser.gui;

import java.awt.Dimension;

import ssteinkellner_dstrasser.cipher.*;

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
			Cipher defaultCipher = new SubstitutionCipher("ßüöäzyxwvutsrqponmlkjihgfedcba");
			m.add("SubstitutionCipher", defaultCipher);
		} catch (SecretException se) {
			se.printStackTrace();
			return;
		}
		
		try {
			m.add("KeywordCipher", new KeywordCipher("hallo"));
		} catch (SecretException se) {
			se.printStackTrace();
			return;
		}
		
		try {
			m.add("ShiftCipher", new ShiftCipher(5));
		} catch (SecretException se) {
			se.printStackTrace();
			return;
		}
		
		try {
			m.add("TranspositionCipher", new TranspositionCipher(5));
		} catch (SecretException se) {
			se.printStackTrace();
			return;
		}
		
		v = new MyView(m);
		f = new MyFrame(v,title);
		f.setMinimumSize(new Dimension(300,200));
	}
}
