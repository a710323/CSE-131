package studio5x.chart;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;

import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import lab5.tests.utils.StringTestUtils;
import performance.PerformanceTimingChartApp;
import studio5x.MergeCombiner;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MergeCombinerPerformanceTimingChartApp extends PerformanceTimingChartApp {
	private static final int STRING_LENGTH = 6;
	private static final int TIMING_ITERATIONS = 1_000;
	private static final int ARRAY_LENGTH_MULTIPLIER = 1_000;

	public MergeCombinerPerformanceTimingChartApp() {
		super("Concat Then Sort vs Merge", "Concat Then Sort", "Merge", 
				"Array Length (x " + ARRAY_LENGTH_MULTIPLIER + ")", "Average Time (" + TIMING_ITERATIONS + " samples)",
				1, 10, 1);
	}

	@Override
	protected void kickInTheJustInTimeCompiler() {
		Random random = new Random();
		int arrayLength = 1_000;
		String[] a = StringTestUtils.toStringArray(StringTestUtils.createUniqueSortedStringList(
				() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength));
		String[] b = StringTestUtils.toStringArray(StringTestUtils.createUniqueSortedStringList(
				() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength));

		Timeline aTimeline = createAlertTimeline("MergeCombiner.createMergeCombinedArray");
		for (int i = 0; i < 1_000; i++) {
			aTimeline.play();
			MergeCombiner.createMergeCombinedArray(a, b);
			aTimeline.stop();
			concatAndSort(a, b);
		}
	}

	private static double time(Random random, String[] a, String[] b, BiFunction<String[], String[], String[]> combiner)
			throws InterruptedException {
		requestTimeForGarbageCollector();
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < TIMING_ITERATIONS; i++) {
			combiner.apply(a, b);
		}
		long tDelta = System.currentTimeMillis() - t0;
		return (tDelta * 0.001) / TIMING_ITERATIONS;
	}

	private static String[] concatAndSort(String[] a, String[] b) {
		String[] result = new String[a.length + b.length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		Arrays.sort(result, String::compareToIgnoreCase);
		return result;
	}

	@Override
	protected Task<Void> createTask(NumberAxis xAxis, Series<Number, Number> aSeries, Series<Number, Number> bSeries) {
		Task<Void> result = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				Random random = new Random();

				Timeline bTimeline = createAlertTimeline("MergeCombiner.createMergeCombinedArray");

				int min = (int) xAxis.getLowerBound();
				int maxInclusive = (int) xAxis.getUpperBound();
				for (int n = min; n <= maxInclusive; n++) {

					int arrayLength = n * ARRAY_LENGTH_MULTIPLIER;
					String[] a = StringTestUtils.toStringArray(StringTestUtils.createUniqueSortedStringList(
							() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength));
					String[] b = StringTestUtils.toStringArray(StringTestUtils.createUniqueSortedStringList(
							() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength));

					double aTime = time(random, a, b, MergeCombinerPerformanceTimingChartApp::concatAndSort);
					updateLater(aSeries, n, aTime);

					bTimeline.play();
					double bTime = time(random, a, b, MergeCombiner::createMergeCombinedArray);
					bTimeline.stop();
					updateLater(bSeries, n, bTime);
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