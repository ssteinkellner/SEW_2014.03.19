package ssteinkellner.cipher;

/**
 * Die Klasse MonoAlphabeticCipher stellt die Basisfunktionalitäten auf Basis des Interfaces Cipher zur Verfügung.
 * <br />Sie setzt das Geheimalphabet immer auf das standartAlphabet (abcdefghijklmnopqrstuvwxyzäöüß)
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
	protected static String standartAlphabet;
	
	/**
	 * setzt das Geheimalphabet auf das standartAlphabet (abcdefghijklmnopqrstuvwxyzäöüß)
	 */
	public MonoAlphabeticCipher(){
		standartAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		secretAlphabet = standartAlphabet;
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
	 * @param secretAlphabet - das Geheimalphabet, das verwendet werden soll
	 * @throws SecretException wenn das Geheimalphabet nicht 30 zeichen lang ist
	 */
	protected void setSecretAlphabet(String secretAlphabet) throws SecretException{
		if(secretAlphabet.length()!=30){
			throw(new SecretException("secretAlphabet has to be exactly 30 characters long"));
		}
		for(int i=0;i<secretAlphabet.length();i++){
			for(int j=0;j<secretAlphabet.length()-1;j++){
				if(i!=j){
					if(secretAlphabet.charAt(i)==secretAlphabet.charAt(j)){
						throw(new SecretException("secretAlphabet has a doubled character"));
					}
				}
			}
		}
		this.secretAlphabet = secretAlphabet;
	}
	
	
	@Override
	public String encrypt(String text) {
		String out = "";	// verschlüsselter String
		boolean def;		// default-wert (wenn der buchstabe nicht im secretAlphabet vorkommt)
		String in = text.toLowerCase();
		/*
		 * Überlegung dazu:
		 * ich das zeichen an jeder stelle im text an
		 * und prüfe, ob es im standartAlphabet vorhanen ist
		 * wenn ja, dann ersetze ich es mit dem zeichen, das im
		 * secretalphabet an der stelle sitzt, an der im
		 * standartAlphabet das eben untersuchte zeichen ist
		 */
		for(int tpos=0;tpos<in.length();tpos++){
			def=true;
			for(int apos=0;apos<standartAlphabet.length();apos++){ // text-position
				if(in.charAt(tpos) == secretAlphabet.charAt(apos)){ // alphabet-position
					def=false;
					out+=standartAlphabet.charAt(apos);
					apos = secretAlphabet.length();
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
				if(in.charAt(tpos) == standartAlphabet.charAt(apos)){
					def=false;
					out+=secretAlphabet.charAt(apos);
					apos = secretAlphabet.length();
				}
			}
			if(def){
				out+=in.charAt(tpos);
			}
		}
		return out;
	}
}
