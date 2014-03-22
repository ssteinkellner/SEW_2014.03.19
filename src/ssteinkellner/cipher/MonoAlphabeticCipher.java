package ssteinkellner.cipher;

/**
 * Die Klasse MonoAlphabeticCipher stellt die Basisfunktionalitäten auf Basis des Interfaces Cipher zur Verfügung.
 * <br />Sie setzt das Geheimalphabet immer auf das Ausgangsalphabet (abcdefghijklmnopqrstuvwxyzäöüß)
 * wodurch bei der Superklasse de facto keine Verschlüsselung stattfindet. Trotzdem sollen die
 * beiden Methoden encrypt und decrypt mit jedem Geheimalphabet arbeiten können, da ja die
 * Subklassen diese Methoden nicht implementieren, das Geheimalphabet je nach Klasse aber
 * anders gesetzt wird. Die Methode getSecretAlphabet soll einfach das Geheimalphabet
 * zurück geben. Die Methode setSecretAlphabet (Achtung! diese ist nicht public) soll für
 * Subklassen die  Möglichkeit bereitstellen, das Attribut zu ändern.
 * @author SSteinkellner
 * @version 2014.03.22
 */
public class MonoAlphabeticCipher implements Cipher{
	private String secretAlphabet;
	
	/**
	 * setzt das Geheimalphabet auf das Ausgangsalphabet (abcdefghijklmnopqrstuvwxyzäöüß)
	 */
	public MonoAlphabeticCipher(){
		secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	
	/**
	 * gibt einfach das Geheimalphabet zurück
	 * @return the Secret Alphabet
	 */
	public String getSecretAlphabet(){
		return secretAlphabet;
	}
	
	/**
	 * stellt für Subklassen die  Möglichkeit bereit, das Attribut zu ändern
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
