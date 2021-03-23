package br.com.meli.galaxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.builder.SimpleSolarSystemBuilder;
import br.com.meli.galaxy.model.ent.ClimaPrediction;
import br.com.meli.galaxy.model.enums.ClimaStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.ClimaPredictionGeneratorService;
import br.com.meli.galaxy.utils.MatrixUtils;
import br.com.meli.galaxy.utils.TriangleUtils;

@Service
public class IClimaPredictionGeneratorService implements ClimaPredictionGeneratorService {

	@Override
	public List<ClimaPrediction> predict(Integer years, PlanetNameEnum planetName) {
		var solarSystem = this.createSolarSystem();
		var days = solarSystem.findPlanet(planetName).getDaysByYear(years);
		
		var predictions = predict(days, solarSystem, planetName);
		
		return predictions;
	}
	

	private List<ClimaPrediction> predict(Integer days,SimpleSolarSystem solarSystem,
										  PlanetNameEnum planetName) {
		
		var predictionsOfAPlanet = new ArrayList<ClimaPrediction>();
		
		for(int day=0; day < days; day++) {
			predictionsOfAPlanet.add(new ClimaPrediction(
										day,
										planetName,
										verifyClima(day, solarSystem)));
		}		
		return predictionsOfAPlanet;
	}


	private ClimaStatusEnum verifyClima(int day, SimpleSolarSystem solarSystem) {
		var clima = ClimaStatusEnum.NONE;
		
		if(planetsMakesTriangleWithSunInside(day, solarSystem)) clima = ClimaStatusEnum.RAIN;
		else
			if(planetsAlignWithSun(day, solarSystem)) clima = ClimaStatusEnum.DROUGHT;
			else
				if(planetsAlignWithoutSun(day, solarSystem)) clima = ClimaStatusEnum.OPTIMAL;
		
		return clima;
	}

	private boolean planetsAlignWithSun(int day, SimpleSolarSystem solarSystem) {
		var locations = solarSystem.getAllLocations(day);		
		var iscolinear = MatrixUtils.isCollinear(locations); 
		
		return iscolinear;
	}
	
	private boolean planetsMakesTriangleWithSunInside(int day, SimpleSolarSystem solarSystem) {
		var vertices = solarSystem.getLocationOfPlanets(day);
		var point = solarSystem.getSun().getLocation();
		var isInsideOfTriangle = TriangleUtils.contains(vertices, point);
		
		return isInsideOfTriangle;
	}
	
	private boolean planetsAlignWithoutSun(int day, SimpleSolarSystem solarSystem) {
		var locations = solarSystem.getLocationOfPlanets(day);		
		var iscolinear = MatrixUtils.isCollinear(locations); 
		
		return iscolinear;
	}

	private SimpleSolarSystem createSolarSystem() {
		return new SimpleSolarSystemBuilder()
							.planets()
							.sun()
							.build();
	}

}
