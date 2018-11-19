package matrix;


public class Matrix {

	public double[][] values;
	
	/**
	 * The Matrix is based on the supplied two-dimensional array of values.
	 * Be sure to make your own copy of the values, so that changes to the
	 *    array outside of this class do not affect your work.
	 * @param values
	 */
	public Matrix(double[][] in) {
		this.values = new double[in.length][in[0].length];
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in[0].length; j++) {
				this.values[i][j] = in[i][j];
			}
		}
		// FIXME -- make a copy of in
		//  this is not the same thing as writing:
		//  values = in
	}

	public double getValue(int row, int col) {
		return this.values[row][col];  // Do not change this!
	}

	public int getNumRows() {
		return values.length;  // Do not change!
	}

	public int getNumCols() {
		return values[0].length; // Do not change!
	}

	/**
	 * You must complete this method, or the equals(Object) test will always
	 *   return false. 
	 * Arrays one and two are considered
	 * equal if and only if:
	 *   1) They have the same shape (number of rows and columns agree)
	 *   2) The contents of the two arrays are the same, element by element
	 * @param one
	 * @param two
	 * @return true iff the arrays have the same shape and contents
	 */
	private static boolean arraysAreEqual(double[][] one, double[][] two) {
		if (one.length != two.length) {
			return false;
		}
		if (one[0].length != two[0].length) {
			return false;
		}
		for (int i = 0; i < one.length; i++) {
			for (int j = 0; j < one[0].length; j++) {
				if (one[i][j] != two[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This was generated initially by eclipse, but
	 *   eclipse does not know how to compare two-dimensional arrays.
	 *   We therefore call arraysAreEequal to do that job.
	 */
	public boolean equals(Object obj) {
		// If this and obj are the same object, they must be equal
		if (this == obj)
			return true;
		// If obj is null ("this" cannot be null), then they are not equal
		if (obj == null)
			return false;
		// If the two objects are not the same type, they are not equal
		if (getClass() != obj.getClass())
			return false;
		//
		// If we get here, we have two objects of the same type.
		// Calling your helper method to determine the arrays' equality.
		Matrix other = (Matrix) obj;
		return arraysAreEqual(this.values, other.values);
	}

	public Matrix plus(Matrix other) {
		if (other.values.length != this.values.length) {
			throw new IllegalArgumentException("Not the case");
		}
		for(int i = 0; i < this.values.length; i++) {
			for(int j = 0; j< this.values[i].length; j++) {
				other.values[i][j] += this.values[i][j];
			}
		}
		Matrix newOne = new Matrix(other.values);
		return newOne;
	}

	/**
	 * Returns a **new Matrix** that is the product of this and the other one.
	 * Does not change this Matrix at all.
	 * @param other
	 * @return
	 */
	public Matrix times(Matrix other) {
		if (other.values.length != this.values[0].length) {
			throw new IllegalArgumentException();
		} 
		if (other.values[0].length != this.values.length) {
			throw new IllegalArgumentException();
		}
		double[][] copy = new double[this.values.length][other.values[0].length];
		for (int i = 0; i < this.values.length; i++) {
			for (int j = 0; j < other.values[0].length; j++) {
				for (int k = 0; k < this.values[0].length; k++) {
					copy[i][j] += this.values[i][k] * other.values[k][j];
				}
			}
		}
		Matrix newOne = new Matrix(copy);
		return newOne;
	}

	/**
	 * Returns a **new Matrix** that is the transpose of this one.
	 * Does not change this Matrix at all.
	 * @return
	 */
	public Matrix transpose() {
		double[][] copy = new double[this.values[0].length][this.values.length];
		for(int i =0; i < this.values.length; i++) {
			for(int j = 0; j < this.values[0].length; j++) {
				copy[j][i] = this.values[i][j];
			}
		}
		Matrix newOnw = new Matrix(copy);
		return newOnw;
	}

	/**
	 * Modifies this Matrix by scaling row i by the supplied factor.
	 * @param i the row to scale, where 0 is the top row
	 * @param factor the amount by which to scale each element of row i
	 */
	public void scaleRow(int i, double factor) {
		if (i >= this.values.length || i < 0) {
			throw new IllegalArgumentException();
		}
		for (int j = 0; j < this.values[i].length; j++) {
			this.values[i][j] = this.values[i][j] * factor;
		}
	}

	/**
	 * Modifies this matrix by adding row i to row j.  Row 0 is the top row.
	 * @param i
	 * @param j
	 */
	public void addRows(int i, int j) {
		for (int k = 0; k < this.values[i].length; k++) {
			this.values[j][k] += this.values[i][k];
		}
	}

	/**
	 * Modifies the Matrix by exchanging row i with row j
	 * @param i
	 * @param j
	 */
	public void exchangeRows(int i, int j){
		double[] copy = new double[this.values[i].length];
		for(int k = 0; k < this.values[i].length; k++) {
			copy[k] = this.values[i][k];
		}
		for(int m = 0; m < this.values[i].length; m++) {
			this.values[i][m] = this.values[j][m];
		}
		for(int n = 0; n < this.values[j].length; n++) {
			this.values[j][n] = copy[n];
		}
	}

	/**
	 * My gift to you.  This returns a String representation of
	 * the Matrix.  The contents of each row is separated by a tab (\t)
	 * so that columns (kind of) line up.  Each row is separated by a
	 * newline (\n) so that the output looks like a matrix.  The output
	 * of this method should <i>not</i> be used to compare matrices for
	 * equality:  use the .equals(Object) method instead!
	 */
	public String toString() {
		String ans = "";
		for (int i=0; i < values.length; ++i) {
			ans = ans + "\n";
			// Loop below assumes all rows have the same number of columns
			for (int j=0; j < values[0].length; ++j) {
				ans = ans + values[i][j] + "\t";
			}
		}
		return ans;
	}

}
