package pkgCore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import pkgHelper.Util;

public class DictionaryLab4Test {

	@Test
	public void TestCombin1() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "JAVA";
		HashSet<Word> words = d.findWords(strLetters);
		
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (Word w: words) {
		  sb.append(prefix);
		  prefix = ", ";
		  sb.append(w.getWord());
		}
		System.out.println(sb.toString());
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}

	@Test
	public void TestCombin2() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "JAV?";
		HashSet<Word> words = d.findWords(strLetters);
		
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (Word w: words) {
		  sb.append(prefix);
		  prefix = ", ";
		  sb.append(w.getWord());
		}
		System.out.println(sb.toString());		
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}
	
	@Test
	public void TestCombin3() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "JA??";
		HashSet<Word> words = d.findWords(strLetters);
		
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (Word w: words) {
		  sb.append(prefix);
		  prefix = ", ";
		  sb.append(w.getWord());
		}
		System.out.println(sb.toString());		
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}
	
	@Test
	public void TestCombin4() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "JA?A";
		HashSet<Word> words = d.findWords(strLetters);
		
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (Word w: words) {
		  sb.append(prefix);
		  prefix = ", ";
		  sb.append(w.getWord());
		}
		System.out.println(sb.toString());		
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	@Test
	public void TestCombin5() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "BO?H";
		HashSet<Word> words = d.findWords(strLetters);
		
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (Word w: words) {
		  sb.append(prefix);
		  prefix = ", ";
		  sb.append(w.getWord());
		}
		System.out.println(sb.toString());		
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}		
	@Test
	public void TestCombin6() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "B??E";
		HashSet<Word> words = d.findWords(strLetters);
		
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (Word w: words) {
		  sb.append(prefix);
		  prefix = ", ";
		  sb.append(w.getWord());
		}
		System.out.println(sb.toString());		
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}	
	
	@Test
	public void TestCombin7() {
		Util.PrintStart(new Throwable().getStackTrace()[0].getMethodName());
		Dictionary d = new Dictionary();
		String strLetters = "JAR*";
		HashSet<Word> words = d.findWords(strLetters);
		
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (Word w: words) {
		  sb.append(prefix);
		  prefix = ", ";
		  sb.append(w.getWord());
		}
		System.out.println(sb.toString());		
		Util.PrintEnd(new Throwable().getStackTrace()[0].getMethodName());
	}		
}
