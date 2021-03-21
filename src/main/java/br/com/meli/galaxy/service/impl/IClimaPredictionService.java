package br.com.meli.galaxy.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.meli.galaxy.model.ClimaPrediction;
import br.com.meli.galaxy.model.Planet;
import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.ClimaPredictionService;

public class IClimaPredictionService implements ClimaPredictionService {

	@Override
	public List<ClimaPrediction> predict(Integer year) {
		var solarSystem = this.createSolarSystem();
		
		
		
		return null;
	}

	private SimpleSolarSystem createSolarSystem() {
		var planets = createPlanets(); 
		var solarSystem = new SimpleSolarSystem(planets);
		
		return solarSystem;
	}
	
	private List<Planet> createPlanets(){
		return Arrays.asList(
					new Planet(PlanetNameEnum.FERENGE, 1, 500),
					new Planet(PlanetNameEnum.BETASOID, 3, 2000),
					new  Planet(PlanetNameEnum.VULCANO, -5, 1000)
				);
	}
		

}
