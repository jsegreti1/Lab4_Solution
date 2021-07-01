package pkgCore;

import java.util.ArrayList;

public class Dictionary {

	private ArrayList<Word> words = new ArrayList<Word>();

	public Dictionary() {
		LoadDictionary();
	}

	public ArrayList<Word> getWords() {
		return words;
	}

	private void LoadDictionary() {
		// TODO: Load the 'words' ArrayList from words.txt
	}

	public Word findWord(String strWord) {
		// TODO: Find a 'word' in the dictionary. If found, return it, if not found,
		// return null.
		return null;
	}

}
