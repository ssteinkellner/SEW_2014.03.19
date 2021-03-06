package ssteinkellner_dstrasser.cipher;

/**
 * Verschiebt für das Geheimalphabet das standard Alphabet um den Wert value
 * 
 * @author Dominik Strasser
 * @version 23.4.14
 */
public class ShiftCipher extends MonoAlphabeticCipher
{
    /**
     * Konstruktor um denn konstruktor der superklasse aufzurufen und um denn Wert zu übergeben
     */
    public ShiftCipher (int value) throws SecretException
    {
        super();
        this.setShiftAmount(value);
    }
    /**
     * Das Geheimalphabet wird erzeugt und übergeben indem man das Alphabet um den Wert Value verschiebt
     */
    public void setShiftAmount(int shiftvalue) throws SecretException
    {
        if(shiftvalue > 30 || shiftvalue < 0)
        {
            return;
        }
        
        String key = MonoAlphabeticCipher.standartAlphabet.substring(shiftvalue) + 
        MonoAlphabeticCipher.standartAlphabet.substring(0,shiftvalue);
        super.setSecretAlphabet(key);
    }
}
