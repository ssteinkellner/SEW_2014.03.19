package ssteinkellner.cipher;


/**
 * Die Klasse SubstitutionCipher soll eine allgemeine Substitionsverschlüsselung darstellen.
 * Dazu muss das gesamte Geheimalphabet (alle 30 Zeichen) an ein Objekt dieser Klasse im
 * Konstruktor oder in der Methode setSecretAlphabet übergeben werden.
 * @author SSteinkellner
 * @version 2014.03.22
 */
public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	/**
	 * @param secretAlphabet - Alphabet zum ver/entschlüsseln
	 * @throws SecretException wenn das Geheimalphabet nicht 30 zeichen lang ist
	 */
	public SubstitutionCipher(String secretAlphabet) throws SecretException{
		super();
		super.setSecretAlphabet(secretAlphabet);
	}
	
	/**
	 * @param secretAlphabet - Alphabet zum ver/entschlüsseln
	 * @throws SecretException wenn das Geheimalphabet nicht 30 zeichen lang ist
	 */
	public void setSecretAlphabet(String secretAlphabet) throws SecretException{
		super.setSecretAlphabet(secretAlphabet);
	}
}
