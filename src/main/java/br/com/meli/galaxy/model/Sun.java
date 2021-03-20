package br.com.meli.galaxy.model;

import java.awt.Point;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class Sun implements CelestialObject {
	
	@Override
	public Point getLocation(Galaxy galaxy) {
		var height  = galaxy.getDimension().height / 2;
		var width  = galaxy.getDimension().width / 2;
		
		return new Point(width, height);
	}

	
}
