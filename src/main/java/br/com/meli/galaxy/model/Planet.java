package br.com.meli.galaxy.model;

import java.awt.Point;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class Planet implements CelestialObject {
	
	private Integer speedGradesbyDay;
	private Integer orbitRadious;

	@Override
	public Point getLocation(Galaxy galaxy) {
		return null;
	}

}
