package br.com.meli.galaxy.model;

import java.awt.Point;

public class Sun extends CelestialObject {
	
	private static Point location = new Point(0, 0);

	@Override
	public Point getLocation() {
		return Sun.location;
	}
		
}
