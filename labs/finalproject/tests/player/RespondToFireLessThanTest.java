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
public class RespondToFireLessThanTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testEmptyBoardFireAtHeight() {
		int boardWidth = 1;
		int boardHeight = 8;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.respondToFire(0, boardHeight));
	}

	@Test
	public void testEmptyBoardFireAtWidth() {
		int boardWidth = 8;
		int boardHeight = 1;
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);
		assertFalse(player.respondToFire(boardWidth, 0));
	}

	@Test
	public void testFullBoardFireAtHeight() {
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
		assertTrue(player.isValidShipToAdd(ship));
		assertTrue(player.addShip(ship));
		assertFalse(player.respondToFire(0, boardHeight));

		for (int i = 0; i < length; ++i) {
			assertFalse("i=" + i, ship.isSunk());
			assertEquals("i=" + i, 1, player.numShipsStillAfloat());
			assertTrue("i=" + i, player.respondToFire(0, i));
		}
		assertTrue(ship.isSunk());
		assertEquals(0, player.numShipsStillAfloat());
	}

	@Test
	public void testFullBoardFireAtWidth() {
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
		assertTrue(player.isValidShipToAdd(ship));
		assertTrue(player.addShip(ship));
		assertFalse(player.respondToFire(boardWidth, 0));

		for (int i = 0; i < length; ++i) {
			assertFalse("i=" + i, ship.isSunk());
			assertEquals("i=" + i, 1, player.numShipsStillAfloat());
			assertTrue("i=" + i, player.respondToFire(i, 0));
		}
		assertTrue(ship.isSunk());
		assertEquals(0, player.numShipsStillAfloat());
	}
}