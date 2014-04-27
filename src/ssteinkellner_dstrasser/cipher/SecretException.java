package ssteinkellner_dstrasser.cipher;

/**
 * an exception to use for the secret alphabet of a cipher
 * @author Steinkellner Sebastian
 * @version 2014.03.26
 */
public class SecretException extends Exception{
	private String text;
	
	/**
	 * creates a new Secret Exception
	 * @param cause - information for the user
	 */
	public SecretException(String cause){
		super(cause);
		text = cause;
	}
	
	@Override
	public String getLocalizedMessage(){
		return text;
	}
}
