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
public class StudentGradeAndCreditTotalFieldsTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String firstName = "Ron";
		String lastName = "Cytron";
		int id = 1;
		Student student = new Student(firstName, lastName, id);

		Field totalGradeQualityPointsField = ReflectionUtils
				.getOneAndOnlyOneDeclaredFieldContainingIgnoringCase(student.getClass(), "quality", "point");
		assertNotSame(Double.class, totalGradeQualityPointsField.getType());
		assertSame(Double.TYPE, totalGradeQualityPointsField.getType());

		Field totalAttemptedCreditsField = ReflectionUtils
				.getOneAndOnlyOneDeclaredFieldContainingIgnoringCase(student.getClass(), "attempt");
		assertNotSame(Integer.class, totalAttemptedCreditsField.getType());
		assertSame(Integer.TYPE, totalAttemptedCreditsField.getType());

		Field totalPassingCreditsField = ReflectionUtils
				.getOneAndOnlyOneDeclaredFieldContainingIgnoringCase(student.getClass(), "pass");
		assertNotSame(Integer.class, totalPassingCreditsField.getType());
		assertSame(Integer.TYPE, totalPassingCreditsField.getType());

		assertTrue(Modifier.isPrivate(totalGradeQualityPointsField.getModifiers()));
		assertTrue(Modifier.isPrivate(totalAttemptedCreditsField.getModifiers()));
		assertTrue(Modifier.isPrivate(totalPassingCreditsField.getModifiers()));

		assertFalse(Modifier.isFinal(totalGradeQualityPointsField.getModifiers()));
		assertFalse(Modifier.isFinal(totalAttemptedCreditsField.getModifiers()));
		assertFalse(Modifier.isFinal(totalPassingCreditsField.getModifiers()));

		totalGradeQualityPointsField.setAccessible(true);
		assertEquals(0.0, (double) totalGradeQualityPointsField.get(student), 0.0);
		totalAttemptedCreditsField.setAccessible(true);
		assertEquals(0, (int) totalAttemptedCreditsField.get(student));
		totalPassingCreditsField.setAccessible(true);
		assertEquals(0, (int) totalPassingCreditsField.get(student));
	}
}
