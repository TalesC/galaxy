package br.com.meli.galaxy.utils;

import java.awt.Point;
import java.util.List;

public class MatrixUtils {

	public static Boolean isCollinear(List<Point> locations) {
		Integer matrix[][] = new Integer[locations.size()][2];
		
		locations.forEach(location ->{
			matrix[locations.indexOf(location)][0] = location.x;
			matrix[locations.indexOf(location)][1] = location.y;
		});
		
		var area = applyShoelaceFormula(matrix);
		
		return area == 0;
	}

	//Gauss's Formula https://en.wikipedia.org/wiki/Shoelace_formula
	private static Integer applyShoelaceFormula(Integer[][] matrix) {
		var function1 = 0;
		var function2 = 0;
		
		for(int x = 0; x < matrix.length; x++) {
			function1 = function1 + (matrix[x][0] * matrix[x+1][1]);
		}
		
		for(int x = 0; x < matrix.length; x++) {
			function2 = function2 + (matrix[x][1] * matrix[x+1][0]);
		}
		
		var area = function1 - function2;
				
		return area;
	}
	 
	public static void main(String[] args) {
			var locations = new Arrays
	}
	
	

}
