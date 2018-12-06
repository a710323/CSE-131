package finalproject.tests.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
 *         {@link HumanPlayer#decideShipPlacement(int)}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DecideShipPlacementPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testASingleValidHorizontal() {
		int boardWidth = 7;
		int boardHeight = 10;
		int length = 5;
		int topLeftX = 2;
		int topLeftY = 3;
		boolean isHorizontal = true;
		ArgsProcessor ap = createArgsProcessorForXYHs(topLeftX, topLeftY, isHorizontal);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		Ship ship = player.decideShipPlacement(length);
		assertNotNull(ship);
		assertFalse(ship.isSunk());

		assertEquals("\nDo NOT add the ship in decideShipPlacement\n", player.numShipsStillAfloat(), 0);
		assertTrue(player.isValidShipToAdd(ship));
		assertTrue(player.addShip(ship));
		assertEquals(player.numShipsStillAfloat(), 1);

		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 1, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 2, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 3, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 4, topLeftY));
		assertTrue(ship.isSunk());
		assertEquals(player.numShipsStillAfloat(), 0);

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
	public void testBSingleValidVertical() {
		int boardWidth = 7;
		int boardHeight = 10;
		int length = 5;
		int topLeftX = 2;
		int topLeftY = 3;
		boolean isHorizontal = false;
		ArgsProcessor ap = createArgsProcessorForXYHs(topLeftX, topLeftY, isHorizontal);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		Ship ship = player.decideShipPlacement(length);
		assertNotNull(ship);
		assertFalse(ship.isSunk());

		assertEquals("\nDo NOT add the ship in decideShipPlacement\n", player.numShipsStillAfloat(), 0);
		assertTrue(player.isValidShipToAdd(ship));
		assertTrue(player.addShip(ship));
		assertEquals(player.numShipsStillAfloat(), 1);

		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX, topLeftY + 1));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX, topLeftY + 2));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX, topLeftY + 3));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX, topLeftY + 4));
		assertTrue(ship.isSunk());
		assertEquals(player.numShipsStillAfloat(), 0);

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
	public void testCMultipleIgnoreOutOfBounds() {
		int boardWidth = 7;
		int boardHeight = 10;

		int length = 5;

		int xIgnoreA = -1;
		int yIgnoreA = 4;
		boolean hIgnoreA = true;
		int xIgnoreB = 5;
		int yIgnoreB = 100;
		boolean hIgnoreB = false;
		int topLeftX = 2;
		int topLeftY = 3;
		boolean isHorizontal = true;
		ArgsProcessor ap = createArgsProcessorForXYHs(xIgnoreA, yIgnoreA, hIgnoreA, xIgnoreB, yIgnoreB, hIgnoreB,
				topLeftX, topLeftY, isHorizontal);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		Ship ship = player.decideShipPlacement(length);
		assertNotNull(ship);
		assertFalse(ship.isSunk());

		assertEquals("\nDo NOT add the ship in decideShipPlacement\n", player.numShipsStillAfloat(), 0);
		assertTrue(player.isValidShipToAdd(ship));
		assertTrue(player.addShip(ship));
		assertEquals(player.numShipsStillAfloat(), 1);

		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 1, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 2, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 3, topLeftY));
		assertFalse(ship.isSunk());
		assertTrue(player.respondToFire(topLeftX + 4, topLeftY));
		assertTrue(ship.isSunk());
		assertEquals(player.numShipsStillAfloat(), 0);

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
	public void testDIgnoreOverlap() {
		int boardWidth = 10;
		int boardHeight = 10;

		// ship A should be placed
		// ship I should be ignored
		// ship B should be placed
		// __0123456789
		// 0 ..........
		// 1 .....I....
		// 2 .....I....
		// 3 ..AAAA....
		// 4 .....I....
		// 5 .....BBBBB
		// 6 ..........
		// 7 ..........
		// 8 ..........
		// 9 ..........

		int lengthA = 4;
		int lengthB = 5;

		int topLeftXA = 2;
		int topLeftYA = 3;
		boolean isHorizontalA = true;

		int xIgnore = 5;
		int yIgnore = 1;
		boolean hIgnore = false;

		int topLeftXB = 4;
		int topLeftYB = 5;
		boolean isHorizontalB = true;

		ArgsProcessor ap = createArgsProcessorForXYHs(topLeftXA, topLeftYA, isHorizontalA, xIgnore, yIgnore, hIgnore,
				topLeftXB, topLeftYB, isHorizontalB);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		Ship shipA = player.decideShipPlacement(lengthA);
		assertNotNull(shipA);
		assertFalse(shipA.isSunk());

		assertEquals("\nDo NOT add the ship in decideShipPlacement\n", player.numShipsStillAfloat(), 0);
		assertTrue(player.isValidShipToAdd(shipA));
		assertTrue(player.addShip(shipA));
		assertEquals(player.numShipsStillAfloat(), 1);

		assertFalse(shipA.isSunk());
		assertTrue(player.respondToFire(topLeftXA, topLeftYA));
		assertFalse(shipA.isSunk());
		assertTrue(player.respondToFire(topLeftXA + 1, topLeftYA));
		assertFalse(shipA.isSunk());
		assertTrue(player.respondToFire(topLeftXA + 2, topLeftYA));
		assertFalse(shipA.isSunk());
		assertTrue(player.respondToFire(topLeftXA + 3, topLeftYA));
		assertTrue(shipA.isSunk());
		assertEquals(player.numShipsStillAfloat(), 0);

		Ship shipB = player.decideShipPlacement(lengthB);
		assertNotNull(shipB);
		assertFalse(shipB.isSunk());

		assertEquals("\nDo NOT add the ship in decideShipPlacement\n", player.numShipsStillAfloat(), 0);
		assertTrue(player.isValidShipToAdd(shipB));
		assertTrue(player.addShip(shipB));
		assertEquals(player.numShipsStillAfloat(), 1);

		assertFalse(shipB.isSunk());
		assertTrue(player.respondToFire(topLeftXB, topLeftYB));
		assertFalse(shipB.isSunk());
		assertTrue(player.respondToFire(topLeftXB + 1, topLeftYB));
		assertFalse(shipB.isSunk());
		assertTrue(player.respondToFire(topLeftXB + 2, topLeftYB));
		assertFalse(shipB.isSunk());
		assertTrue(player.respondToFire(topLeftXB + 3, topLeftYB));
		assertFalse(shipB.isSunk());
		assertTrue(player.respondToFire(topLeftXB + 4, topLeftYB));
		assertTrue(shipB.isSunk());
		assertEquals(player.numShipsStillAfloat(), 0);

		int count = 0;
		for (int y = 0; y < boardHeight; ++y) {
			for (int x = 0; x < boardWidth; ++x) {
				if (player.respondToFire(x, y)) {
					++count;
				}
			}
		}
		assertEquals(lengthA + lengthB, count);
	}

	private static ArgsProcessor createArgsProcessorForXYHs(Object... values) {
		String[] args = new String[values.length];
		for (int i = 0; i < values.length; i += 3) {
			args[i] = Integer.toString((int) values[i]);
			args[i + 1] = Integer.toString((int) values[i + 1]);
			args[i + 2] = Boolean.toString((boolean) values[i + 2]);
		}
		return new ArgsProcessor(args);
	}
}
