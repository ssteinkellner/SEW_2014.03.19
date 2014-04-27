package ssteinkellner_dstrasser.cipher;

/**
 * Für das Geheimalphabet werden Buchstaben aus dem Keyword vorne an das Standard alphabet gehängt
 * und doppelte Buchstaben entfernt
 * 
 * @author Dominik Strasser
 * @version 23.4.14
 */
public class KeywordCipher extends MonoAlphabeticCipher
{
    /**
     * Konstruktor um denn konstruktor der superklasse aufzurufen und um das keyword zu setzen
     */
    public KeywordCipher(String keyword) throws SecretException
    {
        super();
        this.setKeyword(keyword);
    }
    /**
     * Methoden um das geheimalphabet zu erstellen
     */
    public void setKeyword(String keyword) throws SecretException
    {
    	String key="";
        for(int i=0;i<keyword.length();i++){
        	char c = keyword.charAt(i);
            if(keyword.indexOf(c) == i){
                key += c;
            }
        }
        
        String alphabet="", standardAlphabet = MonoAlphabeticCipher.standartAlphabet;
        for(int i = 0; i < standardAlphabet.length(); i++)
        {
            char c = standardAlphabet.charAt(i);
            if(key.indexOf(c)<0){
                alphabet += c;
            }
        }
        
        super.setSecretAlphabet(key + alphabet);
    }
}
