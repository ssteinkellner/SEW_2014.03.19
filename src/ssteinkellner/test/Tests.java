package ssteinkellner.test;

import junit.framework.Assert;

import org.junit.Test;

import ssteinkellner.cipher.SubstitutionCipher;

public class Tests {
	SubstitutionCipher sub;

	/**
	 * testet, ob mit einem einzigen schlüssel nach ver- und entschlüsseln wieder das selbe raus kommt
	 */
	@Test
	public void test1() {
		String text = "hallo";
		try{
			sub = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
			String ver = sub.encrypt(text);
			String ent = sub.decrypt(ver);
			System.out.println(text + " > " + ver + " > " + ent);
			Assert.assertEquals(ent,text);
		}catch(Exception ex){}
	}

	/**
	 * testet, ob mit 2 verschiedenen schlüsseln 2 verschiedene ergebnisse heraus kommen
	 */
	@Test
	public void test2(){
		String text = "hallo";
		try{
			sub = new SubstitutionCipher("qwertzuiopüasdfghjklöäyxcvbnmß");
			String ver1 = sub.encrypt(text);
			sub.setSecretAlphabet("mnbvcxyäölkjhgfdsaüpoiuztrewqß");
			String ver2 = sub.encrypt(text);
			System.out.println(text + " > " + ver1 + " / " + ver2);
			Assert.assertNotSame(ver1, ver2);
		}catch(Exception ex){}
	}
}
