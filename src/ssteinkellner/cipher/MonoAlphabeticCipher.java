package ssteinkellner.cipher;

import org.omg.IOP.CodecPackage.FormatMismatch;

/**
 * Die Klasse MonoAlphabeticCipher stellt die Basisfunktionalit�ten auf Basis des Interfaces Cipher zur Verf�gung.
 * <br />Sie setzt das Geheimalphabet immer auf das Ausgangsalphabet (abcdefghijklmnopqrstuvwxyz����)
 * wodurch bei der Superklasse de facto keine Verschl�sselung stattfindet. Trotzdem sollen die
 * beiden Methoden encrypt und decrypt mit jedem Geheimalphabet arbeiten k�nnen, da ja die
 * Subklassen diese Methoden nicht implementieren, das Geheimalphabet je nach Klasse aber
 * anders gesetzt wird. Die Methode getSecretAlphabet soll einfach das Geheimalphabet
 * zur�ck geben. Die Methode setSecretAlphabet (Achtung! diese ist nicht public) soll f�r
 * Subklassen die  M�glichkeit bereitstellen, das Attribut zu �ndern.
 * @author SSteinkellner
 * @version 2014.03.22
 */
public class MonoAlphabeticCipher implements Cipher{
	private String secretAlphabet, ausgangsAlphabet;
	
	/**
	 * setzt das Geheimalphabet auf das Ausgangsalphabet (abcdefghijklmnopqrstuvwxyz����)
	 */
	public MonoAlphabeticCipher(){
		ausgangsAlphabet = "abcdefghijklmnopqrstuvwxyz����";
		secretAlphabet = ausgangsAlphabet;
	}
	
	/**
	 * gibt einfach das Geheimalphabet zur�ck
	 * @return the Secret Alphabet
	 */
	public String getSecretAlphabet(){
		return secretAlphabet;
	}
	
	/**
	 * stellt f�r Subklassen die  M�glichkeit bereit, das Attribut zu �ndern
	 * @param secretAlphabet - das Geheimalphabet, das verwendet werden soll
	 * @throws FormatMismatch wenn das Geheimalphabet nicht 30 zeichen lang ist
	 */
	protected void setSecretAlphabet(String secretAlphabet) throws FormatMismatch{
		if(secretAlphabet.length()!=30){
			throw(new FormatMismatch(""));
		}
		this.secretAlphabet = secretAlphabet;
	}
	
	
	@Override
	public String encrypt(String text) {
		String out = "";	// verschl�sselter String
		boolean def;		// default-wert (wenn der buchstabe nicht im secretAlphabet vorkommt)
		String in = text.toLowerCase();
		/*
		 * �berlegung dazu:
		 * ich das zeichen an jeder stelle im text an
		 * und pr�fe, ob es im ausgangsalphabet vorhanen ist
		 * wenn ja, dann ersetze ich es mit dem zeichen, das im
		 * secretalphabet an der stelle sitzt, an der im
		 * ausgangsalphabet das eben untersuchte zeichen ist
		 */
		for(int tpos=0;tpos<in.length();tpos++){
			def=true;
			for(int apos=0;apos<ausgangsAlphabet.length();apos++){ // text-position
				if(in.charAt(tpos) == ausgangsAlphabet.charAt(apos)){ // alphabet-position
					def=false;
					out+=secretAlphabet.charAt(apos);
				}
			}
			if(def){
				out+=in.charAt(tpos);
			}
		}
		return out;
	}
	@Override
	public String decrypt(String text) {
		String out = "";
		boolean def;
		String in = text.toLowerCase();
		for(int tpos=0;tpos<in.length();tpos++){
			def=true;
			for(int apos=0;apos<secretAlphabet.length();apos++){
				if(in.charAt(tpos) == secretAlphabet.charAt(apos)){
					def=false;
					out+=ausgangsAlphabet.charAt(apos);
				}
			}
			if(def){
				out+=in.charAt(tpos);
			}
		}
		return out;
	}
}
