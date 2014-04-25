
/**
 * Verschiebt für das Geheimalphabet das standard Alphabet um den Wert value
 * 
 * @author Dominik Strasser
 * @version 23.4.14
 */
public class ShiftCipher extends MonoAlphabeticCipher
{
    public ShiftCipher (int value)
    {
        super();
        this.setShiftAmount(value);
    }
    public void setShiftAmount(int shiftvalue)
    {
        if(shiftvalue > 30 || shiftvalue < 0)
        {
            return;
        }
        
        String key = MonoAlphabeticCipher.standardAlphabet.substring(shiftvalue) + 
        MonoAlphabeticCipher.standardAlphabet.substring(0,shiftvalue);
        super.setSecretAlphabet(key);
    }
}
