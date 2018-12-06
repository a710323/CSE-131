package finalproject.tests.ship;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ShipEqualsTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		int x = 2;
		int y = 3;
		int length = 4;
		boolean isHorizontal = true;
		Ship ship = new Ship(x, y, length, isHorizontal);

		assertFalse(ship.equals(new Ship(x, x, length, isHorizontal)));
		assertFalse(ship.equals(new Ship(y, y, length, isHorizontal)));
		assertFalse(ship.equals(new Ship(y, x, length, isHorizontal)));
		assertFalse(ship.equals(new Ship(x, y, length - 1, isHorizontal)));
		assertFalse(ship.equals(new Ship(x, y, length + 1, isHorizontal)));
		assertFalse(ship.equals(new Ship(x, y, length, !isHorizontal)));

		Ship other = new Ship(x, y, length, isHorizontal);
		// neither ship is hit
		assertTrue(ship.equals(other));

		assertFalse(ship.isHit(x - 1, y - 1));
		// non-hits should not affect the ship
		assertTrue(ship.equals(other));

		assertTrue(ship.isHit(x, y));
		// only one ship is hit (once and in same location)
		assertFalse(ship.equals(other));

		assertTrue(other.isHit(x, y));
		// both ships are hit (once and in same location)
		assertTrue(ship.equals(other));

		assertTrue(ship.isHit(x, y));
		// hitting a ship a second time in the same location should not affect ship
		assertTrue(ship.equals(other));

		assertTrue(ship.isHit(x + 1, y));
		// only one ship is hit twice
		assertFalse(ship.equals(other));

		assertTrue(other.isHit(x + 2, y));
		// ships hit in different locations
		assertFalse(ship.equals(other));

		assertTrue(ship.isHit(x + 2, y));
		assertFalse(ship.equals(other));
		assertTrue(other.isHit(x + 1, y));
		// both ships are hit (thrice and in same locations)
		assertTrue(ship.equals(other));

		assertTrue(ship.isHit(x + 3, y));
		// only one ship is hit all four times
		assertFalse(ship.equals(other));

		assertTrue(other.isHit(x + 3, y));
		// both ships are hit all four times
		assertTrue(ship.equals(other));

		assertFalse(ship.isHit(x + 4, y));
		// again, non-hits should not affect the ship
		assertTrue(ship.equals(other));
	}
}
