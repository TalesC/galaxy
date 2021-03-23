package br.com.meli.galaxy.service;

import java.util.List;

import br.com.meli.galaxy.model.ent.ClimaPrediction;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;

public interface ClimaPredictionService {

	List<ClimaPrediction> predict(Integer year, PlanetNameEnum planetName);

}
