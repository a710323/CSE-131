package studio9.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lab7.Student;
import studio9.UniversityDatabase;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UniversityDatabaseTest {
	@Test
	public void singleInstanceVariableOfTypeMapTest() {
		Field[] fields = UniversityDatabase.class.getDeclaredFields();
		assertEquals(1, fields.length);
		Class<?> instanceVariableType = fields[0].getType();
		assertTrue(Map.class.isAssignableFrom(instanceVariableType));
	}

	@Test
	public void test() throws IllegalArgumentException, IllegalAccessException {
		String aAccountName = "a.shirley";
		Student aStudent = new Student("Anne", "Shirley", 1);
		String aExpectedFullName = "Anne Shirley";
		double aBucks = 20.0;
		assertEquals(aExpectedFullName, aStudent.getFullName());
		assertEquals(1, aStudent.getId());
		assertEquals(0.0, aStudent.getBearBucksBalance(), 0.0);
		aStudent.depositBearBucks(aBucks);
		assertEquals(aBucks, aStudent.getBearBucksBalance(), 0.0);

		String bAccountName = "bucketc";
		Student bStudent = new Student("Charlie", "Bucket", 2);
		String bExpectedFullName = "Charlie Bucket";
		double bBucks = 300.0;
		assertEquals(bExpectedFullName, bStudent.getFullName());
		assertEquals(2, bStudent.getId());
		assertEquals(0.0, bStudent.getBearBucksBalance(), 0.0);
		bStudent.depositBearBucks(bBucks);
		assertEquals(bBucks, bStudent.getBearBucksBalance(), 0.0);

		UniversityDatabase universityDatabase = new UniversityDatabase();
		Map<String, Student> map = DatabaseMapAccessUtils.getMap(universityDatabase);
		assertNotNull(map);
		assertEquals(0, map.size());
		universityDatabase.addStudent(aAccountName, aStudent);
		assertEquals(1, map.size());
		assertTrue(map.containsKey(aAccountName));
		assertSame(aStudent, map.get(aAccountName));

		assertEquals(1, universityDatabase.getStudentCount());
		String aFullName = universityDatabase.lookupFullName(aAccountName);
		assertNotNull(aFullName);
		assertEquals(aExpectedFullName, aFullName);

		double aTotalBearBucks = universityDatabase.getTotalBearBucks();
		assertEquals(aBucks, aTotalBearBucks, 0.0);

		universityDatabase.addStudent(bAccountName, bStudent);
		assertEquals(2, map.size());
		assertTrue(map.containsKey(aAccountName));
		assertTrue(map.containsKey(bAccountName));
		assertSame(aStudent, map.get(aAccountName));
		assertSame(bStudent, map.get(bAccountName));

		assertEquals(2, universityDatabase.getStudentCount());
		String bFullName = universityDatabase.lookupFullName(bAccountName);
		assertNotNull(bFullName);
		assertEquals(bExpectedFullName, bFullName);

		double aPlusBTotalBearBucks = universityDatabase.getTotalBearBucks();
		assertEquals(aBucks + bBucks, aPlusBTotalBearBucks, 0.0);

		String nonExistentAccountName = "sidd.finch";

		assertFalse(map.containsKey(nonExistentAccountName));
		assertNull(universityDatabase.lookupFullName(nonExistentAccountName));

	}
}
