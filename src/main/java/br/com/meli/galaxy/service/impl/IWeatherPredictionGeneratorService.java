package br.com.meli.galaxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.builder.SimpleSolarSystemBuilder;
import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.enums.WeatherStatusEnum;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.service.WeatherPredictionGeneratorService;
import br.com.meli.galaxy.utils.MatrixUtils;
import br.com.meli.galaxy.utils.TriangleUtils;

@Service
public class IWeatherPredictionGeneratorService implements WeatherPredictionGeneratorService {

	@Override
	public List<WeatherPrediction> predict(Integer years, PlanetNameEnum planetName) {
		var solarSystem = this.createSolarSystem();
		var days = solarSystem.findPlanet(planetName).getDaysByYear(years);
		
		var predictions = predict(days, solarSystem, planetName);
		
		return predictions;
	}
	

	private List<WeatherPrediction> predict(Integer days,SimpleSolarSystem solarSystem,
										  PlanetNameEnum planetName) {
		
		var predictionsOfAPlanet = new ArrayList<WeatherPrediction>();
		
		for(int day = 1; day <= days; day++) {
			predictionsOfAPlanet.add(new WeatherPrediction(
										day,
										planetName,
										verifyWeather(day, solarSystem)));
		}		
		return predictionsOfAPlanet;
	}


	private WeatherStatusEnum verifyWeather(int day, SimpleSolarSystem solarSystem) {
		var clima = WeatherStatusEnum.NONE;
		
		if(planetsMakesTriangleWithSunInside(day, solarSystem)) clima = WeatherStatusEnum.RAIN;
		else
			if(planetsAlignWithSun(day, solarSystem)) clima = WeatherStatusEnum.DROUGHT;
			else
				if(planetsAlignWithoutSun(day, solarSystem)) clima = WeatherStatusEnum.OPTIMAL;
		
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
