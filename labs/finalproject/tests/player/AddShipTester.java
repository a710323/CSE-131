package finalproject.tests.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;
import finalproject.Player;
import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

public class AddShipTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	private Player p;

	@Before
	public void createArgsProcessor() {
		ArgsProcessor ap = new ArgsProcessor(new String[] {});
		p = new HumanPlayer("Mariah", 10, 10, ap);
	}

	@Test
	public void testValidAddShipLength1Horiz() {
		assertTrue("Check your add ship method", p.addShip(new Ship(0, 0, 1, true)));
	}

	@Test
	public void testValidAddShipLength1Vert() {
		assertTrue("Check your add ship method", p.addShip(new Ship(0, 0, 1, false)));
	}

	@Test
	public void testInvalidAddShipLength1Horiz() {
		assertFalse("Out of bound ships should not be accepted", p.addShip(new Ship(-1, -1, 1, true)));
	}

	@Test
	public void testInvalidAddShipLength1Vert() {
		assertFalse("Out of bound ships should not be accepted", p.addShip(new Ship(-1, -1, 1, false)));
	}

	@Test
	public void testInvalidAddShipTooLongHoriz() {
		assertFalse("Ships that are wider than the board should not be accepted", p.addShip(new Ship(0, 0, 20, true)));
	}

	@Test
	public void testInvalidAddShipTooLongVert() {
		assertFalse("Ships that are longer than the board should not be accepted",
				p.addShip(new Ship(0, 0, 20, false)));
	}

	@Test
	public void testInvalidAddShipTwoIdenticalShips() {
		assertTrue("This ship should be accepted", p.addShip(new Ship(0, 0, 1, true)));
		assertFalse("Do not accept the same ship twice", p.addShip(new Ship(0, 0, 1, true)));
	}

	@Test
	public void testInvalidAddShipTwoShipsOverlap() {
		assertTrue("This ship should be accepted", p.addShip(new Ship(1, 1, 2, true)));
		assertFalse("Do not accept a ship that overlaps with another existing ship",
				p.addShip(new Ship(1, 1, 1, true)));
		assertFalse("Do not accept a ship that overlaps with another existing ship",
				p.addShip(new Ship(1, 0, 2, false)));
	}

}
