package pkgCore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.math3.util.CombinatoricsUtils;

import com.google.common.collect.Collections2;

public class Dictionary {

	private ArrayList<Word> words = new ArrayList<Word>();
	private ArrayList<Character> alphaBet = new ArrayList<Character>();

	public Dictionary() {
		LoadDictionary();
	}

	public ArrayList<Word> getWords() {
		return words;
	}

	private int iCntLoop = 0;

	public int getiCntLoop() {
		return iCntLoop;
	}

	/**
	 * LoadDictionary - Load the dictionary, sort it after it's loaded
	 * 					Also, load the alphabet
	 * @author BRG
	 * @version Lab #1
	 * @since Lab #1
	 */

	private void LoadDictionary() {
		InputStream is = getClass().getClassLoader().getResourceAsStream("util/words.txt");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			while (reader.ready()) {
				String line = reader.readLine();
				if (!line.trim().isBlank() && !line.trim().isEmpty())
					words.add(new Word(line.trim()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 65; i < 91; i++) {
			alphaBet.add((char) i);
		}
		Collections.sort(alphaBet);
		Collections.sort(words, Word.CompWord);
	}


	/**
	 * findWords - This method will find all the possible words for a given String
	 * 
	 * DOG will produce DO, DOG, GO, GOD
	 * 
	 * @author BRG
	 * @version Lab #4
	 * @since Lab #4
	 * @param strWord
	 * @return
	 */
	
	//TODO: For a given word (set of letters), what are possible words that can be made
	//		include the ?,  include the *
	//		include only valid words from the dictionary
	
	public HashSet<Word> findWords(String strWord) {
		HashSet<Word> FoundWords = new HashSet<Word>();
		int begIndx = FindBeginningIndex(this.getWords(),strWord);
		int endIndx = FindEndingIndex(this.getWords(),strWord);
		for (int i = begIndx; i<endIndx; i++) {
			if (match(strWord, this.getWords().toString())) {
				FoundWords.add(this.words.get(i));
			}
		}
		return FoundWords;
	}
	
	/**
	 * FindBeginningIndex - The intention of this method is to find the best place
	 * in the dictionary to start searching. No sense in looking through the entire
	 * dictionary. If you pass in a PartialWord, it will return the starting point
	 * of the Dictionary, backing up a couple of positions for safety.
	 * 
	 * If ? or * is in the first position, you have to start with zero.
	 * 
	 * @author BRG
	 * @version Lab #4
	 * @since Lab #4
	 * @param arrSearch
	 * @param strPartialWord
	 * @return
	 */
	
	//TODO: Find the beginning index..  Where in arrSearch should I begin for strPartialWord?
	
	private int FindBeginningIndex(ArrayList<Word> arrSearch, String strPartialWord) {
		return 0;
	
	
	}
	/**
	 * FindEndingIndex - The intention of this method is to find the best place in
	 * the dictionary to end searching.
	 * 
	 * The method will find the last character in the string and advance it one
	 * character, and then find the position in the dictionary If you pass in ABC,
	 * it will find the position of ABD. If you pass in AB?, it will find the
	 * position of ABZ. If you pass in AB*, it will find the position of ABZ.
	 * 
	 * It will add one index entry, just for safety and return the index to the
	 * caller.
	 * 
	 * @author BRG
	 * @version Lab #4
	 * @since Lab #4
	 * @param arrSearch
	 * @param strPartialWord
	 * @return
	 */
	
	//TODO: Find the beginning index..  Where in arrSearch should I end for strPartialWord?

	private int FindEndingIndex(ArrayList<Word> arrSearch, String strPartialWord) {

		if (strPartialWord.substring(strPartialWord.length()-1)=="*"||strPartialWord.substring(strPartialWord.length()-1)=="?"||strPartialWord.substring(strPartialWord.length()-1)=="z") {
			String strPartialWordR= strPartialWord.substring(0,strPartialWord.length()-1);
			return FindEndingIndex(arrSearch, strPartialWordR);
		}else if (strPartialWord.indexOf("?")!=-1){
			String strPartialWordR= strPartialWord.substring(0,strPartialWord.indexOf("?"));
			return FindEndingIndex(arrSearch, strPartialWordR);
		}else if (strPartialWord.indexOf("?")==-1 && strPartialWord.length()!=0) {
			char [] charPartialWord= strPartialWord.toCharArray();
			charPartialWord[charPartialWord.length-1]=charPartialWord[charPartialWord.length-1]++;
			String strProceedPartialWord= charPartialWord.toString();
			Word proceedPartialWord = new Word(strProceedPartialWord);
			return Math.abs(Collections.binarySearch(this.words, proceedPartialWord, Word.CompWord));	
		}else{
			return arrSearch.size()-1;
		}
			
	}
 

	/**
	 * GenerateWords - Public facing method. If you call this with a string, it will
	 * return the permutations of words that could be generated. There's no
	 * easy/direct way to do it- first you have to combin each string, then call
	 * permut to find the permutations for each combination.
	 * 
	 * @param strLetters
	 * @return
	 */
	
	public ArrayList<Word> GenerateWords(String strLetters) {
		ArrayList<String> combinWords = new ArrayList<String>();
		for (int b = 1; b < strLetters.length() + 1; b++) {
			Iterator<int[]> iterCommon = CombinatoricsUtils.combinationsIterator(strLetters.length(), b);
			while (iterCommon.hasNext()) {
				final int[] cmbPlayer = iterCommon.next();
				String strBuildWord = "";
				for (int i : cmbPlayer) {
					strBuildWord += strLetters.charAt(i);
				}
				combinWords.add(strBuildWord);
			}
		}

		HashSet<Word> hsUniqueWords = new HashSet<Word>(GeneratePossibleWords(combinWords));
		ArrayList<Word> WordsPermut = new ArrayList<Word>(hsUniqueWords);
		Collections.sort(WordsPermut, Word.CompWord);
		return WordsPermut;
	}

	/**
	 * GeneratePossibleWords - If you pass in an Array of Strings, it will call
	 * GeneratePossibleWords(String) to determine the permutations of each string.
	 * 
	 * @author BRG
	 * 
	 * @version Lab #3
	 * @since Lab #3
	 * @param arrLetters
	 * @return - unique list of Words.
	 */
	private ArrayList<Word> GeneratePossibleWords(ArrayList<String> arrLetters) {
		HashSet<Word> words = new HashSet<Word>();

		for (String strPossibleWord : arrLetters) {
			words.addAll(this.GeneratePossibleWords(strPossibleWord));
		}
		ArrayList<Word> myWords = new ArrayList<Word>(words);
		Collections.sort(myWords, Word.CompWord);
		return myWords;
	}

	/**
	 * GeneratePossibleWords - this method will take an incoming String and return a
	 * HashSet of all possible words.
	 * 
	 * @author BRG
	 * 
	 * @version Lab #3
	 * @since Lab #3
	 * @param strLetters
	 * @return
	 */
	private HashSet<Word> GeneratePossibleWords(String strLetters) {
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

	/**
	 * 
	 * findWord - Check to see if a given String is a word in the dictionary
	 * 
	 * @author BRG
	 * 
	 * @version Lab #1
	 * @since Lab #1
	 * @param strWord
	 * @return - Return the Word from the dictionary. If no word, return null.
	 */
	public Word findWord(String strWord) {

		Word w = new Word(strWord);
		int idx = Collections.binarySearch(this.words, w, Word.CompWord);

		if (idx < 0)
			return null;
		else
			return words.get(idx);
	}


	/**
	 * match - Recursive method to find a match between a string and wildcard
	 * characters ? and *
	 * 
	 * @author BRG
	 * https://www.geeksforgeeks.org/wildcard-character-matching/
	 * @version Lab #2
	 * @since Lab #2
	 * @param first  - String with wildcards
	 * @param second - String without wildcards
	 * @return
	 */
	private boolean match(String first, String second) {
		try {

			if (second.isEmpty() || second.isBlank())
				if (first.isEmpty() || first.isBlank())
					return true;

			if (second.isEmpty() || second.isBlank())
				if (!first.isEmpty() || !first.isBlank())
					return false;

			// If we reach at the end of both strings,
			// we are done
			if (first.length() == 0 && second.length() == 0)
				return true;

			// Make sure that the characters after '*'
			// are present in second string.
			// This function assumes that the first
			// string will not contain two consecutive '*'
			if (first.length() == 1 && first.charAt(0) == '*')
				if (second.length() == 0)
					return false;
				else
					return true;

			// If the first string contains '?',
			// or current characters of both strings match
			if ((first.length() > 1 && first.charAt(0) == '?')
					|| (first.length() != 0 && second.length() != 0 && first.charAt(0) == second.charAt(0)))
				return match(first.substring(1), second.substring(1));

			// If there is *, then there are two possibilities
			// a) We consider current character of second string
			// b) We ignore current character of second string.
			if (first.length() > 0 && first.charAt(0) == '*')
				return match(first.substring(1), second) || match(first, second.substring(1));

			if (first.length() == 1 && first.charAt(0) == '?' && second.length() == 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
