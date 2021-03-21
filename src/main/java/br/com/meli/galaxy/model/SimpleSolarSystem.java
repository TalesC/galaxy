package br.com.meli.galaxy.model;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.galaxy.model.inter.CelestialObject;

public class SimpleSolarSystem {
	
	private List<CelestialObject> celestials;
	private Sun sun;
	
	
	public SimpleSolarSystem(List<CelestialObject> celestials, Sun sun) {
		super();
		this.celestials = celestials;
		this.sun = sun;
	}


	public List<CelestialObject> getPlanets() {
		return this.celestials
					.stream()
					.filter(planet -> planet instanceof Planet)
					.collect(Collectors.toList());
	}


	public Sun getSun() {
		return this.sun;
	}
	
	
	public List<Point> getAllLocations(Integer day) {
		List<Point> locations = this.celestials.stream()
								.map(celestial -> celestial.getLocation(day))
								.collect(Collectors.toList());
		locations.add(this.sun.getLocation());
		
		return locations;
	}
	
	public List<Point> getLocationOfPlanets(Integer day) {
		var planets = getPlanets();
		
		return planets.stream()
				.map(celestial -> celestial.getLocation(day))
				.collect(Collectors.toList());
	}
	
}
