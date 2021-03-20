package br.com.meli.galaxy.service;

import java.util.List;

import br.com.meli.galaxy.model.ClimaPrediction;

public interface ClimaPredictionService {

	List<ClimaPrediction> predictByYear(Integer year);

}
