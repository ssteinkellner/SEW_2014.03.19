package ssteinkellner.cipher;

/**
 * Interface zur verschl�sselung
 * <br />Die Methoden encrypt und decrypt sollen die eigentliche Verschl�sselungs-
 * bzw. Entschl�sselungsarbeit vornehmen. Dazu �bernehmen sie als Parameter einen
 * Text, wandeln diesen in Kleinbuchstaben um und geben den ver- bzw. entschl�sselten
 * Text zur�ck. Dabei sollen sie das Geheimalphabet als Substitutionsschl�ssel verwenden
 * (Zeichen die nicht im Alphabet sind, sollen 1:1 im Geheimtext umgesetzt werden).
 * @author SSteinkellner
 * @version 2014.03.22
 */
public interface Cipher {
	
	/**
	 * macht eigentliche Verschl�sselungsarbeit
	 * <br />Zeichen die nicht im Alphabet sind, werden 1:1 umgesetzt
	 * @param text - ein Text, der in Kleinbuchstaben umgewandelt zum verschl�sseln verwendet wird
	 * @return gibt den verschl�sselten Text zur�ck
	 */
	public abstract String encrypt(String text);
	
	/**
	 * macht eigentliche Entschl�sselungsarbeit
	 * <br />Zeichen die nicht im Alphabet sind, werden 1:1 umgesetzt
	 * @param text - ein Text, der in Kleinbuchstaben umgewandelt zum entschl�sseln verwendet wird
	 * @return gibt den entschl�sselten Text zur�ck
	 */
	public abstract String decrypt(String text);
}
