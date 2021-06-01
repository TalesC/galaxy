package br.com.meli.galaxy.service;

import java.util.List;

import br.com.meli.galaxy.service.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface WeatherPredictionService {

	WeatherPredictionDTO findWeatherByDay(Integer day, PlanetNameEnum planetName);

	List<WeatherPredictionDTO> findWeatherByYear(Integer year, PlanetNameEnum planetName);

}
