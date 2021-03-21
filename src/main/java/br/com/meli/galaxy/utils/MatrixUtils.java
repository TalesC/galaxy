package br.com.meli.galaxy.utils;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

public class MatrixUtils {

	public static Boolean isCollinear(List<Point> locations) {
		Integer matrix[][] = new Integer[locations.size()][2];
		
		for(int x=0; x < locations.size(); x++) {
			matrix[x][0] = locations.get(x).x;
			matrix[x][1] = locations.get(x).y;
		}
		var area = applyShoelaceFormula(matrix);
		
		return area == 0;
	}

	//Gauss's Formula https://en.wikipedia.org/wiki/Shoelace_formula
	private static Integer applyShoelaceFormula(Integer[][] matrix) {
		var function1 = 0;
		var function2 = 0;
		
		for(int x = 0; x < matrix.length - 1; x++) {
			function1 = function1 + (matrix[x][0] * matrix[x+1][1]);
		}
		
		for(int x = 0; x < matrix.length - 1; x++) {
			function2 = function2 + (matrix[x][1] * matrix[x+1][0]);
		}
		
		var area = Math.abs(function1 - function2);
				
		return area;
	}
	 
	public static void main(String[] args) {
			var locations = Arrays.asList(
							new Point(2, 1),
							new Point(3, 4),
							new Point(5, 3),
							new Point(4, 3),
							new Point(2, 1));
			
			var isCollinear = isCollinear(locations);
			
			System.out.println("Is collinear: " + isCollinear);
	}
	
}
