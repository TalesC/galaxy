package br.com.meli.galaxy.model.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.meli.galaxy.model.Planet;
import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.Sun;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public class SimpleSolarSystemBuilder {

	private List<Planet> celestials;
	private Sun sun;
	
	public SimpleSolarSystemBuilder() {
		super();
		this.celestials = new ArrayList<>();
	}

	public SimpleSolarSystemBuilder sun() {
		this.sun = new Sun();
		return this;
	}
	
	public SimpleSolarSystemBuilder planets() {
		this.celestials.addAll(
				Arrays.asList(
				new Planet(PlanetNameEnum.FERENGE, 1, 500),
				new Planet(PlanetNameEnum.BETASOID, 3, 2000),
				new  Planet(PlanetNameEnum.VULCANO, -5, 1000))
		);
		
		return this;
	}
	
	public SimpleSolarSystem build() {
		return new SimpleSolarSystem(this.celestials, sun);
	}
}
