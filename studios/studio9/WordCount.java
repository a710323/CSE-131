package studio9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2; 
	 * key="be", value=2; 
	 * key="or", value=1; 
	 * key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {
		Map<String, Integer> myMap = new HashMap<>();
		for(String word : words) {
			if (myMap.containsKey(word)) {
				int ans = myMap.get(word);
				ans++;
				myMap.replace(word, ans);
			} else {
				myMap.put(word, 1);
			}
		}
		return myMap;
	}
	public static void main(String[] args) {
		List<String> myList = new LinkedList<>();
		myList.add("to");
		myList.add("be");
		myList.add("or");
		myList.add("not");
		myList.add("to");
		myList.add("be");
		System.out.println(countWords(myList));
	}
}
