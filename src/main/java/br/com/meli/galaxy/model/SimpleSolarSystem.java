package br.com.meli.galaxy.model;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class SimpleSolarSystem {
	
	private List<CelestialObject> celestials;
	
	
	public SimpleSolarSystem(List<CelestialObject> celestials) {
		super();
		this.celestials = celestials;
	}


	public List<CelestialObject> getPlanets() {
		return this.celestials
					.stream()
					.filter(planet -> planet instanceof Planet)
					.collect(Collectors.toList());
	}


	public CelestialObject getSun() {
		return this.celestials
				.stream()
				.filter(celestial -> celestial instanceof Sun)
				.findFirst()
				.get();
	}
	
	
	public List<Point2D> getLocations() {
		List<Point2D> locations = this.celestials.stream()
				.map(celestial -> celestial.getLocation())
				.collect(Collectors.toList());
		
		return locations;
	}
}
