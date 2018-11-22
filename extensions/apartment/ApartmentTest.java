package apartment;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApartmentTest {

	@Test
	public void test1findBestValueAfterStopAtK() {
		final double EPSILON = 0.0;
		double[] array;
		// Cases that use k=1
		array = new double[] { 0.1, 0.2, 0.5, 0.3, 0.24, 0.125 };
		Assert.assertEquals(0.2, Apartment.findBestValueAfterStopAtK(array, 1), EPSILON);

		// Cases that use k=2
		array = new double[] { 0.1, 0.2, 0.5, 0.3, 0.24, 0.125 };
		Assert.assertEquals(0.5, Apartment.findBestValueAfterStopAtK(array, 2), EPSILON);

		array = new double[] { 0.3, 0.1, 0.2, 0.5, 0.24, 0.125 };
		Assert.assertEquals(0.5, Apartment.findBestValueAfterStopAtK(array, 2), EPSILON);

		array = new double[] { 0.1, 0.34, 0.2, 0.3, 0.5, 0.125 };
		Assert.assertEquals(0.5, Apartment.findBestValueAfterStopAtK(array, 2), EPSILON);

		array = new double[] { 0.34, 0.2, 0.3, 0.24, 0.125, 0.5 };
		Assert.assertEquals(0.5, Apartment.findBestValueAfterStopAtK(array, 2), EPSILON);
	}

	@Test
	public void test2lastValueCase() {
		final double EPSILON = 0.0;
		double[] array = { 0.1, 0.2, 0.5, 0.3, 0.2, 0.125 };
		Assert.assertEquals(0.125, Apartment.findBestValueAfterStopAtK(array, 3), EPSILON);
	}

	@Test
	public void test3findOptimalStoppingPoint() {
		int[] apartmentsArray = { 4, 6, 10, 15, 20, 35 };
		int[] trialsArray = { 1000, 1000, 10000, 15000, 20000, 35000 };
		int[] expecteds = { 1, 2, 4, 6, 7, 13 };

		for (int i = 0; i < apartmentsArray.length; i++) {
			int K = Apartment.findOptimalStoppingPoint(apartmentsArray[i], trialsArray[i]);

			final double EPSILON = 1.0;
			// test ints as doubles to allow for off by 1
			String message = "i: " + i + "; apartments: " + apartmentsArray[i] + "; trials: " + trialsArray[i];
			Assert.assertEquals(message, expecteds[i], K, EPSILON);
		}
	}
}
