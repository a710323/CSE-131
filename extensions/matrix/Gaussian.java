package matrix;

public class Gaussian {

	Matrix coeff;
	Matrix constants;

	public Gaussian(Matrix matCoeff, Matrix matConst){
		this.coeff = matCoeff;
		this.constants = matConst;
	}


	/**
	 * The hard part!
	 * @return
	 */
	public Matrix getSolution(){
		int n = this.constants.getNumRows();
		for (int k = 0; k < n; k++) {
			int max = k;
			for(int i = k+1; i<n; i++) {
				if(Math.abs(this.coeff.values[i][k]) > Math.abs(this.coeff.values[max][k])){
					max = i;
				}
			}
			double[] temp = this.coeff.values[k];
			this.coeff.values[k] = this.coeff.values[max];
			this.coeff.values[max] = temp;
			
			double copy = this.constants.getValue(k, 0);
			this.constants.values[k][0] = this.constants.values[max][0];
			this.constants.values[max][0] = copy;

			for(int i = k+1; i<n; i++) {
				double factor = this.coeff.values[i][k] / this.coeff.values[k][k];
				this.constants.values[i][0] -= factor * this.constants.values[k][0];
				for(int j = k; j<n; j++) {
					this.coeff.values[i][j] -= factor * this.coeff.values[k][j];
				}
			}
		}
        double[][] x = new double[n][1];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += this.coeff.values[i][j] * x[j][0];
            }
            x[i][0] = (this.constants.values[i][0] - sum) / this.coeff.values[i][i];
        }
        for(int i = 0; i < x.length; i++) {
        	x[i][0] = Math.round(x[i][0] * 100) / 100;
        }
        Matrix d = new Matrix(x);
        return d;
	}

	public String toString(){
		String string ="";
		for(int i=0; i<this.coeff.getNumRows(); i++){
			string+="\n";
			for(int j=0; j<this.coeff.getNumCols()+1; j++){
				if(j==this.coeff.getNumCols()){
					string+= this.constants.getValue(i,0)+ "  ";
				}else{
					string+= this.coeff.getValue(i,j) + "  ";
				}
			}
		}
		System.out.println(string);

		return string;
	}

}
