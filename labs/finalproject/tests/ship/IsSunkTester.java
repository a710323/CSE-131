package finalproject.tests.ship;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

public class IsSunkTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testOneLengthShipHoriz() {
		Ship s = new Ship(1, 1, 1, true);
		assertFalse("We haven't fired yet, this ship can't be sunk", s.isSunk());
		assertFalse(s.isHit(3, 2));
		assertFalse("We missed, this ship can't be sunk", s.isSunk());
		assertTrue(s.isHit(1, 1)); // sink
		assertTrue("We hit the ship and it's of length one, it must be sunk", s.isSunk());
	}

	@Test
	public void testOneLengthShipVert() {
		Ship s = new Ship(1, 1, 1, false);
		assertFalse("We haven't fired yet, this ship can't be sunk", s.isSunk());
		assertFalse(s.isHit(3, 2));
		assertFalse("We missed, this ship can't be sunk", s.isSunk());
		assertTrue(s.isHit(1, 1)); // sink
		assertTrue("We hit the ship and it's of length one, it must be sunk", s.isSunk());
	}

	@Test
	public void testTwoLengthShipHoriz() {
		Ship s = new Ship(1, 3, 2, true);
		assertFalse("We haven't fired yet, this ship can't be sunk", s.isSunk());
		assertFalse(s.isHit(1, 1));
		assertFalse("We missed, this ship can't be sunk", s.isSunk());
		assertTrue(s.isHit(2, 3)); // hit
		assertFalse("We hit the ship at (2, 3), but that's only part of it, it can't be sunk", s.isSunk());
		assertFalse(s.isHit(7, 8));
		assertFalse("We missed, this ship can't be sunk", s.isSunk());
		assertTrue(s.isHit(1, 3)); // sink
		assertTrue("We hit the final piece of the ship, it must be sunk", s.isSunk());
		assertFalse(s.isHit(2, 6));
		assertTrue("We missed, but the ship should still be sunk", s.isSunk());
	}

	@Test
	public void testTwentyLengthShipVert() {
		Ship s = new Ship(3, 3, 20, false);
		assertFalse("We haven't fired yet, this ship can't be sunk", s.isSunk());
		for (int i = 4; i < 22; i++) {
			assertFalse(s.isHit(i, 3)); // miss
			assertFalse("We missed, this ship can't be sunk", s.isSunk());
		}
		assertFalse(s.isHit(22, 3)); // make sure they didn't confuse vertical and horizontal
		assertFalse("We missed, this ship can't be sunk -- you may have confused vertical and horizontal", s.isSunk());
		for (int i = 3; i < 22; i++) {
			assertTrue(s.isHit(3, i)); // hit
			assertFalse("We hit the ship at (3, " + i + "), but that's only part of it, it is not yet sunk",
					s.isSunk());
		}
		assertTrue(s.isHit(3, 22)); // sink
		assertTrue("We hit the final piece of the ship at (3, 22), it must be sunk", s.isSunk());
		assertFalse(s.isHit(1, 3)); // make sure ship is still sunk
		assertTrue("We missed, but the ship should still be sunk", s.isSunk());
		assertFalse(s.isHit(2, 6));
		assertTrue("We hit it again, but the ship should still be sunk", s.isSunk());
	}

	@Test
	public void testTwentyLengthShipHoriz() {
		Ship s = new Ship(2, 2, 20, true);
		assertFalse("We haven't fired yet, this ship can't be sunk", s.isSunk());
		for (int i = 3; i < 21; i++) {
			assertFalse(s.isHit(2, i)); // miss
			assertFalse("We missed, this ship can't be sunk", s.isSunk());
		}
		assertFalse(s.isHit(2, 21)); // make sure they didn't confuse vertical and horizontal
		assertFalse("We missed, this ship can't be sunk -- you may have confused vertical and horizontal", s.isSunk());
		for (int i = 2; i < 21; i++) {
			assertTrue(s.isHit(i, 2)); // hit
			assertFalse("We hit the ship at (" + i + ", 2), but that's only part of it, it can't be sunk", s.isSunk());
		}
		assertTrue(s.isHit(21, 2)); // sink
		assertTrue("We hit the final piece of the ship at (21, 2), it must be sunk", s.isSunk());
		assertFalse(s.isHit(1, 3)); // make sure ship is still sunk
		assertTrue("We missed, but the ship should still be sunk", s.isSunk());
		assertTrue(s.isHit(6, 2));
		assertTrue("We hit it again, but the ship should still be sunk", s.isSunk());
	}

}
