package finalproject.tests.player;

import static org.junit.Assert.*;

import org.junit.Test;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;
import finalproject.Player;
import finalproject.Ship;

public class AllSunkTester {

	@Test
	public void testOneShipSunkManualHoriz() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", p.numShipsStillAfloat(), 0);
		p.addShip(new Ship(1, 1, 1, true));
		assertEquals("We have not fired yet, they can't be all sunk", p.numShipsStillAfloat(), 1);
		p.respondToFire(1, 1);
		assertEquals("We sunk the ship with a single blow, they must all be sunk", p.numShipsStillAfloat(), 0);
	}

	@Test
	public void testOneShipSunkManualVert() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", p.numShipsStillAfloat(), 0);
		p.addShip(new Ship(1, 1, 1, false));
		assertEquals("We have not fired yet, they can't be all sunk", p.numShipsStillAfloat(), 1);
		p.respondToFire(1, 1);
		assertEquals("We sunk the ship with a single blow, they must all be sunk", p.numShipsStillAfloat(), 0);
	}

	@Test
	public void testOneShipSunkRandom() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", p.numShipsStillAfloat(), 0);
		p.addRandomShip(1);
		assertEquals("We have not fired yet, they can't be all sunk", p.numShipsStillAfloat(), 1);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				p.respondToFire(i, j);
			}
		}
		assertEquals("We have fired everywhere, the ship must be sunk", p.numShipsStillAfloat(), 0);
	}

	@Test
	public void testTenShipsSunkManualSimple() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", p.numShipsStillAfloat(), 0);
		for (int i = 0; i < 10; ++i) {
			p.addShip(new Ship(i, i, 1, Math.random() < 0.5));
			assertEquals("We have not fired yet, they can't be all sunk", p.numShipsStillAfloat(), i + 1);
		}

		for (int i = 0; i < 9; i++) {
			p.respondToFire(i, i);
		}
		assertEquals("We have sunk all but one ship, they can't all be sunk", p.numShipsStillAfloat(), 1);
		p.respondToFire(9, 9);
		assertEquals("We have hit every ship, they must all be sunk", p.numShipsStillAfloat(), 0);
	}

	@Test
	public void testTenShipsSunkManualComplex() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", p.numShipsStillAfloat(), 0);

		int[] xTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 1, 4 };
		int[] yTest = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 5, 1 };
		boolean[] oTest = new boolean[] { true, true, false, true, false, true, true, false, false, true };
		for (int i = 0; i < 10; i++) {
			p.addShip(new Ship(xTest[i], yTest[i], (i % 5) + 1, oTest[i]));
			assertEquals("We have not fired yet, they can't be all sunk", p.numShipsStillAfloat(), i + 1);
		}

		for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < (i % 5) + 1; ++j) {
				p.respondToFire(xTest[i] + (oTest[i] ? j : 0), yTest[i] + (oTest[i] ? 0 : j));
			}
			if (i != 9) {
				assertEquals("We have only sunk " + (i + 1) + " ships", p.numShipsStillAfloat(), (9 - i));
			}
		}
		assertEquals("We sunk all 10 ships", p.numShipsStillAfloat(), 0);
	}

	@Test
	public void testTenShipsSunkRandom() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		Player p = new HumanPlayer("Mariah", 10, 10, ap);
		assertEquals("There are no ships, therefore they are all sunk", p.numShipsStillAfloat(), 0);
		for (int i = 0; i < 10; i++) {
			p.addRandomShip((i % 5) + 1);
			assertEquals("We have not fired yet, they can't be all sunk", p.numShipsStillAfloat(), i + 1);
		}
		assertEquals(p.numShipsStillAfloat(), 10);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				p.respondToFire(i, j);
			}
		}
		assertEquals("We have fired everywhere, all ships must be sunk", p.numShipsStillAfloat(), 0);
	}
}
