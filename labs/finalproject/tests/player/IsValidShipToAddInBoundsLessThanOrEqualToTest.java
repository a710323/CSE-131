package finalproject.tests.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;
import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link HumanPlayer#isValidShipToAdd(Ship)}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IsValidShipToAddInBoundsLessThanOrEqualToTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test7TallShipOn8TallBoard() {
		int topLeftX = 0;
		int topLeftY = 0;
		int length = 7;
		boolean isHorizontal = false;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 1;
		int boardHeight = 8;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertTrue(player.isValidShipToAdd(ship));
	}

	@Test
	public void test7WideShipOn8WideBoard() {
		int topLeftX = 0;
		int topLeftY = 0;
		int length = 7;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 8;
		int boardHeight = 1;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertTrue(player.isValidShipToAdd(ship));
	}

	@Test
	public void test8TallShipOn8TallBoard() {
		int topLeftX = 0;
		int topLeftY = 0;
		int length = 8;
		boolean isHorizontal = false;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 1;
		int boardHeight = 8;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		// If you are passing the 7 long ship but not the 8 long ship, you likely have
		// a common off-by-one error. We get so used to counting from 0 and using <
		// it is easy to forget that 0+8 obviously fits on an 8 size board.
		assertTrue(player.isValidShipToAdd(ship));
	}

	@Test
	public void test8WideShipOn8WideBoard() {
		int topLeftX = 0;
		int topLeftY = 0;
		int length = 8;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 8;
		int boardHeight = 1;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		// If you are passing the 7 long ship but not the 8 long ship, you likely have
		// a common off-by-one error. We get so used to counting from 0 and using <
		// it is easy to forget that 0+8 obviously fits on an 8 size board.
		assertTrue(player.isValidShipToAdd(ship));
	}

	@Test
	public void test9TallShipOn8TallBoard() {
		int topLeftX = 0;
		int topLeftY = 0;
		int length = 9;
		boolean isHorizontal = false;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 1;
		int boardHeight = 8;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}

	@Test
	public void test9WideShipOn8WideBoard() {
		int topLeftX = 0;
		int topLeftY = 0;
		int length = 9;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 8;
		int boardHeight = 1;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}
}