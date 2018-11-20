package lab9.plot;

import lab8.plot.PolynomialPlotApp;
import lab9.SparsePolynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class SparsePolynomialPlotApp extends PolynomialPlotApp {
	public SparsePolynomialPlotApp() {
		super(SparsePolynomial::new);
	}

	public static void main(String[] args) {
		launch(args);
	}
}