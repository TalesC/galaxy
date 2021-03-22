package br.com.meli.galaxy.model;

import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public class SimpleSolarSystem {
	
	private List<Planet> planets;
	private Sun sun;
	
	
	public SimpleSolarSystem(List<Planet> planets, Sun sun) {
		super();
		this.planets = planets;
		this.sun = sun;
	}


	public List<Planet> getPlanets() {
		return this.planets;
	}
	
	public Planet findPlanet(PlanetNameEnum planetName) {
		return this.planets.stream()
				.filter(planet -> planet.getPlanetName().equals(planetName))
				.findFirst()
				.get();
	}


	public Sun getSun() {
		return this.sun;
	}
	
	
	public List<Point> getAllLocations(Integer day) {
		List<Point> locations = this.planets.stream()
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
