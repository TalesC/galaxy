package br.com.meli.galaxy.model;

import java.util.List;

public class SimpleSolarSystem {
	
	private List<Planet> planets;
	private Sun sun;
	
	
	public SimpleSolarSystem() {
		super();
		this.setSun();
	}

	
	public SimpleSolarSystem(List<Planet> planets) {
		super();
		this.planets = planets;
		this.setSun();
	}

	private void setSun() {
		this.sun = new Sun();
	}


	public List<Planet> getPlanets() {
		return planets;
	}


	public Sun getSun() {
		return sun;
	}

}
