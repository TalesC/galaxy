package br.com.meli.galaxy.service;

import br.com.meli.galaxy.dto.WeatherPredictioDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface WeatherPredictionService {

	WeatherPredictioDTO findClimaByDay(Integer day, PlanetNameEnum planetName);

}
