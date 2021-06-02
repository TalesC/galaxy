package br.com.meli.galaxy.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.galaxy.config.GenerateWeatherDatabase;
import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.service.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.model.builder.SimpleSolarSystemBuilder;
import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.ent.WeatherPredictionId;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.repository.WeatherPredictionRepository;
import br.com.meli.galaxy.service.WeatherPredictionService;

@Service
public class IWeatherPredictionService implements WeatherPredictionService {

	private static final Logger LOG = LoggerFactory.getLogger(GenerateWeatherDatabase.class);

	@Autowired
	private WeatherPredictionRepository repository;
	
	@Override
	public WeatherPredictionDTO findWeatherByDay(Integer day, PlanetNameEnum planetName) {
		var id = new WeatherPredictionId(day, planetName);

		try {
			var prediction = repository.findById(id).orElse(null);

			if(prediction != null)
				return new WeatherPredictionDTO(prediction.getDay(), prediction.getWeather());

		}catch (DataAccessException e) {
			LOG.info(e.getMessage());
		}

		return null;
	}

	@Override
	public List<WeatherPredictionDTO> findWeatherByYear(Integer years, PlanetNameEnum planetName) {
		var solarSystem = this.createSolarSystem();
		var days = solarSystem.findPlanet(planetName).getDaysByYear(years);
		var predictions = new ArrayList<WeatherPredictionDTO>();

		try {
			predictions.addAll(
					repository.findByPlanet(planetName)
					.stream()
					.filter(prediction -> prediction.getDay() <= days)
					.sorted(Comparator.comparing(WeatherPrediction::getDay))
					.map(prediction -> new WeatherPredictionDTO(prediction.getDay(), prediction.getWeather()))
					.collect(Collectors.toList())
			);
		}catch (DataAccessException e) {
			LOG.info(e.getMessage());
		}
		return predictions;
	}
	
	private SimpleSolarSystem createSolarSystem() {
		return new SimpleSolarSystemBuilder()
							.planets()
							.sun()
							.build();
	}
	
		
}
