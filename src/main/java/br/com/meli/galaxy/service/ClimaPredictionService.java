package br.com.meli.galaxy.service;

import br.com.meli.galaxy.dto.ClimaPredictioDTO;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface ClimaPredictionService {

	ClimaPredictioDTO findClimaByDay(Integer day, PlanetNameEnum planetName);

}
