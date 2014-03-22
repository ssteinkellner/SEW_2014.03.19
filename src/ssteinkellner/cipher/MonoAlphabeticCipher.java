package ssteinkellner.cipher;

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
	private String secretAlphabet;
	
	/**
	 * setzt das Geheimalphabet auf das Ausgangsalphabet (abcdefghijklmnopqrstuvwxyz����)
	 */
	public MonoAlphabeticCipher(){
		secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
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
	 * @param secretAlphabet
	 * @return
	 */
	protected void setSecretAlphabet(String secretAlphabet){
		
	}
	
	
	@Override
	public String encrypt(String text) {
		return null;
	}
	@Override
	public String decrypt(String text) {
		return null;
	}
}
