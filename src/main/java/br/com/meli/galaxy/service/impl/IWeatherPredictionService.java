package br.com.meli.galaxy.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.builder.SimpleSolarSystemBuilder;
import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.ent.WeatherPredictionId;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.repository.WeatherPredictionRepository;
import br.com.meli.galaxy.service.WeatherPredictionService;

@Service
public class IWeatherPredictionService implements WeatherPredictionService {

	@Autowired
	private WeatherPredictionRepository repository;
	
	@Override
	public WeatherPredictionDTO findClimaByDay(Integer day, PlanetNameEnum planetName) {
		var id = new WeatherPredictionId(day, planetName); 		
		
		var prediction = repository.findById(id).orElse(null);
		if(prediction == null) return null;
		
		return new WeatherPredictionDTO(prediction.getDay(), prediction.getWeather());
	}

	@Override
	public List<WeatherPredictionDTO> findClimaByYear(Integer years, PlanetNameEnum planetName) {
		var solarSystem = this.createSolarSystem();
		var days = solarSystem.findPlanet(planetName).getDaysByYear(years);
		
		var predictions = repository.findByPlanet(planetName)
									.stream()
									.filter(prediction -> prediction.getDay() <= days)
									.sorted(Comparator.comparing(WeatherPrediction::getDay))
									.map(prediction -> new WeatherPredictionDTO(prediction.getDay(), prediction.getWeather()))
									.collect(Collectors.toList());
		
		return predictions;
	}
	
	private SimpleSolarSystem createSolarSystem() {
		return new SimpleSolarSystemBuilder()
							.planets()
							.sun()
							.build();
	}
	
		
}
