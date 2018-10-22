package lab7.tests.course;

import static org.junit.Assert.assertEquals;

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

import lab5.tests.utils.StringTestUtils;
import lab5.tests.utils.UnitTestUtils;
import lab7.Course;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#Course(String, int, int)}
 */
@RunWith(Parameterized.class)
public class CourseConstructorTest {
	private final String name;
	private final int credits;
	private final int capacity;

	public CourseConstructorTest(String name, int credits, int capacity) {
		this.name = name;
		this.credits = credits;
		this.capacity = capacity;
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Course course = new Course(name, credits, capacity);
		assertEquals(name, course.getName());
		assertEquals(credits, course.getCredits());
		assertEquals(capacity, course.getCapacity());
	}

	@Parameters(name = "name: {0}; credits: {1}; capacity: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { "CSE 131", 3, 700 });
		result.add(new Object[] { "CSE 132", 3, 400 });
		result.add(new Object[] { "CSE 222", 3, 42 });
		result.add(new Object[] { "CSE 231", 3, 40 });
		result.add(new Object[] { "CSE 247", 3, 500 });

		Random random = new Random();
		final int ITERATION_COUNT = 10;
		for (int i = 0; i < ITERATION_COUNT; i++) {
			String name = StringTestUtils.nextRandomString(random, 3) + " " + (100 + random.nextInt(400));
			int credits = 3 + random.nextInt(2);
			int capacity = 10 + random.nextInt(30);
			result.add(new Object[] { name, credits, capacity });
		}

		return result;
	}

}
