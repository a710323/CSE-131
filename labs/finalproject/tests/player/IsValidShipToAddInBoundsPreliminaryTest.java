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
public class IsValidShipToAddInBoundsPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testASingleValid() {
		int topLeftX = 2;
		int topLeftY = 3;
		int length = 5;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 7;
		int boardHeight = 10;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertTrue(player.isValidShipToAdd(ship));
	}

	@Test
	public void testBNegativeX() {
		int topLeftX = -1;
		int topLeftY = 3;
		int length = 5;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 7;
		int boardHeight = 10;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}

	@Test
	public void testCNegativeY() {
		int topLeftX = 2;
		int topLeftY = -1;
		int length = 5;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 7;
		int boardHeight = 10;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}

	@Test
	public void testDInvalidX() {
		int topLeftX = 100;
		int topLeftY = 3;
		int length = 5;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 7;
		int boardHeight = 10;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}

	@Test
	public void testEEdgeX() {
		int boardWidth = 7;
		int boardHeight = 10;
		int length = 5;
		int topLeftX = boardWidth - length;
		int topLeftY = 3;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertTrue(player.isValidShipToAdd(ship));
	}

	@Test
	public void testFJustPastEdgeX() {
		int boardWidth = 7;
		int boardHeight = 10;
		int length = 5;
		int topLeftX = (boardWidth - length) + 1;
		int topLeftY = 3;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}

	@Test
	public void testDInvalidY() {
		int topLeftX = 2;
		int topLeftY = 100;
		int length = 5;
		boolean isHorizontal = false;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 7;
		int boardHeight = 10;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}

	@Test
	public void testEEdgeY() {
		int boardWidth = 7;
		int boardHeight = 10;
		int length = 5;
		int topLeftX = 2;
		int topLeftY = boardHeight - length;
		boolean isHorizontal = false;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertTrue(player.isValidShipToAdd(ship));
	}

	@Test
	public void testFJustPastEdgeY() {
		int boardWidth = 7;
		int boardHeight = 10;
		int length = 5;
		int topLeftX = 2;
		int topLeftY = (boardHeight - length) + 1;
		boolean isHorizontal = false;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);

		assertFalse(ship.isSunk());

		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.isValidShipToAdd(ship));
	}
}
