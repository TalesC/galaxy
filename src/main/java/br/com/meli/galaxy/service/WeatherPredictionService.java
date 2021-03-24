package br.com.meli.galaxy.service;

import java.util.List;

import br.com.meli.galaxy.dto.WeatherPredictionDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface WeatherPredictionService {

	WeatherPredictionDTO findClimaByDay(Integer day, PlanetNameEnum planetName);

	List<WeatherPredictionDTO> findClimaByYear(Integer year, PlanetNameEnum planetName);

}
