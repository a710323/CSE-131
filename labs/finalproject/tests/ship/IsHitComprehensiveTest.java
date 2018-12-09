package finalproject.tests.ship;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import finalproject.Ship;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Ship#isHit(int, int)}
 */
@RunWith(Parameterized.class)
public class IsHitComprehensiveTest {
	private final int topLeftX;
	private final int topLeftY;
	private final int length;
	private final boolean isHorizontal;

	public IsHitComprehensiveTest(int topLeftX, int topLeftY, int length, boolean isHorizontal) {
		this.topLeftX = topLeftY;
		this.topLeftY = topLeftY;
		this.length = length;
		this.isHorizontal = isHorizontal;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testTopLeft() {
		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertTrue(ship.isHit(topLeftX, topLeftY));
	}

	@Test
	public void testOppositeDirections() {
		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		assertFalse(ship.isHit(topLeftX - 1, topLeftY));
		assertFalse(ship.isHit(topLeftX, topLeftY - 1));
	}

	@Test
	public void testCorrectDirection() {
		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		int x = topLeftX;
		int y = topLeftY;
		for (int i = 0; i < length; ++i) {
			assertTrue(trueMessage(x, y), ship.isHit(x, y));
			if (isHorizontal) {
				++x;
			} else {
				++y;
			}
		}
		assertFalse("\npassed the end of the ship.  incorrect length?\n" + falseMessage(x, y), ship.isHit(x, y));
	}

	@Test
	public void testIncorrectDirection() {
		Ship ship = new Ship(topLeftX, topLeftY, length, isHorizontal);
		int x = topLeftX;
		int y = topLeftY;
		for (int i = 1; i < length; ++i) {
			if (isHorizontal) {
				++y; // note: incorrect direction
			} else {
				++x; // note: incorrect direction
			}
			assertFalse(falseMessage(x, y), ship.isHit(x, y));
		}
	}

	private static String trueMessage(int x, int y) {
		return "isHit(" + x + ", " + y + ") returns false when it should return true.";
	}

	private static String falseMessage(int x, int y) {
		return "isHit(" + x + ", " + y + ") returns true when it should return false.";
	}

	@Parameters(name = "topLeftX: {0}; topLeftY: {1}; length: {2}; isHorizontal: {3};")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();

		Random random = new Random();
		for (boolean isHorizontal : new boolean[] { true, false }) {

			result.add(new Object[] { 0, 0, 1, isHorizontal });
			result.add(new Object[] { 2, 3, 1, isHorizontal });

			result.add(new Object[] { 0, 0, 2, isHorizontal });
			result.add(new Object[] { 2, 3, 2, isHorizontal });

			result.add(new Object[] { 0, 0, 71, isHorizontal });
			result.add(new Object[] { 2, 3, 71, isHorizontal });

			for (int i = 0; i < 10; ++i) {
				int x = random.nextInt(1000);
				int y = random.nextInt(1000);
				int length = random.nextInt(999)+1;

				result.add(new Object[] { x, y, length, isHorizontal });
			}
		}
		return result;
	}

}
