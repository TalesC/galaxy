package br.com.meli.galaxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.galaxy.dto.ClimaPredictioDTO;
import br.com.meli.galaxy.model.ent.ClimaPredictionId;
import br.com.meli.galaxy.model.enums.PlanetNameEnum;
import br.com.meli.galaxy.repository.ClimaPredictionRepository;
import br.com.meli.galaxy.service.ClimaPredictionService;

@Service
public class IClimaPredictionService implements ClimaPredictionService {

	@Autowired
	private ClimaPredictionRepository repository;
	
	@Override
	public ClimaPredictioDTO findClimaByDay(Integer day, PlanetNameEnum planetName) {
		var id = new ClimaPredictionId(day, planetName); 		
		
		var prediction = repository.findById(id).orElse(null);
		if(prediction == null) return null;
		
		return new ClimaPredictioDTO(prediction.getDay(), prediction.getClima());
	}
	
		
}
