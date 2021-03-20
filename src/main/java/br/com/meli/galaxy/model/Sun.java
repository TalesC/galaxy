package br.com.meli.galaxy.model;

import java.awt.Point;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class Sun implements CelestialObject {
	
	private Point location;
	
	public Point getLocation() {
		return this.location;
	}

	public void setLocation(Galaxy galaxy) {
		var height  = galaxy.getDimension().height / 2;
		var width  = galaxy.getDimension().width / 2;
		
		this.location = new Point(width, height);
	}
		
}
