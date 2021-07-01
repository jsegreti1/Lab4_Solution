package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DictionaryLab1Test {

	@Test
	public void LoadDictionaryTest1() {
		System.out.println("---LoadDictionaryTest1 Start---");

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
		System.out.println("---LoadDictionaryTest1 Complete---");
	}

	@Test
	public void LoadDictionaryTest2() {
		// Test to see if all characters are uppercase
		System.out.println("---LoadDictionaryTest1 Start---");

		Dictionary d = new Dictionary();
		for (Word w : d.getWords()) {
			for (Character c : w.getWord().toCharArray()) {
				if (!Character.isUpperCase(c)) {
					fail("Word: " + w.getWord() + " is not uppercase");
				}
			}
		}

		System.out.println("---LoadDictionaryTest2 Complete---");
	}

	@Test
	public void FindWord1() {
		// Test to see if all characters are uppercase
		System.out.println("---FindWord1 Start---");

		Dictionary d = new Dictionary();
		Word w = d.findWord("TREE");
		assertNotNull(w);

		System.out.println("---FindWord1 Complete---");
	}

	@Test
	public void FindWord2() {
		// Test to see if all characters are uppercase
		System.out.println("---FindWord2 Start---");

		Dictionary d = new Dictionary();
		Word w = d.findWord("tree");
		assertNotNull(w);

		System.out.println("---FindWord2 Complete---");
	}

	@Test
	public void FindWord3() {
		// Test to see if all characters are uppercase
		System.out.println("---FindWord3 Start---");

		Dictionary d = new Dictionary();
		Word w = d.findWord("TREEX");
		assertNull(w);

		System.out.println("---FindWord3 Complete---");
	}

}
