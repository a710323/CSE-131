package lab5.chart;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiFunction;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Duration;
import lab5.BinarySearch;
import lab5.LinearSearch;
import lab5.tests.utils.StringTestUtils;

public class SearchTimingChartApp extends Application {
	private static final int STRING_LENGTH = 6;
	private static final int TIMING_ITERATIONS = 1_000;
	private static final int ARRAY_LENGTH_MULTIPLIER = 1_000;

	private static void update(XYChart.Series<Number, Number> series, int n, double t) {
		series.getData().add(new XYChart.Data<>(n, t));
	}

	private static void updateLater(XYChart.Series<Number, Number> series, int n, double t) {
		Platform.runLater(() -> {
			update(series, n, t);
		});
	}

	private static void requestTimeForGarbageCollector() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			System.gc();
			Thread.sleep(100);
		}
	}

	private static void kickInTheJustInTimeCompiler() {
		Random random = new Random();
		String key = "JIT";
		String[] array = StringTestUtils.toStringArray(
				StringTestUtils.createUniqueSortedStringList(() -> StringTestUtils.nextRandomString(random, key.length()+1), 1_000));
		Timeline linearSearchTimeline = createAlertTimeline("LinearSearch.findFirstIndexIn");
		Timeline binarySearchTimeline = createAlertTimeline("BinarySearch.findIndexInSorted");
		for (int i = 0; i < 10_000; i++) {
			linearSearchTimeline.play();
			LinearSearch.findFirstIndexIn(array, key);
			linearSearchTimeline.stop();

			binarySearchTimeline.play();
			BinarySearch.findIndexInSorted(array, key);
			binarySearchTimeline.stop();
		}
	}

	private static double time(Random random, String[] array, BiFunction<String[], String, Integer> search)
			throws InterruptedException {
		requestTimeForGarbageCollector();
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < TIMING_ITERATIONS; i++) {
			String key = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			search.apply(array, key);
		}
		long tDelta = System.currentTimeMillis() - t0;
		return (tDelta * 0.001) / TIMING_ITERATIONS;
	}

	private static Timeline createAlertTimeline(String headerPrefix) {
		return new Timeline(new KeyFrame(Duration.millis(1_000), (actionEvent) -> {
			Platform.runLater(() -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(headerPrefix + " is taking longer than expected.\nInfinite loop???");
				alert.showAndWait();
			});
		}));
	}

	private static Task<Void> createTask(int min, int maxInclusive, XYChart.Series<Number, Number> linearSearchSeries,
			XYChart.Series<Number, Number> binarySearchSeries) {
		Task<Void> result = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				Random random = new Random();

				Timeline linearSearchTimeline = createAlertTimeline("LinearSearch.findFirstIndexIn");
				Timeline binarySearchTimeline = createAlertTimeline("BinarySearch.findIndexInSorted");

				for (int n = min; n <= maxInclusive; n++) {

					int arrayLength = n * ARRAY_LENGTH_MULTIPLIER;
					List<String> unsorted = StringTestUtils.createUniqueStringList(
							() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
					String[] array = StringTestUtils.toStringArray(unsorted);

					linearSearchTimeline.play();
					double tLinear = time(random, array, LinearSearch::findFirstIndexIn);
					linearSearchTimeline.stop();
					updateLater(linearSearchSeries, n, tLinear);

					Arrays.sort(array);
					binarySearchTimeline.play();
					double tBinary = time(random, array, BinarySearch::findIndexInSorted);
					binarySearchTimeline.stop();
					updateLater(binarySearchSeries, n, tBinary);
				}
				return null;
			}
		};
		return result;
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Linear vs Binary Search Chart");
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Array Length (x " + ARRAY_LENGTH_MULTIPLIER + ")");
		yAxis.setLabel("Average Time (" + TIMING_ITERATIONS + " samples)");

		int min = 1;
		int maxInclusive = 10;
		int increment = 1;

		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(min);
		xAxis.setUpperBound(maxInclusive);
		xAxis.setTickUnit(increment);
		xAxis.setMinorTickCount(0);

		// TODO
		yAxis.setUpperBound(0.00003);

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Linear vs Binary Search");

		Scene scene = new Scene(lineChart, 640, 480);
		scene.getStylesheets().add(SearchTimingChartApp.class.getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

		kickInTheJustInTimeCompiler();
		
		XYChart.Series<Number, Number> linearSearchSeries = new XYChart.Series<>();
		linearSearchSeries.setName("Linear Search");
		lineChart.getData().add(linearSearchSeries);

		XYChart.Series<Number, Number> binarySearchSeries = new XYChart.Series<>();
		binarySearchSeries.setName("Binary Search");
		lineChart.getData().add(binarySearchSeries);

		Task<Void> task = createTask(min, maxInclusive, linearSearchSeries, binarySearchSeries);
		ForkJoinPool.commonPool().execute(task);
	}

	public static void main(String[] args) {
		launch(args);
	}
}