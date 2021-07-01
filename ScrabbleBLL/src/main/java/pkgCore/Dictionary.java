package pkgCore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Dictionary {

	private ArrayList<Word> words = new ArrayList<Word>();

	public Dictionary() {
		LoadDictionary();
	}

	public ArrayList<Word> getWords() {
		return words;
	}

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

		Collections.sort(words, Word.CompWord);
	}

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
	 * @version Lab #2
	 * @since Lab #2
	 * @param first  - String with wildcards
	 * @param second - String without wildcards
	 * @return
	 */
	private boolean match(String first, String second) {
		try {

			if (second.isEmpty() || second.isBlank())
				return true;

			// If we reach at the end of both strings,
			// we are done
			if (first.length() == 0 && second.length() == 0)
				return true;

			// Make sure that the characters after '*'
			// are present in second string.
			// This function assumes that the first
			// string will not contain two consecutive '*'
			if (first.length() > 1 && first.charAt(0) == '*' && second.length() == 0)
				return false;

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
