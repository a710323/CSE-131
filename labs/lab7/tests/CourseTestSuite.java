package lab7.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lab7.tests.course.CourseAddStudentComprehensiveTest;
import lab7.tests.course.CourseAddStudentPreliminaryTest;
import lab7.tests.course.CourseAddUniqueStudentsSeatsRemainingTest;
import lab7.tests.course.CourseAverageGradePointAverageComprehensiveTest;
import lab7.tests.course.CourseAverageGradePointAveragePreliminaryTest;
import lab7.tests.course.CourseConstructorTest;
import lab7.tests.course.CourseRosterComprehensiveTest;
import lab7.tests.course.CourseRosterPreliminaryTest;
import lab7.tests.course.CourseToStringIsOverriddenTest;
import lab7.tests.course.CourseToStringTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CourseConstructorTest.class, CourseAddUniqueStudentsSeatsRemainingTest.class,
		CourseAddStudentPreliminaryTest.class, CourseAddStudentComprehensiveTest.class,
		CourseRosterPreliminaryTest.class, CourseRosterComprehensiveTest.class,
		CourseAverageGradePointAveragePreliminaryTest.class, CourseAverageGradePointAverageComprehensiveTest.class,
		CourseToStringIsOverriddenTest.class, CourseToStringTest.class })
public class CourseTestSuite {
}
