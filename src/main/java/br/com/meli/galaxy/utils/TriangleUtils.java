package br.com.meli.galaxy.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.List;

public class TriangleUtils {

	public static boolean contains(List<Point> vertices, Point point) {
		var triangle = createTriangle(vertices);		
		return triangle.contains((Point2D) point.clone());
	}
	
	private static Polygon createTriangle(List<Point> vertices) {
		var coordenatesX = new int[vertices.size()];
		var coordenatesY = new int[vertices.size()];
		
		for(int x= 0; x < vertices.size(); x++) {
			coordenatesX[x] = vertices.get(x).x;
			coordenatesY[x] = vertices.get(x).y;
		}
		var triangle = new Polygon(coordenatesX, coordenatesY, 3);
		
		return triangle;
	}

}
