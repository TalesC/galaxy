package br.com.meli.galaxy.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

public class TriangleUtils {

	public static boolean contains(List<Point> vertices, Point point) {
		var coordenatesX = new int[vertices.size()];
		var coordenatesY = new int[vertices.size()];
		
		for(int x= 0; x < vertices.size(); x++) {
			coordenatesX[x] = vertices.get(x).x;
			coordenatesY[x] = vertices.get(x).y;
		}
		
		return new Polygon(coordenatesX, coordenatesY, 3).contains(point);
	}

}
