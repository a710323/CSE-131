package lab7.tests.course;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab5.tests.utils.UnitTestUtils;
import lab7.Course;
import lab7.Student;
import lab7.tests.util.GradeCreditPair;
import lab7.tests.util.StudentCourseUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 * 
 *         {@link Course#calculateAverageGPA()}
 */
@RunWith(Parameterized.class)
public class CourseAverageGradePointAveragePreliminaryTest {
	private final int capacity;
	private final List<GradeCreditPair> gpaCreditPairs;
	private final double expected;

	public CourseAverageGradePointAveragePreliminaryTest(int capacity, List<GradeCreditPair> gpaCreditPairs) {
		this.capacity = capacity;
		this.gpaCreditPairs = gpaCreditPairs;
		double totalGPA = gpaCreditPairs.stream().mapToDouble(pair -> pair.getGrade()).sum();
		this.expected = totalGPA / gpaCreditPairs.size();
	}

	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	@Test
	public void test() {
		Course course = new Course("CSE 131", 3, capacity);
		Student[] students = StudentCourseUtils.generateUniqueStudents(gpaCreditPairs.size());
		int i = 0;
		for (Student student : students) {
			GradeCreditPair pair = gpaCreditPairs.get(i);
			student.submitGrade(pair.getGrade(), pair.getCredits());
			course.addStudent(student);
			++i;
		}
		assertEquals(expected, course.calculateAverageGPA(), UnitTestUtils.reasonableEpsilon());
	}

	@Parameters(name = "capacity: {0}; gpaCreditPairs: {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> result = new LinkedList<>();
		result.add(new Object[] { 1, Arrays.asList(new GradeCreditPair(4.0, 1)) });
		result.add(new Object[] { 2, Arrays.asList(new GradeCreditPair(4.0, 1)) });

		result.add(new Object[] { 2, Arrays.asList(new GradeCreditPair(4.0, 1), new GradeCreditPair(3.0, 1)) });
		result.add(new Object[] { 3, Arrays.asList(new GradeCreditPair(4.0, 1), new GradeCreditPair(3.0, 1)) });

		result.add(new Object[] { 2, Arrays.asList(new GradeCreditPair(4.0, 2), new GradeCreditPair(3.0, 1)) });
		result.add(new Object[] { 3, Arrays.asList(new GradeCreditPair(4.0, 2), new GradeCreditPair(3.0, 1)) });
		result.add(new Object[] { 2, Arrays.asList(new GradeCreditPair(4.0, 1), new GradeCreditPair(3.0, 2)) });
		result.add(new Object[] { 3, Arrays.asList(new GradeCreditPair(4.0, 1), new GradeCreditPair(3.0, 2)) });
		return result;
	}

}
