package finalproject.tests.player;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link HumanPlayer#HumanPlayer(String, int, int, ArgsProcessor)}
 *         {@link HumanPlayer#getName()}
 */
public class GetNameTest {
	@Test
	public void test() {
		String name = "Ron";
		int width = 1;
		int height = 1;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer(name, height, width, ap);
		assertEquals(name, player.getName());
	}
}
