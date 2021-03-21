package br.com.meli.galaxy.model;

import java.awt.Point;

import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.model.inter.CelestialObject;

public class Planet implements CelestialObject {
	
	private PlanetNameEnum planetName;
	private Integer speedGradesbyDay;
	private Integer orbitRadiousKm;
	
	
	public Planet(PlanetNameEnum planetName, Integer speedGradesbyDay, Integer orbitRadiousKm) {
		super();
		this.planetName = planetName;
		this.speedGradesbyDay = speedGradesbyDay;
		this.orbitRadiousKm = orbitRadiousKm;
	}

	@Override
	public Point getLocation(Integer day) {
		var grades = speedGradesbyDay + day;
		Double positionX =  Math.sin(grades) * orbitRadiousKm;
		Double positionY =  Math.cos(grades) * orbitRadiousKm;
		
		return new Point(positionX.intValue(), positionY.intValue());
	}

	public PlanetNameEnum getPlanetName() {
		return planetName;
	}
	
	public Integer getDaysByYear(Integer years) {
		return (years * 360) / Math.abs(speedGradesbyDay);
	}
}
