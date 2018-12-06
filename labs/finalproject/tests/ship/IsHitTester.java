package finalproject.tests.ship;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

public class IsHitTester {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testIsHitHorizontal() {
		Ship s = new Ship(0, 0, 1, true);
		assertTrue("There is a ship at (0, 0), it should be a hit", s.isHit(0, 0));
		for (int i = -100; i < 100; ++i) {
			for (int j = -100; j < 100; ++j) {
				if (i != 0 || j != 0) {
					assertFalse("There is not a ship at (" + i + ", " + j + "), it should not be a hit", s.isHit(i, j));
				}
			}
		}
		assertTrue("There is a ship at (0, 0), it should still be a hit", s.isHit(0, 0));
	}
	
	@Test
	public void testIsHitVertical() {
		Ship s = new Ship(0, 0, 1, false);
		assertTrue("There is a ship at (0, 0), it should be a hit", s.isHit(0, 0));
		for (int i = -100; i < 100; ++i) {
			for (int j = -100; j < 100; ++j) {
				if (i != 0 || j != 0) {
					assertFalse("There is not a ship at (" + i + ", " + j + "), it should not be a hit", s.isHit(i, j));
				}
			}
		}
		assertTrue("There is a ship at (0, 0), it should still be a hit", s.isHit(0, 0));
	}

}
