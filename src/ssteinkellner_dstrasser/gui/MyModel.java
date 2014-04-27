package ssteinkellner_dstrasser.gui;

import java.util.Iterator;
import java.util.LinkedList;

import ssteinkellner_dstrasser.cipher.Cipher;

/**
 * verschlüsselungs-algorithmus verwaltung
 * @author SSteinkellner
 * @version 2014.04.02
 */
public class MyModel {
	private LinkedList<String> names;
	private LinkedList<Cipher> ciphers;
	private int selected;
	
	/**
	 * model is used to keep track of the algorithms
	 */
	public MyModel(){
		names = new LinkedList<String>();
		ciphers = new LinkedList<Cipher>();
	}
	
	/**
	 * used to add a new algorithm
	 * @param name - name of the algorithm
	 * @param cipher - algorithm (class, that is implementing interface Cipher)
	 */
	public void add(String name, Cipher cipher){
		names.add(name);
		ciphers.add(cipher);
	}
	
	/**
	 * giving you the names of all the ciphers as an array
	 * <br />(to use in a drop-down-box or similar)
	 * @return array of names
	 */
	public String[] getCipherNames(){
		String[] ret = new String[names.size()];
		Iterator<String> i = names.iterator();
		for(int j=0;j<names.size();j++){
			ret[j]=i.next();
		}
		return ret;
	}
	
	/**
	 * gives you one of the ciphers
	 * @param index - index of the cipher (from the cipher-list)
	 * @return cipher at the specified index
	 */
	public Cipher getCipher(int index){
		return ciphers.get(index);
	}
	
	/**
	 * marks a cipher as active cipher
	 * @param index - index of the cipher (from the cipher-list)
	 */
	public void selectCipher(int index){
		selected = index;
	}
	
	/**
	 * gives you the cipher, that is marked as active
	 * @return active cipher
	 */
	public Cipher getActiveCipher(){
		return ciphers.get(selected);
	}
}
