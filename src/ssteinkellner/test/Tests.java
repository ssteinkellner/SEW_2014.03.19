package ssteinkellner.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.IOP.CodecPackage.FormatMismatch;

import ssteinkellner.cipher.SecretException;
import ssteinkellner.cipher.SubstitutionCipher;

public class Tests {
	SubstitutionCipher sub;
	String text;

	/**
	 * setzt die umgebung vor jedem test neu auf
	 * @throws SecretException SecretException wenn ein ungültiger schlüssel übergeben wird
	 */
	@Before
	public void setup() throws SecretException{
		text = "hallo";
		sub = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
	}
	
	
	/**
	 * testet, ob mit einem einzigen schlüssel nach ver- und entschlüsseln wieder das selbe raus kommt
	 */
	@Test
	public void test1() {
		trenner("ver und entschlüsseln");
		String ver = sub.encrypt(text);
		String ent = sub.decrypt(ver);
		System.out.println(text + " => " + ver + " => " + ent);
		Assert.assertEquals(ent,text);
	}

	/**
	 * testet, ob mit 2 verschiedenen schlüsseln 2 verschiedene ergebnisse heraus kommen
	 * @throws SecretException wenn ein ungültiger schlüssel übergeben wird
	 */
	@Test
	public void test2() throws SecretException{
		trenner("2 verschiedene alphabete");
		String ver1 = sub.encrypt(text);
		sub.setSecretAlphabet("mnbvcxyäölkjhgfdsaüpoiuztrewqß");
		String ver2 = sub.encrypt(text);
		System.out.println(text + " => " + ver1 + " / " + ver2);
		Assert.assertNotSame(ver1, ver2);
	}
	
	/**
	 * testet, ob eine exception geworfen wird, wenn ein string mit falscher länge übergeben wird
	 * @throws SecretException wenn ein ungültiger schlüssel übergeben wird
	 */
	@Test(expected=SecretException.class)
	public void test3() throws SecretException{
		sub.setSecretAlphabet("qwertz");
	}
	
	/**
	 * testet, ob die encrypt methode mit sonderzeichen zurecht kommt
	 * <br /> getestet zeichen: !"§$%&/()=?\#'+*~<>|@€^°,;.:-_
	 * @throws SecretException wenn ein ungültiger schlüssel übergeben wird
	 */
	@Test
	public void test4() throws SecretException{
		trenner("Sonderzeichen");
		sub.setSecretAlphabet("!\"§$%&/()=?\\#'+*~<>|@€^°,;.:-_");
		System.out.println("alphabet: " + sub.getSecretAlphabet());
		System.out.println("!\"§$%&/()=?\\#'+*~<>|@€^°,;.:-_\n => " + sub.encrypt("!\"§$%&/()=?\\#'+*~<>|@€^°,;.:-_"));
		System.out.println("(wenn secretAlphabet und text gleich sind, sollte das StandartAlphabet heraus kommen)");
	}
	
	/**
	 * testet, wie zeichen verarbeitet werden, die nicht im secretalphabet vorkommen
	 * <br /> getestet zeichen: !"§$%&/()=?\#'+*~<>|@€^°,;.:-_
	 */
	@Test
	public void test5(){
		trenner("nicht im SecretAlphabet");
		System.out.println("alphabet: " + sub.getSecretAlphabet());
		System.out.println("!\"§$%&/()=?\\#'+*~<>|@€^°,;.:-_\n =>" + sub.encrypt("!\"§$%&/()=?\\#'+*~<>|@€^°,;.:-_"));
	}
	
	/**
	 * testet, wie zeichen verarbeitet werden, die doppelt im secretalphabet vorkommen
	 * @throws SecretException wenn ein ungültiger schlüssel übergeben wird
	 */
	@Test(expected=SecretException.class)
	public void test6() throws SecretException{
		sub.setSecretAlphabet(" aeiuobcdfghjkl aeiuobcdfghjkl");
	}
	
	private void trenner(String title){
		String out ="\n";
		int width = 10;
		
		for(int i=0;i<width;i++){ out += "- "; }
		out += title + " ";
		for(int i=0;i<width;i++){ out += "- "; }
		
		System.out.println(out);
	}
}
