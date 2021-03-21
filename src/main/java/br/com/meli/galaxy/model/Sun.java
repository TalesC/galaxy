package br.com.meli.galaxy.model;

import java.awt.Point;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class Sun implements CelestialObject {
	
	private static Point location = new Point(0, 0);
	
	public Point getLocation() {
		return Sun.location;
	}
		
}
