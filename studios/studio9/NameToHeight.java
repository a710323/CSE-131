package studio9;

import java.util.HashMap;
import java.util.Map;

import cse131.ArgsProcessor;
import cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		Map<String, Integer> myMap = new HashMap<>();
		myMap.put("Reshad", 67);
		myMap.put("Alex", 67);

		String a = "Reshad";
		String b = "Alex";
		String name = "";
		while (name!= null) {
			name = ap.nextString("Who are you looking for?");
			if(!myMap.containsKey(name)) {
				System.out.println("No such person");
			}
			else {
				int whatTheHeight = myMap.getOrDefault(name, 0);
				System.out.println(whatTheHeight);
			}
		}


	}
}
