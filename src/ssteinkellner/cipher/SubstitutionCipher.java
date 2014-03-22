package ssteinkellner.cipher;

import org.omg.IOP.CodecPackage.FormatMismatch;

/**
 * Die Klasse SubstitutionCipher soll eine allgemeine Substitionsverschl�sselung darstellen.
 * Dazu muss das gesamte Geheimalphabet (alle 30 Zeichen) an ein Objekt dieser Klasse im
 * Konstruktor oder in der Methode setSecretAlphabet �bergeben werden.
 * @author SSteinkellner
 * @version 2014.03.22
 */
public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	/**
	 * @param secretAlphabet - Alphabet zum ver/entschl�sseln
	 * @throws FormatMismatch wenn das Geheimalphabet nicht 30 zeichen lang ist
	 */
	public SubstitutionCipher(String secretAlphabet) throws FormatMismatch{
		super();
		super.setSecretAlphabet(secretAlphabet);
	}
	
	/**
	 * @param secretAlphabet - Alphabet zum ver/entschl�sseln
	 * @throws FormatMismatch wenn das Geheimalphabet nicht 30 zeichen lang ist
	 */
	public void setSecretAlphabet(String secretAlphabet) throws FormatMismatch{
		super.setSecretAlphabet(secretAlphabet);
	}
}
