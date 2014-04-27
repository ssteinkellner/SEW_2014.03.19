

/**
 * 
 * 
 * @author Dominik Strasser
 * @version 23.4.14
 */
public class TranspositionCipher implements Cipher
{
	private int transpositionLevel;
	

	public TranspositionCipher(int transpositionLevel) throws SecretException
	{
		setTranspositionLevel(transpositionLevel);
	}
	
	
	public void setTranspositionLevel(int level) throws SecretException
	{
		if(level<0){
			throw(new SecretException("transpositionLevel hast to be positive"));
		}
		
		transpositionLevel = level;
	}
	
	/**
	 * VerschlÃÂ¼sselt den eingelesenen Text und gibt ihn verschlÃÂ¼sselt zurÃÂ¼ck
	 */
	public String encrypt (String text)
	{
		String[] teile = new String[transpositionLevel];
		// jeder string im array ist eine transpositionsstufe
		
		// array initialisieren
		for(int i=0;i<teile.length;i++){
			teile[i]="";
		}
		
		// in arrays aufteilen
		int stufe=0;
		for(int i=0;i<text.length();i++){
//			System.out.println(stufe + " : "+ teile[stufe] + " + " + text.charAt(i));	// debugausgabe
			teile[stufe] += text.charAt(i);
			
			stufe++;
			if(stufe==teile.length){
				stufe=0;
			}
		}
		
		text = "";
		
		// array zu einem text zusammenfassen
		for(int i=0;i<teile.length;i++){
			if(teile[i].length()<teile[0].length()){
				teile[i] += (char) 191;
			}	//unicode zeichen zum auffÃ¼llen
			
			text += teile[i];
		}
		
		return text;
	}
	
	/**
	 * EntschlÃÂ¼sselt den eingelesenen Text und gibt ihn entschlÃÂ¼sselt zurÃÂ¼ck
	 */
	public String decrypt (String text)
	{
		String[] teile = new String[transpositionLevel];
		// jeder string im array ist eine transpositionsstufe
		
		int length = (int) Math.ceil((double) text.length()/(double)transpositionLevel);
		// berechung, wie lang jede zeile ist (mit aufrunden)
//		System.out.println(text.length() + "/" + transpositionLevel + " = " + length);	//debugausgabe
		
		if(teile.length*length != text.length()){
			return "ERROR: text and transpositionlevel are incompatible!";
		}
		
		// aufteilung des textes in stufen
		int pos;
		for(int i=0;i<teile.length;i++){
			pos = i*length;
			teile[i] = text.substring(pos, pos+length);
			System.out.println(teile[i]);	//debugausgabe
		}
		
		text = "";
		
		// zerlegen der stufen in text
		for(int i=0;i<teile[0].length();i++){
			for(int stufe=0;stufe<teile.length;stufe++){
				text += teile[stufe].charAt(i);
			}
		}
		
		return text;
	}
}
