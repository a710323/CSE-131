package lab6.chart;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import javafx.concurrent.Task;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import lab5.Sort;
import lab5.tests.utils.StringTestUtils;
import lab6.MergeSort;
import performance.PerformanceTimingChartApp;

public class SortPerformanceTimingChartApp extends PerformanceTimingChartApp {
	private static final int STRING_LENGTH = 6;
	private static final int TIMING_ITERATIONS = 10;
	private static final int ARRAY_LENGTH_MULTIPLIER = 100;

	public SortPerformanceTimingChartApp() {
		super("Selection vs Merge Sort", "Selection Sort", "Merge Sort",
				"Array Length (x " + ARRAY_LENGTH_MULTIPLIER + ")", "Average Time (" + TIMING_ITERATIONS + " samples)",
				1, 10, 1);
	}

	@Override
	protected void kickInTheJustInTimeCompiler() {
		Random random = new Random();
		String[] array = StringTestUtils.toStringArray(
				StringTestUtils.createUniqueSortedStringList(() -> StringTestUtils.nextRandomString(random, 3), 1_000));
		for (int i = 0; i < 100; i++) {
			Sort.selectionSortInPlace(array);
			MergeSort.createSortedArray(array);
		}
	}

	private static double time(Random random, String[] array, Consumer<String[]> sort) throws InterruptedException {
		requestTimeForGarbageCollector();
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < TIMING_ITERATIONS; i++) {
			sort.accept(array);
		}
		long tDelta = System.currentTimeMillis() - t0;
		return (tDelta * 0.001) / TIMING_ITERATIONS;
	}

	@Override
	protected Task<Void> createTask(NumberAxis xAxis, Series<Number, Number> selectionSortSeries, Series<Number, Number> mergeSortSeries) {
		Task<Void> result = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				Random random = new Random();
				int min = (int) xAxis.getLowerBound();
				int maxInclusive = (int) xAxis.getUpperBound();
				for (int n = min; n <= maxInclusive; n++) {

					int arrayLength = n * ARRAY_LENGTH_MULTIPLIER;
					List<String> unsorted = StringTestUtils.createUniqueStringList(
							() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
					String[] array = StringTestUtils.toStringArray(unsorted);

					double tLinear = time(random, array, Sort::selectionSortInPlace);
					updateLater(selectionSortSeries, n, tLinear);

					double tBinary = time(random, array, MergeSort::createSortedArray);
					updateLater(mergeSortSeries, n, tBinary);
				}
				return null;
			}
		};
		return result;
	}

	public static void main(String[] args) {
		launch(args);
	}
}