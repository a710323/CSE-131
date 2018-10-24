package lab6;

import sedgewick.StdDraw;

public class Triangles {
	
	public static void triangle(double llx,double lly,double size) {
		if(size<0.01) {
			return;
		}
		// I imagine that drawing white triangles on a black canvas.
		StdDraw.setPenColor(StdDraw.WHITE);
		double[] x = {llx+size/4, llx+size/2, llx+(size*3)/4};
		double[] y = {lly+size/2, lly, lly+size/2};
		StdDraw.filledPolygon(x, y);
		triangle(llx, lly, size/2);//left triangle
		triangle(llx+size/2, lly,size/2);//right triangle
		triangle(llx+size/4, lly+size/2, size/2);//upper triangle
	}

	public static void main(String[] args) {
		StdDraw.setPenColor(StdDraw.BLACK);
		double[] x = {0,0.5,1};
		double[] y = {0,1,0};
		StdDraw.filledPolygon(x, y);
		StdDraw.show(20);
		triangle(0,0,1);
		StdDraw.show(20);
	}
}
