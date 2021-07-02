package pkgCore;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class COMBINExample {

	public static void main(String[] args) {
		Combin("ABC");
	}

	/**
	 * Combin - with a given string, this method will figure out all the
	 * combinations possible. If input string is 'ABC', this will produce 
	 * A 
	 * B 
	 * C 
	 * AB
	 * AC 
	 * BC 
	 * ABC
	 * 
	 * @param strLetters
	 * @return
	 */
	public static ArrayList<String> Combin(String strLetters) {
		// This method will take a string... "ABCDE"... and give all the combinations
		System.out.println("********  Combin string ********");
		ArrayList<String> combinWords = new ArrayList<String>();
		for (int b = 1; b < strLetters.length() + 1; b++) {
			Iterator<int[]> iterWord = CombinatoricsUtils.combinationsIterator(strLetters.length(), b);
			while (iterWord.hasNext()) {
				final int[] cmbLetters = iterWord.next();
				String strBuildWord = "";
				for (int i : cmbLetters) {
					strBuildWord += strLetters.charAt(i);
				}
				combinWords.add(strBuildWord);
			}
		}
		for (String s : combinWords) {
			System.out.println(s);
		}
		return combinWords;
	}
}
