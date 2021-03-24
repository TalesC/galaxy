package br.com.meli.galaxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.dto.WeatherPredictioDTO;
import br.com.meli.galaxy.model.ent.WeatherPredictionId;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.repository.WeatherPredictionRepository;
import br.com.meli.galaxy.service.WeatherPredictionService;

@Service
public class IWeatherPredictionService implements WeatherPredictionService {

	@Autowired
	private WeatherPredictionRepository repository;
	
	@Override
	public WeatherPredictioDTO findClimaByDay(Integer day, PlanetNameEnum planetName) {
		var id = new WeatherPredictionId(day, planetName); 		
		
		var prediction = repository.findById(id).orElse(null);
		if(prediction == null) return null;
		
		return new WeatherPredictioDTO(prediction.getDay(), prediction.getClima());
	}
	
		
}
