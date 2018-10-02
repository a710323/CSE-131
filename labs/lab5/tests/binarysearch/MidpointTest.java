package lab5.tests.binarysearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import lab5.BinarySearch;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link BinarySearch#calculateMidPoint(int, int)}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MidpointTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testFrom0() {
		int actual = BinarySearch.calculateMidPoint(0, 10);
		assertEquals(5, actual);
	}

	@Test
	public void testFromMinimumOtherThan0() {
		int actual = BinarySearch.calculateMidPoint(300, 400);
		assertNotEquals(
				"this mistake is so common we put in a check to make sure midpoint(300, 400) does not return 50 before we check to ensure it is correctly calculated as 350",
				50, actual);
		assertNotEquals("midpoint(300, 400) is not 200. it is 350.", 200, actual);
		assertNotEquals("midpoint(300, 400) is not 150. it is 350.", 150, actual);
		assertEquals(350, actual);
	}

	@Test
	public void testNotRounded() {
		int actual = BinarySearch.calculateMidPoint(300, 400);
		assertNotEquals(
				"do not round.  granted we are being picky, but midpoint(300, 401) should not return 351.  it should return the floored 350.",
				351, actual);
		assertEquals(350, actual);
	}

	@Test
	public void testReverseOrder() {
		int actual = BinarySearch.calculateMidPoint(400, 300);
		assertEquals(350, actual);
	}
}
