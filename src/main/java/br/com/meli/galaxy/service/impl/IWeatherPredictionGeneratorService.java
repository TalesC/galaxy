package br.com.meli.galaxy.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.meli.galaxy.service.WeatherVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private WeatherVerifyService weatherVerifyService;

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
										weatherVerifyService.verifyWeather(day, solarSystem)));
		}		
		return predictionsOfAPlanet;
	}


	private SimpleSolarSystem createSolarSystem() {
		return new SimpleSolarSystemBuilder()
							.planets()
							.sun()
							.build();
	}

}
