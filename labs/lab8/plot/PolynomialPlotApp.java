package lab8.plot;

import java.util.List;
import java.util.function.Supplier;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lab8.Polynomial;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class PolynomialPlotApp extends Application {
	private final Supplier<Polynomial> polynomialCreator;

	public PolynomialPlotApp(Supplier<Polynomial> polynomialCreator) {
		this.polynomialCreator = polynomialCreator;
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle(this.getClass().getSimpleName());
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("x");

		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(-4.0);
		xAxis.setUpperBound(4.0);
		xAxis.setTickUnit(1.0);
		xAxis.setMinorTickCount(0);

		yAxis.setUpperBound(48.0);
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setLegendVisible(false);

		XYChart.Series<Number, Number> polynomialSeries = new XYChart.Series<>();
		polynomialSeries.setName("polynomial");
		lineChart.getData().add(polynomialSeries);

		XYChart.Series<Number, Number> derivativeSeries = new XYChart.Series<>();
		derivativeSeries.setName("derivative");

		TextField textField = new TextField();
		textField.setText("3x^2");

		Button plotButton = new Button("plot");
		plotButton.setDefaultButton(true);

		Label derivativeLabel = new Label("derivative: ");
		CheckBox isDerivativeShowing = new CheckBox("is showing?");

		isDerivativeShowing.setOnAction(e -> {
			lineChart.setAnimated(false);
			lineChart.setLegendVisible(isDerivativeShowing.isSelected());
			if (isDerivativeShowing.isSelected()) {
				lineChart.getData().add(derivativeSeries);
			} else {
				lineChart.getData().remove(derivativeSeries);
			}
			lineChart.setAnimated(true);
		});

		Region spacerA = new Region();
		spacerA.setPrefWidth(4);

		Region spacerB = new Region();
		spacerB.setPrefWidth(8);

		VBox controls = new VBox(10, new FlowPane(new Label("polynomial: "), textField, spacerA, plotButton),
				new FlowPane(derivativeLabel, spacerB, isDerivativeShowing));
		controls.setPadding(new Insets(10, 10, 10, 10));
		BorderPane pane = new BorderPane();
		pane.setCenter(lineChart);
		pane.setTop(controls);

		Scene scene = new Scene(pane, 640, 480);
		scene.getStylesheets().add(PolynomialPlotApp.class.getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

		plotButton.setOnAction((ae) -> {
			String text = textField.getText();
			List<Term> terms = PolynomialTermUtils.parseTerms(text);
			Polynomial polynomial = PolynomialTermUtils.create(polynomialCreator, terms);
			Polynomial derivative = polynomial.derivative();
			lineChart.setAnimated(false);
			polynomialSeries.getData().clear();
			derivativeSeries.getData().clear();
			for (double x = -4.0; x <= 4.0001; x += 0.25) {
				polynomialSeries.getData().add(new XYChart.Data<>(x, polynomial.evaluate(x)));
				derivativeSeries.getData().add(new XYChart.Data<>(x, derivative.evaluate(x)));
			}
			derivativeLabel.setText("derivative: " + derivative.toString());
			lineChart.setAnimated(true);
			yAxis.setLabel(polynomial.toString());
			// System.out.println(polynomial.toString());
		});

		plotButton.fire();
	}
}