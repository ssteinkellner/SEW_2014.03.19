
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
    public KeywordCipher(String keyword)
    {
        super();
        this.setKeyword(keyword);
    }
    /**
     * Methoden um das geheimalphabet zu erstellen
     */
    public void setKeyword(String keyword)
    {
        String key = keyword;
        String alphabet="", standardAlphabet = MonoAlphabeticCipher.standardAlphabet;
        for(int i = 0; i < standardAlphabet.length(); i++)
        {
            char c = standardAlphabet.charAt(i);
            if(keyword.indexOf(c)<0){
                alphabet += c;
            }
        }
        super.setSecretAlphabet(alphabet);
    }
}
