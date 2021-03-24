package br.com.meli.galaxy.service;

import java.util.List;

import br.com.meli.galaxy.model.ent.WeatherPrediction;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface WeatherPredictionGeneratorService {

	List<WeatherPrediction> predict(Integer year, PlanetNameEnum planetName);

}
