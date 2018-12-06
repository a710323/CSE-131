package finalproject.tests.player;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;
import finalproject.Player;
import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

public class AllSunkTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testOneShipSunkManualHoriz() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", 0, p.numShipsStillAfloat());
		assertTrue(p.addShip(new Ship(1, 1, 1, true)));
		assertEquals("We have not fired yet, they can't be all sunk", 1, p.numShipsStillAfloat());
		assertTrue(p.respondToFire(1, 1));
		assertEquals("We sunk the ship with a single blow, they must all be sunk", 0, p.numShipsStillAfloat());
	}

	@Test
	public void testOneShipSunkManualVert() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", 0, p.numShipsStillAfloat());
		assertTrue(p.addShip(new Ship(1, 1, 1, false)));
		assertEquals("We have not fired yet, they can't be all sunk", 1, p.numShipsStillAfloat());
		assertTrue(p.respondToFire(1, 1));
		assertEquals("We sunk the ship with a single blow, they must all be sunk", 0, p.numShipsStillAfloat());
	}

	@Test
	public void testOneShipSunkRandom() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", 0, p.numShipsStillAfloat());
		int length = 1;
		assertTrue(p.addRandomShip(length));
		assertEquals("We have not fired yet, they can't be all sunk", 1, p.numShipsStillAfloat());
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (p.respondToFire(i, j)) {
					++count;
				}
			}
		}
		assertEquals("We have fired everywhere, the ship must be sunk", 0, p.numShipsStillAfloat());
		assertEquals(length, count);
	}

	@Test
	public void testTenShipsSunkManualSimple() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", 0, p.numShipsStillAfloat());
		for (int i = 0; i < 10; ++i) {
			assertTrue(p.addShip(new Ship(i, i, 1, Math.random() < 0.5)));
			assertEquals("We have not fired yet, they can't be all sunk", i + 1, p.numShipsStillAfloat());
		}

		for (int i = 0; i < 9; i++) {
			assertTrue(p.respondToFire(i, i));
		}
		assertEquals("We have sunk all but one ship, they can't all be sunk", 1, p.numShipsStillAfloat());
		assertTrue(p.respondToFire(9, 9));
		assertEquals("We have hit every ship, they must all be sunk", 0, p.numShipsStillAfloat());
	}

	@Test
	public void testTenShipsSunkManualComplex() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", 0, p.numShipsStillAfloat());

		int[] xTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 1, 4 };
		int[] yTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 5, 1 };
		boolean[] oTest = new boolean[] { true, true, false, true, false, true, true, false, false, true };
		for (int i = 0; i < 10; i++) {
			assertTrue(p.addShip(new Ship(xTest[i], yTest[i], (i % 5) + 1, oTest[i])));
			assertEquals("We have not fired yet, they can't be all sunk", i + 1, p.numShipsStillAfloat());
		}

		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < (i % 5) + 1; ++j) {
				assertTrue(p.respondToFire(xTest[i] + (oTest[i] ? j : 0), yTest[i] + (oTest[i] ? 0 : j)));
			}
			if (i != 9) {
				assertEquals("We have only sunk " + (i + 1) + " ships", (9 - i), p.numShipsStillAfloat());
			}
		}
		assertEquals("We sunk all 10 ships", 0, p.numShipsStillAfloat());
	}

	@Test
	public void testTenShipsSunkRandom() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", 0, p.numShipsStillAfloat());
		int sumLength = 0;
		for (int i = 0; i < 10; i++) {
			int length = (i % 5) + 1;
			sumLength += length;
			assertTrue(p.addRandomShip(length));
			assertEquals("We have not fired yet, they can't be all sunk", i + 1, p.numShipsStillAfloat());
		}

		assertEquals(p.numShipsStillAfloat(), 10);
		int hitCount = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (p.respondToFire(i, j)) {
					++hitCount;
				}
			}
		}
		assertEquals("We have fired everywhere, all ships must be sunk", 0, p.numShipsStillAfloat());
		assertEquals(sumLength, hitCount);
	}
}
