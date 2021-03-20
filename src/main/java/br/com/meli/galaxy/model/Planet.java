package br.com.meli.galaxy.model;

import java.awt.Point;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class Planet implements CelestialObject {
	
	private Integer speedGradesbyDay;
	private Integer orbitRadious;
	private Point location;
	
	
	public Planet(Integer speedGradesbyDay, Integer orbitRadious) {
		super();
		this.speedGradesbyDay = speedGradesbyDay;
		this.orbitRadious = orbitRadious;
	}

	@Override
	public Point getLocation() {
		return this.location;
	}

	public void setLocation(Galaxy galaxy, Integer day) {
		var grades = speedGradesbyDay + day;
		// using trigonometrics
		Double positionX =  Math.sin(grades) * orbitRadious;
		Double positionY =  Math.cos(grades) * orbitRadious;
		
		this.location = new Point(positionX.intValue(), positionY.intValue());
	}
	
	

}
