package pkgCore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.google.common.collect.Collections2;

public class PERMUTExample {

	public static void main(String[] args)
	{
		ArrayList<String> combin = COMBINExample.Combin("ABCDE");
		
		ArrayList<Word> permut = GeneratePossibleWords(combin);
		int WordNumber = 0;
		System.out.println("********  Permut words ********");
		
		for (Word w: permut)
		{
			System.out.println(w.getWord());
		}
		
	}
	
	/**
	 * GeneratePossibleWords - Pass in an ArrayList of Strings and 
	 * for every String, call it's sister method.
	 * 
	 *  Return all the words found to a HashSet, because you want to remove duplicates
	 *  
	 *  After the HashSet is complete with non-duplicate entries, cast it back to an ArrayList
	 *  and sort the findings.  Return the sorted ArrayList to the user.
	 * @param arrLetters
	 * @return
	 */
	private static ArrayList<Word> GeneratePossibleWords(ArrayList<String> arrLetters) {
		HashSet<Word> words = new HashSet<Word>();

		for (String strPossibleWord : arrLetters) {
			words.addAll(GeneratePossibleWords(strPossibleWord));
		}
		ArrayList<Word> myWords = new ArrayList<Word>(words);
		Collections.sort(myWords, Word.CompWord);
		return myWords;
	}

	/**
	 * GeneratePossibleWords - A string is passed, and this method will figure out 
	 * every permutation of the string.  Add the permuted strings to a HashSet and pass it back
	 * @param strLetters
	 * @return
	 */
	private static HashSet<Word> GeneratePossibleWords(String strLetters) {
		HashSet<Word> hsPossibleWords = new HashSet<Word>();
		ArrayList<Character> arrLetters = new ArrayList<Character>();

		for (int i = 0; i < strLetters.length(); i++) {
			char c = strLetters.charAt(i);
			arrLetters.add(c);
		}
		Collection<List<Character>> ch = Collections2.orderedPermutations(arrLetters);
		for (final List<Character> p : ch) {
			{
				String strBuild = "";
				for (Character chrs : p) {
					strBuild = strBuild + chrs;
				}
				hsPossibleWords.add(new Word(strBuild));
			}
		}
		return hsPossibleWords;
	}
}
