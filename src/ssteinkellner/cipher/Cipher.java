package ssteinkellner.cipher;

/**
 * Interface zur verschlüsselung
 * <br />Die Methoden encrypt und decrypt sollen die eigentliche Verschlüsselungs-
 * bzw. Entschlüsselungsarbeit vornehmen. Dazu übernehmen sie als Parameter einen
 * Text, wandeln diesen in Kleinbuchstaben um und geben den ver- bzw. entschlüsselten
 * Text zurück. Dabei sollen sie das Geheimalphabet als Substitutionsschlüssel verwenden
 * (Zeichen die nicht im Alphabet sind, sollen 1:1 im Geheimtext umgesetzt werden).
 * @author SSteinkellner
 * @version 2014.03.22
 */
public interface Cipher {
	
	/**
	 * macht eigentliche Verschlüsselungsarbeit
	 * <br />Zeichen die nicht im Alphabet sind, werden 1:1 umgesetzt
	 * @param text - ein Text, der in Kleinbuchstaben umgewandelt zum verschlüsseln verwendet wird
	 * @return gibt den verschlüsselten Text zurück
	 */
	public abstract String encrypt(String text);
	
	/**
	 * macht eigentliche Entschlüsselungsarbeit
	 * <br />Zeichen die nicht im Alphabet sind, werden 1:1 umgesetzt
	 * @param text - ein Text, der in Kleinbuchstaben umgewandelt zum entschlüsseln verwendet wird
	 * @return gibt den entschlüsselten Text zurück
	 */
	public abstract String decrypt(String text);
}
