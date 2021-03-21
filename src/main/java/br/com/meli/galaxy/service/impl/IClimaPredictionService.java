package br.com.meli.galaxy.service.impl;

import java.util.List;

import br.com.meli.galaxy.model.ClimaPrediction;
import br.com.meli.galaxy.model.SimpleSolarSystem;
import br.com.meli.galaxy.service.ClimaPredictionService;

public class IClimaPredictionService implements ClimaPredictionService {

	@Override
	public List<ClimaPrediction> predict(Integer year) {
		var galaxy = new SimpleSolarSystem();
		
		return null;
	}
		

}
