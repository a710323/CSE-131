package studio9.tests;

import java.lang.reflect.Field;
import java.util.Map;

import lab7.Student;
import studio9.UniversityDatabase;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class DatabaseMapAccessUtils {
	@SuppressWarnings("unchecked")
	static Map<String, Student> getMap(UniversityDatabase universityDatabase, Field mapField)
			throws IllegalArgumentException, IllegalAccessException {
		mapField.setAccessible(true);
		return (Map<String, Student>) mapField.get(universityDatabase);
	}

	static Map<String, Student> getMap(UniversityDatabase universityDatabase)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = universityDatabase.getClass().getDeclaredFields();
		Field mapField = fields[0];
		return getMap(universityDatabase, mapField);
	}
}
