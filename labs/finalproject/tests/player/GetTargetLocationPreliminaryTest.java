package finalproject.tests.player;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;

import cse131.ArgsProcessor;
import finalproject.HumanPlayer;
import lab5.tests.utils.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link HumanPlayer#getTargetLocation()}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetTargetLocationPreliminaryTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void testASingleValid() {
		int boardWidth = 7;
		int boardHeight = 10;
		int x = 2;
		int y = 3;
		ArgsProcessor ap = createArgsProcessorForXYs(x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] expected = { x, y };
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testBMultipleValid() {
		int boardWidth = 7;
		int boardHeight = 10;
		int xA = 2;
		int yA = 3;
		int xB = 4;
		int yB = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xA, yA, xB, yB);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xyA = player.getTargetLocation();
		assertNotNull(xyA);
		int[] expectedA = { xA, yA };
		assertArrayEquals(expectedA, xyA);

		int[] xyB = player.getTargetLocation();
		assertNotNull(xyB);
		int[] expectedB = { xB, yB };
		assertArrayEquals(expectedB, xyB);
	}

	@Test
	public void testCNegativeX() {
		int boardWidth = 7;
		int boardHeight = 10;
		int xIgnore = -1;
		int yIgnore = 3;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testDNegativeY() {
		int boardWidth = 7;
		int boardHeight = 10;
		int xIgnore = 2;
		int yIgnore = -1;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testEMultipleNegative() {
		int boardWidth = 7;
		int boardHeight = 10;
		int xIgnoreA = -1;
		int yIgnoreA = 3;
		int xIgnoreB = 2;
		int yIgnoreB = -1;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnoreA, yIgnoreA, xIgnoreB, yIgnoreB, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpectedA = { xIgnoreA, yIgnoreA };
		int[] notExpectedB = { xIgnoreB, yIgnoreB };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpectedA)));
		assertThat(xy, not(equalTo(notExpectedB)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testFIgnoreXBeyondBoth() {
		int boardWidth = 7;
		int boardHeight = 10;
		int xIgnore = 100;
		int yIgnore = 3;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testGIgnoreXBeyondWidthButNotHeight() {
		int boardWidth = 7;
		int boardHeight = 10;
		int xIgnore = boardWidth + 1;
		int yIgnore = 3;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testHIgnoreXEqualToWidth() {
		int boardWidth = 7;
		int boardHeight = 10;
		int xIgnore = boardWidth;
		int yIgnore = 3;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testIIgnoreYBeyondBoth() {
		int boardWidth = 13;
		int boardHeight = 10;
		int xIgnore = 2;
		int yIgnore = 100;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testJIgnoreYBeyondHeightButNotWidth() {
		int boardWidth = 13;
		int boardHeight = 10;
		int xIgnore = 2;
		int yIgnore = boardHeight + 1;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	@Test
	public void testKIgnoreYEqualToHeight() {
		int boardWidth = 13;
		int boardHeight = 10;
		int xIgnore = 2;
		int yIgnore = boardHeight;
		int x = 4;
		int y = 5;
		ArgsProcessor ap = createArgsProcessorForXYs(xIgnore, yIgnore, x, y);

		HumanPlayer player = new HumanPlayer("Ron", boardHeight, boardWidth, ap);

		int[] xy = player.getTargetLocation();
		assertNotNull(xy);
		int[] notExpected = { xIgnore, yIgnore };
		int[] expected = { x, y };
		assertThat(xy, not(equalTo(notExpected)));
		assertArrayEquals(expected, xy);
	}

	private static ArgsProcessor createArgsProcessorForXYs(int... values) {
		String[] args = new String[values.length];
		for (int i = 0; i < values.length; ++i) {
			args[i] = Integer.toString(values[i]);
		}
		return new ArgsProcessor(args);
	}
}
