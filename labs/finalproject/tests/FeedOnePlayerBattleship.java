package finalproject.tests;

import java.util.LinkedList;
import java.util.List;

import finalproject.OnePlayerBattleship;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class FeedOnePlayerBattleship {
	public static void main(String[] args) {
		String name = "Ron";
		int width = 10;
		int height = 10;
		int numShips = 5;
		boolean randomShips = true;
		List<String> list = new LinkedList<>();
		list.add(name);
		list.add(Integer.toString(width));
		list.add(Integer.toString(height));
		list.add(Integer.toString(numShips));
		list.add(Boolean.toString(randomShips));
		for (int r = 0; r < height; ++r) {
			for (int c = 0; c < width; ++c) {
				list.add(Integer.toString(r));
				list.add(Integer.toString(c));
			}
		}
		String[] argsForProcessing = list.toArray(new String[list.size()]);
		OnePlayerBattleship.main(argsForProcessing);
	}
}
