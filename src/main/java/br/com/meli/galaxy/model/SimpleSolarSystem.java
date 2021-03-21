package br.com.meli.galaxy.model;

import java.util.List;

public class SimpleSolarSystem {
	
	private List<Planet> planets;
	private Sun sun;
	
	
		public SimpleSolarSystem(List<Planet> planets, Sun sun) {
		super();
		this.planets = planets;
		this.sun = sun;
	}


	public List<Planet> getPlanets() {
		return planets;
	}


	public Sun getSun() {
		return sun;
	}

}
