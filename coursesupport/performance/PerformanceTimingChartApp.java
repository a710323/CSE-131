package performance;

import java.util.concurrent.ForkJoinPool;

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

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class PerformanceTimingChartApp extends Application {
	private final String title;
	private final String aSeriesName;
	private final String bSeriesName;
	private final String xAxisLabel;
	private final String yAxisLabel;
	private final int xAxisMin;
	private final int xAxisMaxInclusive;
	private final int xAxisIncrement;

	public PerformanceTimingChartApp(String title, String aSeriesName, String bSeriesName, String xAxisLabel,
			String yAxisLabel, int xAxisMin, int xAxisMaxInclusive, int xAxisIncrement) {
		this.title = title;
		this.aSeriesName = aSeriesName;
		this.bSeriesName = bSeriesName;
		this.xAxisLabel = xAxisLabel;
		this.yAxisLabel = yAxisLabel;
		this.xAxisMin = xAxisMin;
		this.xAxisMaxInclusive = xAxisMaxInclusive;
		this.xAxisIncrement = xAxisIncrement;
	}

	protected static void update(XYChart.Series<Number, Number> series, int n, double t) {
		series.getData().add(new XYChart.Data<>(n, t));
	}

	protected static void updateLater(XYChart.Series<Number, Number> series, int n, double t) {
		Platform.runLater(() -> {
			update(series, n, t);
		});
	}

	protected static void requestTimeForGarbageCollector() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			System.gc();
			Thread.sleep(100);
		}
	}

	protected static Timeline createAlertTimeline(String headerPrefix) {
		return new Timeline(new KeyFrame(Duration.millis(1_000), (actionEvent) -> {
			Platform.runLater(() -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(headerPrefix + " is taking longer than expected.\nInfinite loop???");
				alert.showAndWait();
			});
		}));
	}

	protected abstract Task<Void> createTask(NumberAxis xAxis, XYChart.Series<Number, Number> aSeries,
			XYChart.Series<Number, Number> bSeries);

	protected abstract void kickInTheJustInTimeCompiler();

	@Override
	public void start(Stage stage) {
		stage.setTitle(this.getClass().getSimpleName());
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel(xAxisLabel);
		yAxis.setLabel(yAxisLabel);

		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(xAxisMin);
		xAxis.setUpperBound(xAxisMaxInclusive);
		xAxis.setTickUnit(xAxisIncrement);
		xAxis.setMinorTickCount(0);

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle(this.title);

		Scene scene = new Scene(lineChart, 640, 480);
		scene.getStylesheets().add(PerformanceTimingChartApp.class.getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

		XYChart.Series<Number, Number> aSeries = new XYChart.Series<>();
		aSeries.setName(this.aSeriesName);
		lineChart.getData().add(aSeries);

		XYChart.Series<Number, Number> bSeries = new XYChart.Series<>();
		bSeries.setName(this.bSeriesName);
		lineChart.getData().add(bSeries);

		kickInTheJustInTimeCompiler();

		Task<Void> task = createTask(xAxis, aSeries, bSeries);
		ForkJoinPool.commonPool().execute(task);
	}
}