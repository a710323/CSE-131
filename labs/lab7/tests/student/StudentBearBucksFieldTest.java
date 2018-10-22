package lab7.tests.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import cse131.ReflectionUtils;
import lab5.tests.utils.UnitTestUtils;
import lab7.Student;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class StudentBearBucksFieldTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String firstName = "Ron";
		String lastName = "Cytron";
		int id = 1;
		Student student = new Student(firstName, lastName, id);

		Field bearBucksBalanceField =  ReflectionUtils
				.getOneAndOnlyOneDeclaredFieldContainingIgnoringCase(student.getClass(), "bear", "buck", "balance");
		assertNotSame(Double.class, bearBucksBalanceField.getType());
		assertSame(Double.TYPE, bearBucksBalanceField.getType());

		assertTrue(Modifier.isPrivate(bearBucksBalanceField.getModifiers()));
		assertFalse(Modifier.isFinal(bearBucksBalanceField.getModifiers()));

		bearBucksBalanceField.setAccessible(true);
		assertEquals(0.0, (double) bearBucksBalanceField.get(student), 0.0);
	}
}
