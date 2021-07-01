package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pkgHelper.Util;

public class DictionaryLab1Test {

	@Test
	public void LoadDictionaryTest1() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		int iDictionarySize = 79340;

		Dictionary d = new Dictionary();
		assertEquals(iDictionarySize, d.getWords().size());
		for (Word w : d.getWords()) {
			for (Character c : w.getWord().toCharArray()) {
				if (!Character.isUpperCase(c)) {
					fail("Word: " + w.getWord() + " is not uppercase");
				}
			}
		}
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void LoadDictionaryTest2() {
		// Test to see if all characters are uppercase
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		Dictionary d = new Dictionary();
		for (Word w : d.getWords()) {
			for (Character c : w.getWord().toCharArray()) {
				if (!Character.isUpperCase(c)) {
					fail("Word: " + w.getWord() + " is not uppercase");
				}
			}
		}

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void FindWord1() {
		// Test to see if all characters are uppercase
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		Dictionary d = new Dictionary();
		Word w = d.findWord("TREE");
		assertNotNull(w);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void FindWord2() {
		// Test to see if all characters are uppercase
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		Dictionary d = new Dictionary();
		Word w = d.findWord("tree");
		assertNotNull(w);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void FindWord3() {
		// Test to see if all characters are uppercase
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());

		Dictionary d = new Dictionary();
		Word w = d.findWord("TREEX");
		assertNull(w);

		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}
	
	@Test
	public void TestEquals1()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Word w1 = new Word("Yes");
		Word w2 = new Word("Yes");
		assertTrue(w1.equals(w2));
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}
	@Test
	public void TestEquals2()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Word w1 = new Word("Yes");
		Word w2 = new Word("No");
		assertFalse(w1.equals(w2));
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());	
	}	
	@Test
	public void TestCompare1()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Word w1 = new Word("ABC");
		Word w2 = new Word("A");
		assertTrue(w1.compareTo(w2) > 0);
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());	
	}
	
	@Test
	public void TestCompare2()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Word w1 = new Word("ABC");
		Word w2 = new Word("B");
		assertTrue(w1.compareTo(w2) < 0);
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}
	
	@Test
	public void TestCompare3()
	{
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Word w1 = new Word("ABC");
		Word w2 = new Word("ABC");
		assertTrue(w1.compareTo(w2) == 0);
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());	
	}	
	
}
