package br.com.meli.galaxy.model.builder;

import java.util.Arrays;
import java.util.List;

import br.com.meli.galaxy.model.Planet;
import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.Sun;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public class SimpleSolarSystemBuilder {

	private List<Planet> planets;
	private Sun sun;
	
	public SimpleSolarSystemBuilder sun() {
		this.sun = new Sun();
		return this;
	}
	
	public SimpleSolarSystemBuilder planets() {
		this.planets = Arrays.asList(
							new Planet(PlanetNameEnum.FERENGE, 1, 500),
							new Planet(PlanetNameEnum.BETASOID, 3, 2000),
							new  Planet(PlanetNameEnum.VULCANO, -5, 1000));
		
		return this;
	}
	
	public SimpleSolarSystem build() {
		return new SimpleSolarSystem(this.planets, this.sun);
	}
}
