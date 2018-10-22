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
 * 
 *         {@link Student#Student(String, String, int)}
 */
public class StudentConstructorTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String firstName = "Doug";
		String lastName = "Shook";
		int id = 111111;
		Student student = new Student(firstName, lastName, id);

		Field firstNameField = ReflectionUtils.getOneAndOnlyOneDeclaredFieldContainingIgnoringCase(student.getClass(),
				"first");
		assertSame(String.class, firstNameField.getType());

		Field lastNameField = ReflectionUtils.getOneAndOnlyOneDeclaredFieldContainingIgnoringCase(student.getClass(),
				"last");
		assertSame(String.class, lastNameField.getType());

		Field idField = ReflectionUtils.getOneAndOnlyOneDeclaredFieldContainingIgnoringCase(student.getClass(), "id");
		assertNotSame(Integer.class, idField.getType());
		assertSame(Integer.TYPE, idField.getType());

		assertTrue(Modifier.isPrivate(firstNameField.getModifiers()));
		assertTrue(Modifier.isPrivate(lastNameField.getModifiers()));
		assertTrue(Modifier.isPrivate(idField.getModifiers()));

		assertFalse(Modifier.isFinal(firstNameField.getModifiers()));
		assertFalse(Modifier.isFinal(lastNameField.getModifiers()));
		assertTrue(Modifier.isFinal(idField.getModifiers()));

		firstNameField.setAccessible(true);
		assertEquals(firstName, firstNameField.get(student));

		lastNameField.setAccessible(true);
		assertEquals(lastName, lastNameField.get(student));

		idField.setAccessible(true);
		assertEquals(id, idField.get(student));
	}
}
