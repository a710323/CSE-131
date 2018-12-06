package finalproject.tests.player;

import static org.junit.Assert.assertEquals;
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
 *         {@link HumanPlayer#respondToFire(int, int)}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RespondToFirePreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testASingleOneLengthShip() {
		int topLeftX = 2;
		int topLeftY = 3;
		int length = 1;
		boolean isHorizontal = true;

		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isSunk());

		int boardWidth = 7;
		int boardHeight = 10;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		assertEquals(0, player.numShipsStillAfloat());
		assertTrue(player.addShip(ship));
		assertEquals(1, player.numShipsStillAfloat());
		assertTrue(player.respondToFire(topLeftX, topLeftY));
		assertTrue(ship.isSunk());
		assertEquals(0, player.numShipsStillAfloat());

		int count = 0;
		for (int y = 0; y < boardHeight; ++y) {
			for (int x = 0; x < boardWidth; ++x) {
				if (player.respondToFire(x, y)) {
					++count;
				}
			}
		}
		assertEquals(length, count);
	}

	@Test
	public void testBSingleFiveLengthShip() {
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

		assertEquals(0, player.numShipsStillAfloat());
		assertTrue(player.addShip(ship));
		assertEquals(1, player.numShipsStillAfloat());
		assertTrue(player.respondToFire(topLeftX, topLeftY));
		assertTrue(player.respondToFire(topLeftX + 1, topLeftY));
		assertTrue(player.respondToFire(topLeftX + 2, topLeftY));
		assertTrue(player.respondToFire(topLeftX + 3, topLeftY));
		assertTrue(player.respondToFire(topLeftX + 4, topLeftY));
		assertTrue(ship.isSunk());
		assertEquals(0, player.numShipsStillAfloat());

		int count = 0;
		for (int y = 0; y < boardHeight; ++y) {
			for (int x = 0; x < boardWidth; ++x) {
				if (player.respondToFire(x, y)) {
					++count;
				}
			}
		}
		assertEquals(length, count);
	}

	@Test
	public void testCMultipleOneLengthShips() {
		int topLeftXA = 2;
		int topLeftYA = 3;
		int lengthA = 1;
		boolean isHorizontalA = true;
		Ship shipA = new Ship(topLeftXA, topLeftYA, lengthA, isHorizontalA);
		assertFalse(shipA.isSunk());

		int topLeftXB = 4;
		int topLeftYB = 5;
		int lengthB = 1;
		boolean isHorizontalB = true;
		Ship shipB = new Ship(topLeftXB, topLeftYB, lengthB, isHorizontalB);
		assertFalse(shipB.isSunk());

		int boardWidth = 7;
		int boardHeight = 10;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		assertEquals(0, player.numShipsStillAfloat());
		assertTrue(player.addShip(shipA));
		assertEquals(1, player.numShipsStillAfloat());
		assertTrue(player.addShip(shipB));
		assertEquals(2, player.numShipsStillAfloat());
		
		assertTrue(player.respondToFire(topLeftXA, topLeftYA));
		assertTrue(shipA.isSunk());
		assertFalse(shipB.isSunk());
		assertEquals(1, player.numShipsStillAfloat());

		assertTrue(player.respondToFire(topLeftXB, topLeftYB));
		assertTrue(shipA.isSunk());
		assertTrue(shipB.isSunk());
		assertEquals(0, player.numShipsStillAfloat());

		int count = 0;
		for (int y = 0; y < boardHeight; ++y) {
			for (int x = 0; x < boardWidth; ++x) {
				if (player.respondToFire(x, y)) {
					++count;
				}
			}
		}
		assertEquals(lengthA+lengthB, count);
	}
}
