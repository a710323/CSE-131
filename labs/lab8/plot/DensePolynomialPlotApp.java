package lab8.plot;

import lab8.DensePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DensePolynomialPlotApp extends PolynomialPlotApp {
	public DensePolynomialPlotApp() {
		super(DensePolynomial::new);
	}

	public static void main(String[] args) {
		launch(args);
	}
}