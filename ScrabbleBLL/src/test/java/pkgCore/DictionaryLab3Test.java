package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import pkgHelper.Util;

public class DictionaryLab3Test {

	@Test
	public void TestCombin1() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "ABCDE";
		ArrayList<Word> words = d.GenerateWords(strLetters);
		assertEquals(325, d.GenerateWords(strLetters).size());
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void TestCombin2() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "ABB";
		ArrayList<Word> words = d.GenerateWords(strLetters);
		assertEquals(8, d.GenerateWords(strLetters).size());
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void TestCombin3() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "ABC";
		ArrayList<Word> words = d.GenerateWords(strLetters);
		assertEquals(15, d.GenerateWords(strLetters).size());
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}
	

}
